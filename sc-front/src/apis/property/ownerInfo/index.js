import { pa } from 'element-plus/es/locale'
import Request from '../../request'
import path from './path'



async function showDetailedOwnerInfo(data){
    return Request.requestForm(Request.GET,path.showDetailedOwnerInfo,data)
}

async function queryOwnerInfo(data){
    return Request.requestForm(Request.GET,path.queryOwnerInfo,data)
}

async function queryBuildingInfo(){
    return Request.requestForm(Request.GET,path.queryBuildingInfo,{})
}
async function addOwnerInfo(data){
    return Request.requestForm(Request.GET,path.addOwnerInfo,data)
}

async function modifyOwnerInfo(data){
    return Request.requestForm(Request.POST,path.modifyOwnerInfo,data)
}

async function deleteOwnerInfo(data){
    return Request.requestForm(Request.POST,path.deleteOwnerInfo,data)
}

async function unbindHouseInfo(data){
    return Request.requestForm(Request.POST,path.unbindHouseInfo,data)
}

export{
    showDetailedOwnerInfo,
    queryOwnerInfo,
    queryBuildingInfo,
    addOwnerInfo,
    modifyOwnerInfo,
    deleteOwnerInfo,
    unbindHouseInfo
}
