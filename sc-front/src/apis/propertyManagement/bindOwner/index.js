import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/property-manage/'


//绑定业主


export function queryRoomState(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-check-list', data)
}


/**
 * 查询
 * @param data
 * @returns {Promise}
 */
export function queryCheckType(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-check-type', data)
}


/**
 *
 * @param data
 * data{
 *     "appUserID" : "",
 *     "operation" : "" //0表示删除,1表示重置密码
 * }
 * @returns {Promise}
 */
export function checkBindType(data){
    return Request.requestJson(Request.POST, currBaseUrl + 'change-bind-type', data)
}
