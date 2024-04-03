import { IconHome } from '../../../views/home/icons'

const routes = [
  {
    path: '/DataManage',
    name: 'DataManage',
    children: [],
    meta: {
      text: '数据管理',
      icon: '/svgs/IconHome.svg'
    }
  }
]

const menuRouter = import.meta.glob('./*/index.js', { eager: true })
for (const path in menuRouter) {
  routes[0].children.push(...menuRouter[path].default)
}

export default routes
