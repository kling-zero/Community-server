import Request from '../request'
import { userStore } from '../../stores/user'
import {ElMessage} from "element-plus";

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/login/'

/**
 * 登录接口
 * @param data 登录数据
 * @param success 登录成功回调
 * @param fail 登录失败回调
 */
export const login = (data, success, fail) => {
  const $store = userStore()
    console.log(data)
  Request.requestForm(Request.POST, currBaseUrl + 'auth-login', data)
    .then((data) => {
      // 记录Token到本地
      if (data.data) {
        $store.setToken(data.data)
        // 执行成功回调
        success()
        return
      }
      // 执行失败回调
      fail()
    })
    .catch((err) => {
      // 执行失败回调
        if(err.data)
            fail(err.data.message)
        else
            fail("账号或密码错误")
    })
}

/**
 * 获取验证码
 * @returns {Promise}
 */
export const captcha = () => {
    return Request.requestForm(Request.GET, currBaseUrl + 'get-captcha', null)
}

/**
 * 获取用户
 * @returns {Promise}
 */
export const getUser = () => {

    return Request.requestForm(Request.GET, currBaseUrl + 'current-user', null)
}

/**
 * 获取菜单
 * @returns {Promise}
 */
export const getMenus = () => {
    return Request.requestForm(Request.GET, currBaseUrl + 'get-menus', null)
}

/**
 * 退出登录
 * @returns {Promise}
 */
export const logout = () => {
    return Request.requestForm(Request.GET, currBaseUrl + 'logout', null)
}

/**
 * 刷新登录
 * @param data  data{
 *     clientId : '',
 *     refreshToken :'',
 *     expiresIn: '',
 *     token : '',
 *     tokenHead :''
 * }
 *
 * @returns {Promise} 返回的值
 */
export const refreshToken = (data) => {
    return Request.requestForm(Request.POST, currBaseUrl + 'refresh-token', data)
}
