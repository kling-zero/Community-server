import Request from "../request";

const currBaseUrl = '/carStructure/'

export const listCarStructure = data => Request.requestForm(Request.GET, currBaseUrl + 'listCarStructure', data)

export const listRoomStructure = data => Request.requestForm(Request.GET, currBaseUrl + 'listRoomStructure', data)

export const listUnitsAndFloor = data => Request.requestForm(Request.GET, currBaseUrl + 'listUnitsAndFloor', data)

export const listUserMenu = data => Request.requestForm(Request.GET, currBaseUrl + 'listUserMenu', data)

