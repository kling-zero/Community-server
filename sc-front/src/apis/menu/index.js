import Request from "../request"

//权限维护展示相关路径前缀
const privilegeBaseUrl = '/privilege/'

//菜单组展示相关路径前缀
const menuGroupBaseUrl = '/MenuGroup/'

//菜单维护展示路径前缀
const menuBaseUrl = '/menu/'

/**
 * 删除权限
 * @returns {Promise}
 */
export const deletePrivilege = () => {
    return Request.requestJson(Request.POST, privilegeBaseUrl + 'delete',  null)
}

/**
 * 新增权限信息
 * @returns {Promise}
 */
export const insertPrivilege = () => {
    return Request.requestJson(Request.POST, privilegeBaseUrl + 'insert',  null)
}

/**
 * 查询权限信息
 * @returns {Promise}
 */
export const queryPrivilegeById = () => {
    return Request.requestForm(Request.GET, privilegeBaseUrl + 'queryById',  null)
}

/**
 * 修改信息
 * @returns {Promise}
 */
export const updatePrivilege = () => {
    return Request.requestJson(Request.POST, privilegeBaseUrl + 'update',  null)
}

//菜单组相关接口

/**
 * 删除组信息
 * @returns {Promise}
 */
export const deleteMenuGroup = () => {
    return Request.requestJson(Request.POST, menuGroupBaseUrl + 'deleteMenugroup',  null)
}

/**
 * 新增组
 * @returns {Promise}
 */
export const insertMenuGroup = () => {
    return Request.requestJson(Request.POST, menuGroupBaseUrl + 'insertMenugroup',  null)
}

/**
 * 查询组信息
 * @returns {Promise}
 */
export const queryMenuGroup = () => {
    return Request.requestForm(Request.GET, menuGroupBaseUrl + 'queryselectList',  null)
}
/**
 * 修改组信息
 * @returns {Promise}
 */
export const updateMenuGroup = () => {
    return Request.requestJson(Request.POST, menuGroupBaseUrl + 'updateMenugroup',  null)
}


//菜单维护展示相关

/**
 * 删除信息
 * @returns {Promise}
 */
export const deleteMenu = () => {
    return Request.requestJson(Request.POST, menuBaseUrl + 'delete',  null)
}

/**
 * 新增菜单
 * @returns {Promise}
 */
export const insertMenu = () => {
    return Request.requestJson(Request.POST, menuBaseUrl + 'insert',  null)
}

/**
 * 查询信息
 * @returns {Promise}
 */
export const queryMenu= () => {
    return Request.requestForm(Request.GET, menuBaseUrl + 'queryById',  null)
}
/**
 * 修改信息
 * @returns {Promise}
 */
export const updateMenu = () => {
    return Request.requestJson(Request.POST, menuBaseUrl + 'update',  null)
}
