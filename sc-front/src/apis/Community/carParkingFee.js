import Request from "../request";

const currBaseUrl = '/parkingFee/'

/**
 * 获取停吃费用列表
 * @param {*} data 页码数据
 * @returns Promise
 */
export function queryAll (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'query-all', data)
}

export const saveFee = data => Request.requestJson(Request.POST, currBaseUrl + 'saveFee', data)

export const updateFee = data => Request.requestJson(Request.POST, currBaseUrl + 'updateFee', data)


export const finishFee = data => Request.requestJson(Request.POST, currBaseUrl + 'finishFee', data)

// 删除收费
export const deleteFee = data => Request.requestJson(Request.POST, currBaseUrl + 'deleteFee', data)

