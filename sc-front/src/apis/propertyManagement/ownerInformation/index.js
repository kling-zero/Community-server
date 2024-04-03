import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/property-manage/'

//业主信息

/**
 * 分页查询业主信息
 * @param data
 * data{
 *     ownerName
 *     roomNum
 *     phoneNum
 *     ownerId
 *     idCard
 * }
 * @returns {Promise}
 */
export function getOwnerInfo(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-owner-info', data)
}



/**
 * 分页查询楼栋信息
 * @param data
 * @returns {Promise}
 */
export function queryBuildingInfo(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-building-info', data)
}



/**
 * 查询业主详情
 * @param data
 * data{
 *     ownerId: ''
 * }
 * @returns {Promise}
 */
export function getOwnerDetail(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'show-detailed-owner-info', data)
}

/**
 * 添加物业信息
 * @param data
 * @returns {Promise}
 */
export function addOwner(data){
    return Request.requestForm(Request.POST, currBaseUrl + 'add-owner-info', data)
}

/**
 * 修改物业信息
 * @param data
 * @returns {Promise}
 */
export function modifyOwner(data){
    return Request.requestForm(Request.POST, currBaseUrl + 'modify-owner-info', data)
}

/**
 * 删除物业信息
 * @param data
 * @returns {Promise}
 */
export function deleteOwner(data){
    return Request.requestForm(Request.POST, currBaseUrl + 'delete-owner-info', data)
}
