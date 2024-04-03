const routes = [
  {
    path: 'MyCommunity',
    name: 'myCommunity',
    meta: {
      text: '我的小区',
      icon: ''
    },
    component: () => import('@/views/pages/community/myCommunity')
  },
  {
    path: 'SimplifyAcceptance',
    name: 'simplifyAcceptance',
    meta: {
      text: '业务受理',
      icon: ''
    },
    component: () => import('@/views/pages/community/simplifyAcceptance')
  },
  {
    path: 'PropertyRightRegistrationManage',
    name: 'propertyRightRegistrationManage',
    meta: {
      text: '产权登记',
      icon: ''
    },
    component: () =>
      import('@/views/pages/community/propertyRightRegistrationManage')
  },
  {
    path: 'CarStructure',
    name: 'carStructure',
    meta: {
      text: '车位结构图',
      icon: ''
    },
    component: () => import('@/views/pages/community/carStructure')
  },
  {
    path: 'RoomStructure',
    name: 'roomStructure',
    meta: {
      text: '结构图',
      icon: ''
    },
    component: () => import('@/views/pages/community/roomStructure')
  },
  {
    path: 'RoomRenovationManage',
    name: 'roomRenovationManage',
    meta: {
      text: '房屋装修',
      icon: ''
    },
    component: () => import('@/views/pages/community/roomRenovationManage')
  },
]

export default routes
