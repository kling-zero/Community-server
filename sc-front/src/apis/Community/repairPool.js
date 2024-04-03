import Request from "../request";

const currBaseUrl = '/sccommunity/r-repair-pool/'

export const add = data => Request.requestJson(Request.POST, currBaseUrl + 'add-owner-epair', data)

export const query = data => Request.requestForm(Request.GET, currBaseUrl + 'query-all', data)

export const queryRepairSetting = data => Request.requestJson(Request.POST, currBaseUrl + 'query-allRepairSetting', data)

export const queryAllRepairStaff = data => Request.requestJson(Request.POST, currBaseUrl + 'query-allRepairStaff', data)

