import Request from '../../request'
import path from './path'


async function queryOwnerAccount(data){
    return Request.requestForm(Request.GET,path.queryOwnerAccount,data)
}

async function queryAccountType(){
    return Request.requestForm(Request.GET,path.queryAccountType,{}) 
}

async function queryAccountDetail(data){
    return Request.requestForm(Request.GET,path.queryAccountDetail,data) 
}

async function preStorage(data){
    return Request.requestForm(Request.POST,path.preStorage,data) 
}

async function querySelectOwner(){
    return Request.requestForm(Request.GET,path.querySelectOwner,{}) 
}

export{
    queryOwnerAccount,
    queryAccountType,
    queryAccountDetail,
    preStorage,
    querySelectOwner
}