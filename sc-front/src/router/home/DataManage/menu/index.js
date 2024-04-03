const childrenRoutes = [
  {
    path: 'communityManage',
    name: 'CommunityManage',
    component: () => import('@/views/pages/dataManage/communityManage'),
    meta: {
      text: '小区管理'
    }
  },
  // {
  //   path: 'auditEnterCommunityManage',
  //   name: 'AuditEnterCommunityManage',
  //   component: () =>
  //     import('@/views/pages/dataManage/auditEnterCommunityManage'),
  //   meta: {
  //     text: '进出管理'
  //   }
  // },
  // {
  //   path: 'merchantManage',
  //   name: 'MerchantManage',
  //   component: () => import('@/views/pages/dataManage/merchantManage'),
  //   meta: {
  //     text: '商业管理'
  //   }
  // },
  {
    path: 'propertyCompanyManage',
    name: 'PropertyCompanyManage',
    component: () => import('@/views/pages/dataManage/propertyCompanyManage'),
    meta: {
      text: '物业管理'
    }
  }
]

export default childrenRoutes
