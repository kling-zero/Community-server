import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/property-manage/'

//业主成员

/**
 * 查询业主成员列表
 * @returns {Promise}
 */
export function queryOwnerList(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-owner-list', data)
}
