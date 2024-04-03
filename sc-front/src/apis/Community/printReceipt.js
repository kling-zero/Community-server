import Request from "../request";

const currBaseUrl = '/'

export const query = data => Request.requestForm(Request.GET, currBaseUrl + 'queryCar', data)

export const queryContract = data => Request.requestForm(Request.GET, currBaseUrl + 'queryContract', data)

export const queryFeeType = data => Request.requestForm(Request.GET, currBaseUrl + 'queryFeeType', data)

export const reprintReceipt = data => Request.requestForm(Request.GET, currBaseUrl + 'reprintReceipt', data)

