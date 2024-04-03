const routes = [
  {
    path: '/home',
    name: 'Home',
    meta: {
      text: '主页',
      icon: ''
    },
    redirect: { name: 'Dashboard' },
    component: () => import('@/views/HomeView.vue'),
    children: [
      {
        path: '',
        name: 'Dashboard',
        meta: {
          text: '首页',
          icon: ''
        },
        component: () => import('@/views/dashboard/Dashboard.vue')
      }
    ]
  }
]

// 读取子目录下面菜单设置为二级路由
const secondRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in secondRouter) {
  routes[0].children.push(...secondRouter[path].default)
}

export default routes
