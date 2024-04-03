const childrenRoutes = [
    {
        path: 'storeInfo',
        name: 'StoreInfo',
        meta: {
            text: '商户信息',
        },
        component: () => import('@/views/pages/storeManage/storeInfo/storeInfo.vue')
    },
    {
        path: 'storeAdmin',
        name: 'storeAdmin',
        meta: {
            text: '商户管理员',
        },
        component: () => import('@/views/pages/storeManage/storeAdmin/storeAdmin.vue')
    },
]

export default childrenRoutes
