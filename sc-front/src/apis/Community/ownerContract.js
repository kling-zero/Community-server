import Request from "../request";

const currBaseUrl = '/parkingFee/'

export const queryContract = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContract', data)

// 
export const queryContractByObj = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContractByObj', data)


export const queryContractDetail = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContractDetail', data)


export const queryContractFile = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContractFile', data)


export const queryContractPartya = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContractPartya', data)


export const queryContractRoom = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContractRoom', data)


export const queryContractType = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContractType', data)


export const saveContract = data => Request.requestJson(Request.POST, currBaseUrl + 'saveContract', data)


export const updateContract = data => Request.requestJson(Request.POST, currBaseUrl + 'updateContract', data)


export const deleteContract = data => Request.requestJson(Request.POST, currBaseUrl + 'deleteContract', data)


export const printContractPartya = data => Request.requestForm(Request.GET, currBaseUrl + 'printContractPartya', data)

