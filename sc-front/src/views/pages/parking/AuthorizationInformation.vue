<template>
  <PageLayout>
    <template #header>
      <!-- 表单 -->
      <Form
        :formHeader="formHeader"
    
        :formConfig="formConfig"
        :formValue="formValue"
      />
    </template>
    <template #default>
      <!-- 表格 -->
      <Table
        class="box-card"
        :header="header"
        :tableLabel="tableLabel"
        :tableData="tableData"
      >
        <template #remarks>
          派单方式： 1、抢单 是员工（报修类型下的师傅）自主抢单
          维修处理，比较实用于物业每单给维修是否提成的场景 2、指派
          专门由客服派单员工（报修类型下的师傅）维修处理，一般物业的选择 3、轮训
          由系统定时派单员工（报修类型下的师傅）维修处理 公共区域：
          小区、楼栋、单元 为公共区域 房屋为非公共区域 注意：一般业主房屋报修
          我们必须要添加一个非公共区域的类型才能正常报修
        </template>
      </Table>
    </template>
  </PageLayout>
</template>

<script setup>
import { PageLayout } from '@/components'
import { reactive, ref } from 'vue'
// 表格数据
const header = reactive({
  title: '黑白名单信息',
  headerBtn: [
    {
      name: '添加',
      type: 'primary',
      func: () => {
        console.log(11)
      }
    }
  ]
})
const tableLabel = reactive([
  {
    label: '名单ID',
    prop: 'ID'
  },
  {
    label: '名单类型',
    prop: 'number'
  },
  {
    label: '停车场',
    prop: 'type'
  },
  {
    label: '车牌号',
    prop: 'outNumber'
  },
  {
    label: '开始时间',
    prop: 'time'
  },
  {
    label: '结束时间',
    prop: 'time'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '共享岗亭',
        type: 'default',
        func: ({ ID }) => {}
      },
      {
        name: '控制台',
        type: 'default',
        func: ({ ID }) => {}
      },
      {
        name: '修改',
        type: 'default',
        func: ({ ID }) => {}
      },
      {
        name: '删除',
        type: 'default',
        func: ({ ID }) => {}
      }
    ]
  }
])
const tableData = reactive([
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '126',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  },
  {
    ID: '102022101305621558',
    number: '11',
    type: '地上停车场',
    outNumber: '125',
    time: ''
  }
])

// 表单数据
// 表单标题
const more = ref(false)
const moreBtnName = ref('更多')

const formHeader = reactive({
  title: '查询条件',
  headerBtn: [
    {
      link: true,
      name: moreBtnName,
      type: 'primary',
      func: () => {
        // 小表单更多
        more.value = !more.value
        if (more.value) {
          moreBtnName.value = '隐藏'
        } else {
          moreBtnName.value = '更多'
        }
      }
    }
  ]
})
// 表单结构
const formConfig = reactive({
  formWidth: '',
  formItemList: [
    {
      more: true,
      type: 'text',
      label: '',
      prop: '编号',
      placeholder: '请选择停车场'
    },
    {
      more: true,
      type: 'text',
      label: '',
      prop: 'ID',
      placeholder: '请输入车位编号'
    },

    {
      more: true,
      type: 'text',
      label: '',
      prop: 'ID2',
      placeholder: '请输入车位编号'
    },
    {
      more: more,
      type: 'select',
      label: '',
      prop: '类型',
      placeholder: '请选择车位状态',
      optList: [
        {
          label: '出售',
          value: '地上停车场'
        },
        {
          label: '出租',
          value: '地下停车场'
        },
        {
          label: '空闲',
          value: '地下停车场'
        }
      ]
    },
    {
      more: more,
      type: 'text',
      label: '',
      prop: 'ID2',
      placeholder: '请输入车位编号'
    }
  ],
  operate: [
    {
      name: '查询',
      type: 'primary',
      func: (v) => {
        console.log(v)
      }
    },
    {
      name: '重置',
      type: 'primary',
      func: (v) => {
        console.log(v)
      }
    },
    {
      name: '重置',
      type: 'primary',
      func: (v) => {
        console.log(v)
      }
    }
  ]
})
// 初始值
const formValue = reactive({
  编号: '',
  类型: '',
  ID: ''
})
</script>

<!-- <template>
  <div class="contain">
    <div class="code">主面板</div>
    <div class="info">这是主面板</div>
  </div>
  <RepairSet />
</template> -->

<style lang="scss" scoped></style>
