import { reactive } from 'vue'
import { addCommunity } from '@/apis/management/store/index'

export const allowAddedCommunity = reactive({
  header: {
    title: '小区管理'
  },
  tableLabel: [
    {
      label: '小区 ID',
      prop: 'communityId'
    },
    {
      label: '小区名称',
      prop: 'name'
    },
    {
      label: '城市代码',
      prop: 'cityCode'
    },
    {
      label: '地址',
      prop: 'address'
    },
    {
      label: '附近地标',
      prop: 'nearbyLandmarks'
    },
    {
      label: '联系电话',
      prop: 'tel'
    },
    {
      label: 'X 坐标',
      prop: 'mapX'
    },
    {
      label: 'Y 坐标',
      prop: 'mapY'
    },
    {
      label: '状态',
      prop: 'state'
    },
    {
      label: '操作',
      prop: 'operation',
      btn: [
        {
          name: '加入小区',
          key: 'addCommunity',
          type: 'primary',
          func: async (args) => addCommunity(args)
        }
      ]
    }
  ],
  tableData: []
})
