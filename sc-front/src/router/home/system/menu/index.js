const routes =[
  {
    path:'cellConfiguration',
    name:'CellConfiguration',
    meta:{
      text:'小区配置'
    },
    component:()=>
      import('@/views/pages/system/CellConfiguration.vue')
  },
  {
    path:'processManagement',
    name:'ProcessManagement',
    meta:{
      text:'流程管理'
    },
    component:()=>
      import('@/views/pages/system/ProcessManagement.vue')
  },
  {
    path:'changePassword',
    name:'ChangePassword',
    meta:{
      text:'修改密码'
    },
    component:()=>
      import('@/views/pages/system/ChangePassword.vue')
  },
  {
    path:'merchantInformation',
    name:'MerchantInformation',
    meta:{
      text:'商户信息'
    },
    component:()=>
      import('@/views/pages/system/MerchantInformation.vue')
  },
  
]
export default routes