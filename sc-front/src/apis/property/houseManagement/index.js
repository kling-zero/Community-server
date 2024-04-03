import Request from '../../request'
import path from './path'

/**
 * 房屋状态接口
 */
async function queryRoomState(){
    return Request.requestForm(Request.GET,path.queryRoomState,{})
}

/**
 * 房屋类型接口 
 */
async function queryRoomType(){
    return Request.requestForm(Request.GET,path.queryRoomType,{}) 
}

export{
    queryRoomState,
    queryRoomType
}