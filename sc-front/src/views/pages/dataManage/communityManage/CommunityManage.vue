<script setup>
import { onMounted, reactive, ref } from 'vue'
import { Dialog, Table } from '@/components'
import {
  addCommunity,
  listCommunityMenu,
  listMenuGroup,
  listCommunity,
  modifyById
} from '@/apis/management/community'

const formOfFilter = {
  formHeader: '',
  formInline: '',
  formConfig: '',
  formValue: ''
}

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
    label: '负责人联系方式',
    prop: 'tel'
  }
]

const modelValue = formOfDialog.map((item) => ({
  ...item,
  value: ref('')
}))

const table = reactive({
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
    // FIXME
    // {
    //   label: '小区ID',
    //   prop: 'communityId'
    // },
    ...formOfDialog,
    {
      label: '状态',
      prop: 'stateName'
    },
    {
      label: '操作',
      prop: 'operation',
      btn: [
        {
          name: '修改',
          key: 'modify',
          type: 'primary',
          func: () => {}
        }
      ]
    }
  ],
  tableData: [{ communityName: '', businessName: '' }]
})

async function submitAdd() {
  const { data } = await listMenuGroup()
  console.log(data)
}

function change() {}
</script>

<template>
  <div class="p-4">
    <div class="mb-4"></div>

    <Table v-bind="table" />
  </div>

  <Dialog @submit="submitAdd" v-model="showDialog" title="添加小区">
    <div
      class="mb-2 flex flex-ro  w flex-nowrap items-center"
      v-for="(item, index) in modelValue"
      :key="index"
    >
      <span class="mr-2 w-40 text-right text-sm">{{ item.label }}</span>
      <el-input v-model="item.value.value" />
    </div>
  </Dialog>

  <Dialog @submit="change"> </Dialog>
</template>
