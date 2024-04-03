package com.zeroone.star.sclogin.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.constant.RedisConstant;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.login.LoginApis;
import com.zeroone.star.project.utils.tree.NodeMapper;
import com.zeroone.star.project.utils.tree.TreeNode;
import com.zeroone.star.project.utils.tree.TreeUtils;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.TreeNodeVO;
import com.zeroone.star.project.vo.login.LoginVO;
import com.zeroone.star.project.vo.login.MenuTreeVO;
import com.zeroone.star.sclogin.entity.User;
import com.zeroone.star.sclogin.service.IMenuService;
import com.zeroone.star.sclogin.service.IUserService;
import com.zeroone.star.sclogin.service.OAuthService;
import com.zeroone.star.sclogin.utils.CommonUtils;
import com.zeroone.star.project.utils.redis.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.zeroone.star.project.vo.JsonVO.fail;

/**
 * @Description 登录接口
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@RestController
@RequestMapping("login")
@Api(tags = "login")
@Slf4j
@RefreshScope
public class LoginController implements LoginApis {
    @Resource
    OAuthService oAuthService;
    @Resource
    UserHolder userHolder;

    @Autowired
    IUserService userService;

    @Resource
    private RedisUtils redisUtils;

    @ApiOperation(value = "授权登录")
    @PostMapping("auth-login")
    @Override
    public JsonVO<Oauth2TokenDTO> authLogin(LoginDTO loginDTO) {
        // 1. 获取Redis验证码，与LoginDTO验证码进行比对
        String captchaKey = CommonUtils.generateRedisKey(RedisConstant.CAPTCHA, loginDTO.getCode());
        if (!redisUtils.isExist(captchaKey)) {
            // 验证码验证失败
            return JsonVO.fail(null, ResultStatus.WRONG_CAPTCHA);
        }

        // 删除验证码，防止反复使用验证码登录
        if (redisUtils.del(captchaKey) < 0) {
            log.error("LoginController#authLogin error, Redis删除验证码失败，存在反复利用验证码登录的行为");
        }

        // 2. 将数据传输给OAuth模块的授权接口
        Map<String, String> params = new HashMap<>(5);
        params.put("grant_type", "password");
        params.put("client_id", loginDTO.getClientId());
        params.put("client_secret", "123456");
        params.put("username", loginDTO.getUsername());
        params.put("password", loginDTO.getPassword());

        // 3. 调用远程接口，获取Token
        JsonVO<Oauth2TokenDTO> oauth2Token = oAuthService.postAccessToken(params);

        // 4. 将授权token存储到Redis中，记录登录状态
        String userTokenKey = CommonUtils.genereateRedisTokenKey(oauth2Token.getData().getToken());
        if (redisUtils.add(userTokenKey, 1, 1L, TimeUnit.HOURS) < 0) {
            return JsonVO.fail(oauth2Token.getData(), ResultStatus.SERVER_ERROR);
        }

        // 4. 返回结果
        return oauth2Token;
    }


    /**
     * @author Suci
     * @createTime 2022/10/18 下午 3:33
     */
    @ApiOperation(value = "刷新登录")
    @PostMapping("refresh-token")
    @Override
    public JsonVO<Oauth2TokenDTO> refreshToken(Oauth2TokenDTO oauth2TokenDTO) {
        // 1. 判断Redis服务器是否存在token
        String oldTokenKey = CommonUtils.genereateRedisTokenKey(oauth2TokenDTO.getToken());
        if (!redisUtils.isExist(oldTokenKey)) {
            return JsonVO.fail(null, ResultStatus.UNAUTHORIZED);
        }

        // 2. 封装参数
        Map<String, String> params = new HashMap<>(4);
        params.put("grant_type", "refresh_token");
        params.put("client_id", oauth2TokenDTO.getClientId());
        params.put("client_secret", "123456");
        params.put("refresh_token", oauth2TokenDTO.getRefreshToken());

        // 3. 调用远程接口
        JsonVO<Oauth2TokenDTO> refreshedTokenDTO = oAuthService.postAccessToken(params);
        // 检查将要使用的参数是不是对的
        log.info("oAuthService.postAccessToken required data: {}", refreshedTokenDTO.getData().getToken());

        // 4. 用刷新后的Token更新Redis数据
        String refreshedTokenKey = CommonUtils.genereateRedisTokenKey(refreshedTokenDTO.getData().getToken());
        if (redisUtils.add(refreshedTokenKey, 1, 1L, TimeUnit.HOURS) < 0) {
            return JsonVO.fail(null, ResultStatus.SERVER_BUSY);
        }
        // 当添加新token之后才删除，这样避免删除成功，但是添加失败后，导致token被误删除
        if (redisUtils.del(oldTokenKey) < 0) {
            return JsonVO.fail(null, ResultStatus.SERVER_BUSY);
        }

        // 4. 返回结果
        return refreshedTokenDTO;
    }

    @ApiOperation(value = "获取当前用户")
    @GetMapping("current-user")
    @Override
    public JsonVO<LoginVO> getCurrUser() {
        UserDTO currentUser;
        try {
            currentUser = userHolder.getCurrentUser();
            // log.info("currentUser: {}", currentUser);
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), e.getMessage());
        }

        if (currentUser == null) {
            return fail(null, ResultStatus.UNAUTHORIZED);
        } else {

            // 获取用户其他信息
            User user = userService.getById(currentUser.getId());
            currentUser.setUserId(user.getUserId());
            currentUser.setEmail(user.getEmail());
            currentUser.setAddress(user.getAddress());
            currentUser.setLocationCD(user.getLocationCd());
            currentUser.setAge(user.getAge());
            currentUser.setSex(user.getSex());
            currentUser.setTel(user.getTel());
            currentUser.setLevelCd(user.getLevelCd());
            currentUser.setBId(user.getBId());
            currentUser.setStatusCd(user.getStatusCd());
            currentUser.setScore(user.getScore());

            LoginVO vo = new LoginVO();
            BeanUtil.copyProperties(currentUser, vo);
            // log.info("LoginVO: {}", vo);
            return JsonVO.success(vo);
        }
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("logout")
    @Override
    public JsonVO<String> logout() {
        // 1. 获取当前用户Token
        String userToken;
        try {
            userToken = userHolder.getCurrentUserToken();
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), e.getMessage());
        }
        if (StrUtil.isBlank(userToken)) {
            return JsonVO.fail(ResultStatus.UNAUTHORIZED.getMessage(), ResultStatus.UNAUTHORIZED);
        }

        // 2. 移除当前用户Token
        String userTokenKey = CommonUtils.genereateRedisTokenKey(userToken);
        if (redisUtils.del(userTokenKey) < 0) {
            return JsonVO.fail(ResultStatus.SERVER_ERROR.getMessage(), ResultStatus.SERVER_ERROR);
        }

        return JsonVO.success("退出操作成功" + ResultStatus.SUCCESS.getMessage());
    }


    @Value("${captcha.width}")
    private int captchaWidth;

    @Value("${captcha.height}")
    private int captchaHeight;

    @Value("${captcha.codeCount}")
    private int codeCount;

    @Value("${captcha.lineCount}")
    private int lineCount;


    /**
     * @author  Suci
     * @createTime 2022/10/18 上午 9:04
     * @desc  生成验证码
     */
    @ApiOperation("生成验证码")
    @GetMapping ("get-captcha")
    @Override
    public JsonVO getCaptcha() {
        // 1. 生成验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaWidth, captchaHeight, codeCount, lineCount);
        String captcha = lineCaptcha.getCode();
        log.info("captcha code: {}", captcha);

        String imageBase64 = lineCaptcha.getImageBase64();
        log.info("imageBase64: {}", imageBase64);

        // 2. 将验证码放到redis，有效时间为60s
        String redisKey = CommonUtils.generateRedisKey(RedisConstant.CAPTCHA, captcha);

        if (redisUtils.add(redisKey, captcha, 60L, TimeUnit.SECONDS) < 0) {
            return JsonVO.fail(null, ResultStatus.SERVER_ERROR);
        }


        // 3. 返回Base64格式数据
        Map<String, Object> data = new HashMap<>();
        data.put("imageBase64", "data:image/jpg;base64," + imageBase64);
        data.put("captcha", captcha);
        return JsonVO.success(data);
    }



    @Resource
    IMenuService menuService;

    @Resource
    NodeMapper<MenuTreeVO> nodeMapper;

    @ApiOperation(value = "获取菜单")
    @GetMapping("get-menus")
    @Override
    public JsonVO<List<TreeNodeVO<MenuTreeVO>>> getMenus() throws Exception {
        //1 获取当前用户
        UserDTO currentUser = userHolder.getCurrentUser();

        //2 获取当前用户拥有的菜单
        List<MenuTreeVO> menus = menuService.listMenuByRoleName(currentUser.getRoles());

        //3 转换树形结构
        List<TreeNode<MenuTreeVO>> treeNodes = TreeUtils.listToTree(menus, nodeMapper);

        //4 转换成VO数据
        List<TreeNodeVO<MenuTreeVO>> tree = new ArrayList<>();
        for (TreeNode<MenuTreeVO> sub : treeNodes) {
            TreeNodeVO<MenuTreeVO> one = new TreeNodeVO<>();
            BeanUtil.copyProperties(sub, one);
            tree.add(one);
        }

        return JsonVO.success(tree);
    }
}
