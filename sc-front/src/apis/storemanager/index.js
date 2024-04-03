import Request from "@/apis/request";
import axios from "axios";

// 定义一个功能模块基础url，方便替换
const currBaseUrl = '/store/'



//获得所有商户的信息
export const getStores = (args) => {
    return Request.requestJson(Request.GET, currBaseUrl + 'getStores', args)
}

export const getAllAdmins = (args) => {
    return Request.requestJson(Request.GET, currBaseUrl + 'getAllAdmins', args)
}

export const queryAllSubCommunities = (args) => {
    return Request.requestJson(Request.GET, currBaseUrl + 'queryAllSubCommunities', args)
}

export const getAllStoreTypes = () =>{
    return Request.requestJson(Request.GET, currBaseUrl + 'getAllStoreTypes', null)
}

// 限制/解除限制登录
export const modifyRestrict = (id) => {
    // return axios.post(currBaseUrl+"modifyRestrict", id)
    return Request.requestForm(Request.POST, currBaseUrl+'modifyRestrict', id)
}




