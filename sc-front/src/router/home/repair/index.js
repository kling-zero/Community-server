const routes = [
  {
    path: '/repair',
    name: 'Repair',
    redirect: { name: 'RepairSet' },
    meta: {
      text: '报修'
    },
    // component: () => import('@/views/HomeView.vue'),
    children: []
  }
]

// 读取子目录下面菜单设置为二级路由
const menuRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in menuRouter) {
  routes[0].children.push(...menuRouter[path].default)
}

export default routes
