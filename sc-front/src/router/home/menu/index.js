const routes = [
    {
        path: '/menu',
        name: 'Menu',
        meta: {
            text: '菜单',
            icon: ''
        },
        children: []
    }
]
const secondRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in secondRouter) {
    routes[0].children.push(...secondRouter[path].default)
}

export default routes