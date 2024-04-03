import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/hp/'


/**
 * 获取小区公告
 * @param data  小区id data{ communityId: ''}
 * @returns {Promise} 得到响应数据
 */
export function getBulletin(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'getBulletin', data)
}
/**
 *获取小区信息
 * @param data  小区id data{ communityId: ''}
 * @returns {Promise} 得到响应数据
 */
export function getCommunityInfo(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'getCommunityInfo', data)
}

/**
 * 投诉统计
 * @param data  小区id data{ communityId: ''}
 * @returns {Promise} 得到响应数据
 */
export function getComplaintCount(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'getComplaintCount', data)
}


/**
 * 注册统计
 * @param data  小区id data{ communityId: ''}
 * @returns {Promise} 得到响应数据
 */
export function getRegisterCount(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'getRegisterCount', data)
}

/**
 * 报修统计
 * @param data  小区id data{ communityId: ''}
 * @returns {Promise}得到响应数据
 */
export function getRepairCount(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'getRepairCount', data)
}
