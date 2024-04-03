<script setup>
import { onMounted, reactive, ref } from 'vue'
import { Dialog, Table } from '@/components'
import { allowAddedCommunity } from './include'
import * as req from '@/apis/management/store'

const showDialog = ref(false)

const formOfDialog = [
  {
    label: '小区名称',
    prop: 'communityName'
  },
  {
    label: '小区地址',
    prop: 'businessName'
  },
  {
    label: '公司法人',
    prop: 'corporation'
  },
  {
    label: '成立日期',
    prop: 'foundingTime'
  },
  {
    label: '创建时间',
    prop: 'createTime'
  },
  {
    label: '城市编码',
    prop: 'cityCode'
  },
  {
    label: '城市名称',
    prop: 'cityName'
  },
  {
    label: '地区 X 坐标',
    prop: 'mapX'
  },
  {
    label: '地区 Y 坐标',
    prop: 'mapY'
  },
  {
    label: '附近地标',
    prop: 'nearbyLandmarks'
  },
  {
    label: '状态',
    prop: 'stateName'
  },
  {
    label: '电话',
    prop: 'tel'
  }
]

const modelValue = formOfDialog.map((item) => ({
  ...item,
  value: ref('')
}))

const communityManage = reactive({
  header: {
    title: '小区管理',
    headerBtn: [
      {
        name: '添加小区',
        type: 'primary',
        func: () => (showDialog.value = true)
      }
    ]
  },
  tableLabel: [
    // {
    //   label: '小区ID',
    //   prop: 'communityId'
    // },
    ...formOfDialog,
    {
      label: '操作',
      prop: 'operation',
      btn: [
        {
          name: '删除物业',
          key: 'add',
          type: 'danger',
          text: 'danger',
          func: () => ''
        },
        {
          name: '修改物业',
          key: 'add',
          type: 'primary',
          text: 'primary',
          func: (row) => console.log(row)
        }
      ]
    }
  ],
  dropdown: true,
  tableData: [{}]
})

function submit() {}

onMounted(async () => {
  const { data } = await req.queryAccessibleCommunities()
  allowAddedCommunity.tableData.push(...data)
})
</script>

<template>
  <div class="p-2">
    <el-tabs>
      <el-tab-pane label="小区管理">
        <div class="p-2">
          <Table v-bind="communityManage" />
        </div>
      </el-tab-pane>
      <el-tab-pane label="可加入小区">
        <div class="p-2">
          <Table v-bind="allowAddedCommunity" />
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
  <Dialog @submit="submit" v-model="showDialog" title="物业公司添加小区">
    <div
      class="mb-2 flex flex-row flex-nowrap items-center"
      v-for="(item, index) in modelValue"
      :key="index"
    >
      <span class="mr-2 w-40 text-right text-sm">{{ item.label }}</span>
      <el-input v-model="item.value.value" />
    </div>
  </Dialog>
</template>
