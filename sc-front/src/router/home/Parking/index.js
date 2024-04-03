const routes = [
  {
    path: '/parking',
    name: 'Parking',
    redirect: { name: 'Parking' },
    component: () => import('@/views/HomeView.vue'),
    children: []
  }
]

// 读取子目录下面菜单设置为二级路由
const secondRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in secondRouter) {
  routes[0].children.push(...secondRouter[path].default)
}

export default routes