import Request from '../../request'
import path from './path'

/**
 * 物业公司添加小区
 * @param address
 * @param communityIds
 * @param communityName
 * @param corporation
 * @param date
 * @param groupIds
 * @param isAll
 * @param memberId
 * @param nearybyLandmarks
 * @param storeName
 * @param tel
 * @param userId
 * @param storeId
 */
async function addCommunity(
  address,
  communityIds,
  communityName,
  corporation,
  date,
  groupIds,
  isAll,
  memberId,
  nearybyLandmarks,
  storeName,
  tel,
  userId,
  storeId
) {
  return await Request.requestForm(Request.PUT, path.addCommunity, {
    address,
    communityIds,
    communityName,
    corporation,
    date,
    groupIds,
    isAll,
    memberId,
    nearybyLandmarks,
    storeName,
    tel,
    userId,
    storeId
  })
}

/**
 * 添加物业
 * @param address - 地址
 * @param communityIds - 小区 ID 数组
 * @param corporation - 公司法人
 * @param date - 成立日期
 * @param groupIds - 小区选中的功能的id 数组
 * @param isAll - 是否为所有功能
 * @param memberId
 * @param name - 小区名称
 * @param nearybyLandmarks - 地标
 * @param staffId
 * @param tel - 电话
 * @param storeId
 */
async function insertProperty(
  address,
  communityIds,
  corporation,
  date,
  groupIds,
  isAll,
  memberId,
  name,
  nearybyLandmarks,
  staffId,
  tel,
  storeId
) {
  const { data } = await Request.requestForm(Request.PUT, path.insertProperty, {
    address,
    communityIds,
    corporation,
    date,
    groupIds,
    isAll,
    memberId,
    name,
    nearybyLandmarks,
    staffId,
    tel,
    storeId
  })
  return data
}

/**
 * 查询物业
 * @param pageIndex
 * @param pageSize
 * @param name
 * @param storeId
 * @param tel
 */
async function listProperty(pageIndex, pageSize, name, storeId, tel) {
  const { data } = await Request.requestForm(Request.GET, path.listProperty, {})
}

/**
 * 可加入小区回显
 * - 无参数
 */
async function queryAccessibleCommunities() {
  return await Request.requestForm(Request.GET, path.queryAccessibleCommunities)
}

/**
 * 查询某物业所管理的小区列表
 * @param pageIndex
 * @param pageSize
 * @param cityCode
 * @param communityId
 * @param memberId
 * @param name
 * @param storeId
 */
async function queryBelongingCommunities(
  pageIndex,
  pageSize,
  cityCode,
  communityId,
  memberId,
  name,
  storeId
) {
  return await Request.requestForm(
    Request.GET,
    path.queryBelongingCommunities,
    { pageIndex, pageSize, cityCode, communityId, memberId, name, storeId }
  )
}

/**
 * 退出小区
 * @param pageIndex
 * @param pageSize
 * @param cityCode
 * @param communityId
 * @param memberId
 * @param name
 * @param storeId
 */
async function quitCommunity(
  pageIndex,
  pageSize,
  cityCode,
  communityId,
  memberId,
  name,
  storeId
) {
  return await Request.requestForm(Request.POST, path.quitCommunity, {
    pageIndex,
    pageSize,
    cityCode,
    communityId,
    memberId,
    name,
    storeId
  })
}

/**
 * 删除物业公司
 * @param storeId
 */
async function removeProperty(storeId) {
  return await Request.requestForm(Request.DELETE, path.removeProperty, {
    storeId
  })
}

/**
 * 重置物业公司密码
 * @param address
 * @param communityIds
 * @param communityName
 * @param corporation
 * @param date
 * @param groupIds
 * @param isAll
 * @param memberId
 * @param nearybyLandmarks
 * @param storeName
 * @param tel
 * @param userId
 * @param storeId
 */
async function resetPwd(
  address,
  communityIds,
  communityName,
  corporation,
  date,
  groupIds,
  isAll,
  memberId,
  nearybyLandmarks,
  storeName,
  tel,
  userId,
  storeId
) {
  return await Request.requestForm(Request.POST, path.resetPwd, {
    address,
    communityIds,
    communityName,
    corporation,
    date,
    groupIds,
    isAll,
    memberId,
    nearybyLandmarks,
    storeName,
    tel,
    userId,
    storeId
  })
}

/**
 * 修改物业
 * @param address
 * @param corporation
 * @param name
 * @param nearybyLandmarks
 * @param tel
 * @param storeId
 */
async function updateProperty(
  address,
  corporation,
  name,
  nearybyLandmarks,
  tel,
  storeId
) {
  return await Request.requestForm(Request.POST, path.updateProperty, {
    address,
    corporation,
    name,
    nearybyLandmarks,
    tel,
    storeId
  })
}

/**
 * 修改小区功能
 * @param address
 * @param communityIds
 * @param communityName
 * @param corporation
 * @param date
 * @param groupIds
 * @param isAll
 * @param memberId
 * @param nearybyLandmarks
 * @param storeName
 * @param tel
 * @param userId
 * @param storeId
 */
async function updateMenu(
  address,
  communityIds,
  communityName,
  corporation,
  date,
  groupIds,
  isAll,
  memberId,
  nearybyLandmarks,
  storeName,
  tel,
  userId,
  storeId
) {
  return await Request.requestForm(Request.POST, path.updateMenu, {
    address,
    communityIds,
    communityName,
    corporation,
    date,
    groupIds,
    isAll,
    memberId,
    nearybyLandmarks,
    storeName,
    tel,
    userId,
    storeId
  })
}

/**
 * 限制物业登录
 * FIXME
 */
async function updateRestrictLogin() {
  return await Request.requestForm(Request.PUT, path.updateRestrictLogin, {})
}

export {
  addCommunity,
  insertProperty,
  listProperty,
  queryAccessibleCommunities,
  queryBelongingCommunities,
  quitCommunity,
  removeProperty,
  resetPwd,
  updateProperty,
  updateMenu,
  updateRestrictLogin
}
