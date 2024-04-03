import Request from '../../request'
import path from './path'

async function queryCheckList(data){
    return Request.requestForm(Request.GET,path.queryCheckList,data)
}

async function queryCheckType(){
    return Request.requestForm(Request.GET,path.queryCheckType,{}) 
}

async function changeBindType(data){
    return Request.requestForm(Request.POST,path.changeBindType,data) 
}

export{
    queryCheckList,
    queryCheckType,
    changeBindType
}