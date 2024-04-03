import { da } from "element-plus/es/locale";
import Request from "../request";

const currBaseUrl = '/carInfo/'

export const addInfo = data => Request.requestJson(Request.PUT, currBaseUrl + 'addInfo', data)

export const queryAll = data => Request.requestForm(Request.GET, currBaseUrl+ 'carInfos', data)

export const deleteInfo = data => Request.requestForm(Request.DELETE, currBaseUrl + 'deleteInfo', data)

export const getSpaces = data => Request.requestForm(Request.GET, currBaseUrl + 'getSpaces' , data)

export const modifyInfo = data => Request.requestJson(Request.POST, currBaseUrl + 'modifyInfo', data)

export const modifyState = data => Request.requestJson(Request.POST, currBaseUrl+ 'modifyState', data)