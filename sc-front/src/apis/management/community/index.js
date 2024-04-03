import Request from '../../request'
import path from './path'

/**
 * 添加小区
 * @param address         - 小区地址
 * @param areaAddress     - 小区所在地区
 * @param cityCode        - 城市编码
 * @param communityName   - 小区名称
 * @param feePrice        - 每月单价
 * @param nearbyLandmarks - 附近地标
 * @param payFeeMonth     - 缴费周期
 * @param tel             - 联系方式
 */
async function addCommunity(
  address,
  areaAddress,
  cityCode,
  communityName,
  feePrice,
  nearbyLandmarks,
  payFeeMonth,
  tel
) {
  return await Request.requestForm(Request.PUT, path.addCommunity, {
    address,
    areaAddress,
    cityCode,
    communityName,
    feePrice,
    nearbyLandmarks,
    payFeeMonth,
    tel
  })
}

/**
 * 获取小区已选功能
 * @param pageIndex   - 查询页码
 * @param pageSize    - 查询条数
 * @param cityCode    - 城市编码
 * @param communityId - 小区 ID
 * @param memberId
 * @param name        - 小区名称
 * @param storeId     - 物业 ID
 */
async function listCommunityMenu(
  pageIndex,
  pageSize,
  cityCode,
  communityId,
  memberId,
  name,
  storeId
) {
  return await Request.requestForm(Request.GET, path.listCommunityMenu, {
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
 * 获取小区功能的所有可选项
 * - 无参数
 */
async function listMenuGroup() {
  return await Request.requestForm(Request.GET, path.listMenuGroup, {})
}

/**
 * 查询小区
 * @param cityCode    - 城市编码
 * @param communityId - 小区 ID
 * @param memberId
 * @param name        - 小区名称
 * @param pageIndex   - 查询页码
 * @param pageSize    - 查询条数
 * @param storeId     - 物业 ID
 */
async function listCommunity(
  pageIndex,
  pageSize,
  cityCode,
  communityId,
  memberId,
  name,
  storeId
) {
  return await Request.requestForm(Request.GET, path.listCommunity, {
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
 * 修改小区信息
 * @param address         - 小区地址
 * @param cityCode        - 城市编码
 * @param communityId     - 小区 ID
 * @param feePrice        - 每月单价
 * @param name            - 小区名称
 * @param nearbyLandmarks - 附近地标
 * @param payFeeMonth     - 缴费周期
 * @param tel             - 联系方式
 */
async function modifyById(
  address,
  cityCode,
  communityId,
  feePrice,
  name,
  nearbyLandmarks,
  payFeeMonth,
  tel
) {
  return await Request.requestJson(Request.POST, path.modifyById, {
    address,
    cityCode,
    communityId,
    feePrice,
    name,
    nearbyLandmarks,
    payFeeMonth,
    tel
  })
}

export {
  addCommunity,
  listCommunityMenu,
  listMenuGroup,
  listCommunity,
  modifyById
}
