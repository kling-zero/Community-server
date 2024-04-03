const routes = [
  {
    path: '/Community' ,
    name: 'Community',
    text: '小区',
    // redirect: { name: 'Dashboard' },
    // component: () => import('@/views/HomeView.vue'),
    meta: {
      text: '小区',
      icon: ''
    },
    children: []
  }
]

const menuRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in menuRouter) {
  routes[0].children.push(...menuRouter[path].default)
}
export default routes
