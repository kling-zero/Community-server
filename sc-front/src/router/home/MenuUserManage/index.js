const routes = [
  {
    path: '/MenuUserManage',
    name: 'MenuUserManage',
    text: '常用菜单',

    component: () => import('@/views/pages/menuUserManage/menuUserManage.vue')
  }
]

export default routes
