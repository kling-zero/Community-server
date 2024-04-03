import Request from '../request'

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/property-manage/'

//房屋管理

/**
 * 房屋状态接口
 * @returns {Promise}
 */
export function queryRoomState(){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-room-state', null)
}

/**
 * 房屋类型
 * @returns {Promise}
 */
export function queryRoomType(){
    return Request.requestForm(Request.GET, currBaseUrl + 'query-room-type', null)
}





