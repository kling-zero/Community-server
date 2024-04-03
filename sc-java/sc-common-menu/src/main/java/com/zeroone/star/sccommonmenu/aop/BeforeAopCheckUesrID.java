package com.zeroone.star.sccommonmenu.aop;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.zeroone.star.sccommonmenu.model.BaseContext;
import com.zeroone.star.sccommonmenu.model.exception.MenuUserException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author j1-tao
 * 检查是否当前请求中是否存在用户userId
 */
@Component
@Aspect
@Slf4j
public class BeforeAopCheckUesrID {

    @Pointcut("execution(public * com.zeroone.star.sccommonmenu..controller..*.*(..))")
    public void pointCutRestDef(){
    }

    @Before("pointCutRestDef()")
    public void processRst() throws Throwable{
        String currentId = BaseContext.getCurrentId();
        if (StringUtils.isEmpty(currentId)){
            throw new MenuUserException("请先登录");
        }
    }
}
