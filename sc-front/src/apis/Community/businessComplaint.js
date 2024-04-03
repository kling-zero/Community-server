import Request from "../request";

const currBaseUrl = '/sccommunity/business-complaint/'

export const add = data => Request.requestJson(Request.POST, currBaseUrl + 'add-complaint-step-binding', data)

export const query = data => Request.requestForm(Request.GET, currBaseUrl + 'query-all', data)

export const queryWorkFlowAuditInfo = data => Request.requestJson(Request.POST, currBaseUrl + 'query-workflow-audit-info', data)

export const queryWorkFlowImage = data => Request.requestJson(Request.POST, currBaseUrl + 'query-workflow-image', data)

