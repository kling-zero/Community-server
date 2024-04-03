import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/sc-common-menu/'

/**
 * 菜单列表
 * @param  data  用户id data{userId:''}
 * @returns {Promise}
 */
export const menuList = (data) => {
  return Request.requestForm(
    Request.GET,
    currBaseUrl + 'menuList?userId=' + data.userId,
    data
  )
}

/**
 * 获取用户常用菜单列表
 * @param  data data{
 *      userId:'',
 *     pageIndex:'',
 *     pageSize:'',
 *     muId:'',
 *     name:'',
 *     seq:''
 * }
 * @returns {Promise}
 */
export const listMenuUser = (data) => {
  return Request.requestForm(
    Request.GET,
    currBaseUrl + 'listMenuUser?userId=' + data.userId,
    data
  )
}

/**
 * 添加常用菜单
 * @param  data data{
 *  userId:'',
 *   staffId:"“,
 *   name":"",
 *   icon:"",
 *   seq:"",
 *   mid:"",
 *   url:"”
 * }
 * @returns  {Promise}
 */
export const addMenuUser = (data) => {
  return Request.requestJson(
    Request.POST,
    currBaseUrl + 'saveMenuUser?userId=' + data.userId,
    data
  )
}

/**
 *
 * @param data  用户id data{
 *   userId:''
 *   muId:"“,
 *   mId":"",
 *   staffId:"",
 *   name:"",
 *   icon:"",
 *   seq:"”
 * }
 * @returns {Promise}
 */
export const delMenuUser = (data) => {
  return Request.requestJson(
    Request.DELETE,
    currBaseUrl + 'deleteMenuUser?userId=' + data.userId,
    data
  )
}
