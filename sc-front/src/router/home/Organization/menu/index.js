const routes =[
  {
    path:'organizationInformation',
    name:'OrganizationInformation',
    meta:{
      text:'组织信息'
    },
    component:()=>
      import('@/views/pages/organization/OrganizationInformation.vue')
  },
  {
    path:'employeeInformation',
    name:'EmployeeInformation',
    meta:{
      text:'员工信息'
    },
    component:()=>
      import('@/views/pages/organization/EmployeeInformation.vue')
  },
  {
    path:'RolePermissions',
    name:'rolePermissions',
    meta:{
      text:'角色权限'
    },
    component:()=>
      import('@/views/pages/organization/RolePermissions.vue')
  },
  // {
  //   path:'employeeCertification',
  //   name:'EmployeeCertification',
  //   meta:{
  //     text:'员工认证'
  //   },
  //   component:()=>
  //     import('@/views/pages/organization/EmployeeCertification.vue')
  // },
]
export default routes