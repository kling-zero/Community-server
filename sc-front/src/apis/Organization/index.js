import Request from "../request";

const currBaseUrl = '/setting/'

// 用户权限
export function addRole (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/addRole', data)
}

export function deleteMenu (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/deleteMenu', data)
}

export function deleteRole (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/deleteRole', data)
}

export function insertMenu (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/insertMenu', data)
}

export function listAllRoles (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'userPrivilege/listAllRoles', data)
}

export function updateRole (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/updateRole', data)
}

// 组织信息

export function associateEmployees (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'OrganizationalInformation/associateEmployees',data)
}

export function deleteOrganization (data) {
    return Request.requestForm(Request.DELETE, currBaseUrl + 'OrganizationalInformation/deleteOrganization',data)
}

export function getOrganizations (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'OrganizationalInformation/getOrganizations',data)
}

export function insertOrganization (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'OrganizationalInformation/insertOrganization',data)
}

export function queryNotAssociatedPersonnelByName (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'OrganizationalInformation/queryNotAssociatedPersonnelByName',data)
}

export function queryPersonnelByName (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'OrganizationalInformation/queryPersonnelByName',data)
}

export function updateOrganization (data) {
    return Request.requestForm(Request.PUT, currBaseUrl + 'OrganizationalInformation/updateOrganization',data)
}

// 角色和功能关联

export function deleteRoleAssFunction (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/deleteRoleAssFunction',data)
}

export function listRoleNotFunction (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'userPrivilege/listRoleNotFunction',data)
}

export function roleAssFunction (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/roleAssFunction',data)
}

// 角色和社区关联

export function deleteRoleAssCommunity (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/deleteRoleAssCommunity',data)
}

export function listRoleCommunity (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'userPrivilege/listRoleCommunity',data)
}

export function listRoleNotCommunity (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'userPrivilege/listRoleNotCommunity',data)
}

export function roleAssCommunity (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/roleAssCommunity',data)
}

// 用户角色关联

export function deleteRoleAssStaff (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/deleteRoleAssStaff',data)
}

export function listRoleStaff (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'userPrivilege/listRoleStaff',data)
}

export function listStaffNoRole (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'userPrivilege/listStaffNoRole',data)
}

export function roleAssociatedStaff (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'userPrivilege/roleAssociatedStaff',data)
}

// 员工信息

export function addMemberInfo (data) {
    return Request.requestForm(Request.POST, currBaseUrl + 'members/addMemberInfo',data)
}

export function deleteMemberInfo (data) {
    return Request.requestForm(Request.DELETE, currBaseUrl + 'members/deleteMemberInfo',data)
}

export function getMemberFullInfo (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'members/getMemberFullInfo',data)
}

export function getMemberInfoList (data) {
    return Request.requestForm(Request.GET, currBaseUrl + 'members/getMemberInfoList',data)
}

export function resetPassword (data) {
    return Request.requestForm(Request.PUT, currBaseUrl + 'members/resetPassword',data)
}
