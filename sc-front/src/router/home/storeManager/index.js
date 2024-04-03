const routes = [
    {
        path: '/StoreManager' ,
        name: 'StoreManager',
        text: '商户',
        meta: {
            text: '商户',
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
