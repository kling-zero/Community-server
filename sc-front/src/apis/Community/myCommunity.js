import Request from "../request"

const currBaseUrl = '/community/communitys/'

export const queryStoreCommunitys = (data) => {
    return Request.requestForm(Request.GET, currBaseUrl + 'queryStoreCommunitys', data)
}

export const updateStoreCommunity = data => Request.requestJson(Request.PUT, currBaseUrl + 'updateStoreCommunity', data)

export const getCommunityId = (data) => {
    return Request.requestForm(Request.GET, currBaseUrl + 'getCommunityId', data)
}