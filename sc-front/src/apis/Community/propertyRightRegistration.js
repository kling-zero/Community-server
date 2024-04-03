import Request from "../request";

const currBaseUrl = '/propertyRightRegistration/'

export const addProperty = data => Request.requestJson(Request.POST, currBaseUrl + 'add-Property', data)

export const deletePorperty = data => Request.requestJson(Request.POST, currBaseUrl + 'delete-Property', data)

export const updateProperty = data => Request.requestJson(Request.POST, currBaseUrl + 'update-Property', data)

export const updatePropertyDetail = data => Request.requestJson(Request.POST, currBaseUrl + 'update-Property-Detail', data)

export const listPropertyRightRegistration = data => Request.requestForm(Request.GET, currBaseUrl + 'listPropertyRightRegistration', data)

export const listPropertyRightRegistrationDetail = data => Request.requestForm(Request.GET, currBaseUrl + 'listPropertyRightRegistrationDetail', data)