const routes = [
  {
    path: '/property',
    name: 'Property',
    meta: {
      text: '房产',
      icon: ''
    },
    redirect: { name: 'RoomManagement' },
    children: []
  }
]

const menuRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in menuRouter) {
  routes[0].children.push(...menuRouter[path].default)
}

export default routes
