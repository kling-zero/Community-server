import Request from "../request";

const currBaseUrl = '/transactions/Owner-member/'

export const queryOwnersMembers = data => Request.requestForm(Request.POST, currBaseUrl + 'query-Owners-members', data)

export const saveOwnerMembers = data => Request.requestJson(Request.POST, currBaseUrl + 'save-Owners-members', data)


export const updateOwnerMembers = data => Request.requestJson(Request.POST, currBaseUrl + 'update-Owners-members', data)


export const deleteupdateOwnerMembers = data => Request.requestJson(Request.POST, currBaseUrl + 'delete-Owners-members', data)

