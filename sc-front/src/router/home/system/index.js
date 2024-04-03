const routes = [
  {
    path: '/system',
    name: 'System',
    meta: {
      text: '系统管理',
      icon: ''
    },
    redirect: { name: 'CellConfiguration' },
    children: []
  }
]

// 读取子目录下面菜单设置为二级路由
const secondRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in secondRouter) {
  routes[0].children.push(...secondRouter[path].default)
}

export default routes
