import Request from "../request";

const currBaseUrl = '/roomRenovation/'

export const addBasic = data => Request.requestJson(Request.GET, currBaseUrl + 'add-Basic', data)

export const deleteBasic = data => Request.requestJson(Request.POST, currBaseUrl + 'delete-Basic', data)

export const deleteAllRecord = data =>  Request.requestJson(Request.POST, currBaseUrl + 'delete-allRecord', data)

export const queryAllBasic = data => Request.requestForm(Request.GET, currBaseUrl + 'query-allBasic', data)

export const queryAllDetail = data => Request.requestForm(Request.GET, currBaseUrl + 'query-allDetail', data)

export const queryAllRecord = data => Request.requestForm(Request.GET, currBaseUrl + 'query-allRecord', data)

export const queryAllRecordDetail = data => Request.requestForm(Request.POST, currBaseUrl + 'query-allRecordDetail', data)

export const updateBasic = data => Request.requestJson(Request.POST, currBaseUrl + 'update-Basic', data)