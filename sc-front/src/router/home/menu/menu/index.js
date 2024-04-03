const childrenRoutes = [
    {
        path: 'menuGroup',
        name: 'MenuGroup',
        meta: {
            text: '菜单组',
        },
        component: () => import('@/views/pages/menu/menuGroup/MenuGroup.vue'),
    },
    {
        path: 'menuMaintenance',
        name: 'MenuMaintenance',
        meta: {
            text: '菜单维护'
        },
        component: () => import('@/views/pages/menu/menuMaintenance/MenuMaintenance.vue'),
        // children: [
        //     {
        //         path: 'menuConfig',
        //         name: 'MenuConfig',
        //         component: () => import('@/views/pages/menu/menuMaintenance/MenuConfig.vue')
        //     }
        // ]
    }

]
export default childrenRoutes