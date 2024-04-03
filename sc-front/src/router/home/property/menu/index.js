const routes = [
  {
    path: 'ownerAccount',
    name: 'OwnerAccount',
    meta: {
      text: '业主账号'
    },
    component: () =>
      import('@/views/pages/property/ownerAccount/OwnerAccount.vue')
  },
  {
    path: 'ownerBinding',
    name: 'OwnerBinding',
    meta: {
      text: '绑定业主'
    },
    component: () =>
      import('@/views/pages/property/ownerBinding/OwnerBinding.vue')
  },
  {
    path: 'ownerInfo',
    name: 'OwnerInfo',
    meta: {
      text: '业主信息'
    },
    component: () => import('@/views/pages/property/ownerInfo/OwnerInfo.vue')
  },
  {
    path: 'ownerMember',
    name: 'OwnerMember',
    meta: {
      text: '业主成员'
    },
    component: () =>
      import('@/views/pages/property/ownerMember/OwnerMember.vue')
  },
  {
    path: 'houseManagement',
    name: 'HouseManagement',
    meta: {
      text: '房屋管理'
    },
    component: () =>
      import('@/views/pages/property/houseManagement/HouseManagement.vue')
  },
  {
    path: 'shopManagement',
    name: 'ShopManagement',
    meta: {
      text: '商铺管理'
    },
    component: () =>
      import('@/views/pages/property/shopManagement/ShopManagement.vue')
  }
]

export default routes
