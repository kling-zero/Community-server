import Request from '../../request'
import path from './path'


async function queryShopList(data){
    return Request.requestForm(Request.GET,path.queryShopList,data)
}

async function queryShopState(){
    return Request.requestForm(Request.GET,path.queryShopState,{}) 
}

async function queryBuilding(){
    return Request.requestForm(Request.GET,path.queryBuilding,{}) 
}

async function addShopPost(data){
    return Request.requestForm(Request.POST,path.addShopPost,data) 
}

async function modifyPost(data){
    return Request.requestForm(Request.POST,path.modifyPost,data) 
}

async function deletePost(data){
    return Request.requestForm(Request.POST,path.deletePost,data) 
}

export{
    queryShopList,
    queryShopState,
    queryBuilding,
    addShopPost,
    modifyPost,
    deletePost
}