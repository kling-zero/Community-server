import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/property-manage/'

//业主账户


/**
 * 查询业主账户
 * @param data
 * @returns {Promise}
 */
export function queryOwnerAccount(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-room-type',data)
}

/**
 * 查询账户类型
 * @returns {Promise}
 */
export function queryAccountType(){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-account-type',null)
}

/**
 * 查询账户明细
 * @param data
 * @returns {Promise}
 */
export function queryAccountDetail(data){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-account-detail',data)
}

/**
 * 预存账户
 * @param data
 *  data{
 *      ownerPhone,
 *      ownerName,
 *      preStorageAmount,
 *      acctType,
 *      remark
 *  }
 * @returns {Promise}
 */
export function preStorage(data){
    return Request.requestForm(Request.POST, currBaseUrl + 'pre-storage',null)
}

/**
 * 预存账户中用户列表
 * @returns {Promise}
 */
export function querySelectOwner(){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-select-owner',null)
}




