import Request from "../request"

const currBaseUrl = '/transactions/building-fee/'

// 创建费用
export function addFee (data) {
    return Request.requestJson(Request.POST, currBaseUrl + 'add-fee', data)
}

// 临时收费
export function addTempFee(data){
    return Request.requestJson(Request.POST, currBaseUrl + 'add-temp-fee', data)
}

// 手工结束费用
export function finishFeeById (data){
    return Request.requestJson(Request.POST, currBaseUrl + 'finish-fee-by-id', data)
}

// 代收费用接口
export function modifyFee (data) {
    return Request.requestJson(Request.POST, currBaseUrl + 'modify-fee', data)
}

// 查询房屋费用
export function queryAll (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'query-all', data)
}

//根据费用类型查询费用
export function queryConfigId (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'query-configId', data)
}

export function removeFeeById (data) {
    return Request.requestJson(Request.POST, currBaseUrl + 'remove-fee-by-id', data)
}

// 根据抄表类型查询数据对象接口
export function queryObj (data) {
    return Request.requestJson(Request.POST, currBaseUrl + 'query-obj', data)
}

// 查询抄表类型
export function queryMeterReading (data) {
    return Request.requestJson(Request.POST, currBaseUrl + 'query-meter-reading', data)
}

// 提交水电抄表接口
export function addWeMeterReading (data) {
    return Request.requestJson(Request.POST, currBaseUrl + 'add-we-meter-reading', data)
}