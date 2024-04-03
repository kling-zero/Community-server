<template>
  <PageLayout>
    <template #header>
      <Form
        :form-config="formConfig"
        :form-header="formHeader"
        :form-value="searchFormModel"
      />
    </template>
    <template #default>
      <Table
        :header="TableHeader"
        :tableLabel="tableLabels"
        :table-data="tableData"
        v-model:current-page="pageObject.pageNum"
        :total="pageObject.total"
      />
    </template>
  </PageLayout>
  <el-dialog title="产权详细记录" v-model="dialogShow.showDetails">
    <el-table :data="detailTable" stripe>
      <el-table-column
        v-for="col in detailColumns"
        :prop="col.id"
        :key="col.id"
        :label="col.label"
        :width="col.width || null"
      >
      </el-table-column>
      <el-table-column label="图片">
        <template #default="scope" >
          <div style="display: flex;justify-content: center;align-items: center;">
            <img style="width: 40px;height: 40px;" v-for="url in scope.row.idCardUrl.split(',')" :key="url" :src="url" />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <div style="display: flex;justify-content: center;align-items: center;">
            <el-button type="primary" size="default" @click="ChangePropertyDetail(scope.row)">
              修改
            </el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>

    <template #footer>
      <span>
        <el-button type="primary">确认</el-button>
        <el-button @click="dialogShow.showDetails = false">取消</el-button>
      </span>
    </template>
  </el-dialog>

  <el-dialog title="产权登录审核" v-model="dialogShow.process">
    <el-form :model="processDialogFormModel" label-width="80px">
      <el-form-item label="房屋">
        <el-input
          v-model="processDialogFormModel[itemModel.roomNode]"
        ></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="processDialogFormModel[itemModel.type]"></el-select>
      </el-form-item>
      <el-form-item label="审核意见">
        <el-input v-model="processDialogFormModel[itemModel.advice]"></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span>
        <el-button type="primary">确认</el-button>
        <el-button @click="dialogShow.process = false">取消</el-button>
      </span>
    </template>
  </el-dialog>
  <el-dialog title="修改房屋产权" v-model="dialogShow.change">
    <el-form :model="changeDialogFormModel" label-width="80px">
      <el-form-item label="楼栋">
        <el-select
          v-model="changeDialogFormModel[itemModel.floorNum]"
        ></el-select>
      </el-form-item>
      <el-form-item label="单元">
        <el-select
          v-model="changeDialogFormModel[itemModel.unitNum]"
        ></el-select>
      </el-form-item>
      <el-form-item label="房屋">
        <el-select
          v-model="changeDialogFormModel[itemModel.roomNum]"
        ></el-select>
      </el-form-item>

      <el-form-item label="姓名">
        <el-input
          v-model="changeDialogFormModel[itemModel.userName]"
        ></el-input>
      </el-form-item>
      <el-form-item label="联系方式">
        <el-input
          v-model="changeDialogFormModel[itemModel.telephone]"
        ></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="changeDialogFormModel[itemModel.address]"></el-input>
      </el-form-item>
      <el-form-item label="身份证号">
        <el-input
          v-model="changeDialogFormModel[itemModel.userInfoNode]"
        ></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span>
        <el-button type="primary">确认</el-button>
        <el-button @click="dialogShow.change = false">取消</el-button>
      </span>
    </template>
  </el-dialog>
  <el-dialog title="添加房屋产权" v-model="dialogShow.add">
    <el-form :model="addDialogFormModel" label-width="80px">
      <el-form-item label="楼栋">
        <el-select v-model="addDialogFormModel[itemModel.floorNum]"></el-select>
      </el-form-item>
      <el-form-item label="单元">
        <el-select v-model="addDialogFormModel[itemModel.unitNum]"></el-select>
      </el-form-item>
      <el-form-item label="房屋">
        <el-select v-model="addDialogFormModel[itemModel.roomNum]"></el-select>
      </el-form-item>

      <el-form-item label="姓名">
        <el-input v-model="addDialogFormModel[itemModel.userName]"></el-input>
      </el-form-item>
      <el-form-item label="联系方式">
        <el-input v-model="addDialogFormModel[itemModel.telephone]"></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="addDialogFormModel[itemModel.address]"></el-input>
      </el-form-item>
      <el-form-item label="身份证号">
        <el-input
          v-model="addDialogFormModel[itemModel.userInfoNode]"
        ></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span>
        <el-button type="primary">确认</el-button>
        <el-button @click="dialogShow.add = false">取消</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { Table, Form, PageLayout } from '@/components'
import { reactive, ref } from 'vue'
import { itemModel } from './dataModels'
import {
  addProperty,
  deletePorperty,
  updateProperty,
  updatePropertyDetail,
  listPropertyRightRegistration,
  listPropertyRightRegistrationDetail
} from '@/apis/Community/propertyRightRegistration'

const detailTable = reactive([
  {
    createTime: '2022-11-02 16:00:30',
    createUser: '-1',
    deedTaxUrl: '',
    housePurchaseUrl: '',
    idCardUrl:
      '/building.png,/floor.png',
    isTrue: '-1',
    page: -1,
    prrId: '102022110249340021',
    prrdId: '112022110213230026',
    records: 0,
    repairUrl: '',
    row: 0,
    securities: '001',
    securitiesName: '身份证',
    statusCd: '0',
    total: 0
  }
])

const moreOptions = ref(false)
const moreButtonName = ref('更多')
const formHeader = reactive({
  title: '查询条件',
  headerBtn: [
    {
      name: moreButtonName,
      type: 'default',
      func: () => {
        moreOptions.value = !moreOptions.value
        moreButtonName.value = moreOptions.value ? '隐藏' : '更多'
      }
    }
  ]
})
const formConfig = reactive({
  formItemList: [
    {
      more: true,
      // label: '',
      prop: itemModel.roomId,
      type: 'text',
      placeholder: '请输入房屋ID'
    },
    {
      more: true,
      // label: '',
      prop: itemModel.roomNode,
      type: 'text',
      placeholder: '请填写房屋编号 格式 楼栋-单元-房屋'
    },
    {
      more: true,
      // label: '',
      prop: itemModel.userName,
      type: 'text',
      placeholder: '请输入姓名'
    },
    {
      more: moreOptions,
      // label: '',
      prop: itemModel.telephone,
      type: 'text',
      placeholder: '请输入联系方式'
    },
    {
      more: moreOptions,
      // label: '',
      prop: itemModel.userInfoNode,
      type: 'text',
      placeholder: '请输入身份证号'
    },
    {
      more: moreOptions,
      // label: '',
      prop: itemModel.address,
      type: 'text',
      placeholder: '请输入地址'
    },
    {
      more: moreOptions,
      // label: '',
      prop: itemModel.type,
      type: 'select',
      placeholder: '请选择审核状态'
    },
    {
      more: moreOptions,
      // label: '',
      prop: itemModel.floorId,
      type: 'select',
      placeholder: '请选择楼栋'
    },
    {
      more: moreOptions,
      // label: '',
      prop: itemModel.unitId,
      type: 'select',
      placeholder: '请选择单元'
    }
  ],
  operate: [
    {
      name: '查询',
      type: 'primary',
      func: (...args) => {
        console.log(args)
        Search()
      }
    },
    {
      name: '重置',
      type: 'default',
      func: (...args) => {
        console.log(args)
      }
    }
  ]
})
const TableHeader = {
  title: '房屋产权信息',
  headerBtn: [
    {
      name: '添加房屋产权',
      type: 'default',
      func: () => {
        dialogShow.add = true
      }
    }
  ]
}

const tableLabels = [
  {
    label: '房屋产权ID',
    prop: itemModel.propertyRightId
  },
  {
    label: '房屋ID',
    prop: itemModel.roomId
  },
  {
    label: '房屋编号',
    prop: itemModel.roomNode
  },
  {
    label: '姓名',
    prop: itemModel.userName
  },
  {
    label: '联系方式',
    prop: itemModel.telephone
  },
  {
    label: '身份证号',
    prop: itemModel.userInfoNode
  },
  {
    label: '地址',
    prop: itemModel.address
  },
  {
    label: '状态',
    prop: itemModel.type
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '审核',
        type: 'default',
        func: (...args) => {
          dialogShow.process = true
        }
      },
      {
        name: '修改',
        type: 'default',
        func: (item) => {
          for (const key in item) {
            changeDialogFormModel[key] = item[key]
          }
          dialogShow.change = true
        }
      },
      {
        name: '详情',
        type: 'default',
        func: (item) => {
          for (const key in item) {
            changeDialogFormModel[key] = item[key]
          }
          dialogShow.showDetails = true
        }
      },
      {
        name: '删除',
        type: 'default',
        func: (item) => {
            // eslint-disable-next-line no-undef
            ElMessageBox.confirm(
            '确认删除房屋产区ID为'+item[itemModel.propertyRightId]+'的记录？',
            '删除产权信息',
              {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                type: 'warning',
              }
            ).then(() => {
              deletePorperty(item).then(res=>{
                if(res&&res.code===10000){
                  Search()
                }
              })
            })

        }
      }
    ]
  }
]

const detailColumns = [
  {
    id: 'prrdId',
    label: '产权登记详情ID'
  },
  {
    id: 'securitiesName',
    label: '材料类型'
  },
  {
    id: 'createTime',
    label: '创建时间'
  },
  {
    id: 'statusCd',
    label: '是否缴费'
  }
]

const searchFormModel = reactive({
  [itemModel.address]: '',
  [itemModel.floorNum]: '',
  [itemModel.communityId]: '',
  [itemModel.floorId]: '',
  [itemModel.userInfoNode]: '',
  [itemModel.name]: '',
  [itemModel.telephone]: '',
  [itemModel.roomNode]: '',
  [itemModel.roomId]: '',
  [itemModel.unitNum]: '',
  [itemModel.unitId]: '',
  [itemModel.type]: ''
})

const changeDialogFormModel = reactive({
  [itemModel.userName]: '',
  [itemModel.telephone]: '',
  [itemModel.address]: '',
  [itemModel.userInfoNode]: '',
  [itemModel.userInfoNode]: '',
  [itemModel.floorNum]: '',
  [itemModel.unitNum]: '',
  [itemModel.roomNum]: ''
})

const addDialogFormModel = reactive({
  [itemModel.userName]: '',
  [itemModel.telephone]: '',
  [itemModel.address]: '',
  [itemModel.userInfoNode]: '',
  [itemModel.userInfoNode]: '',
  [itemModel.floorNum]: '',
  [itemModel.unitNum]: '',
  [itemModel.roomNum]: ''
})

const processDialogFormModel = reactive({
  [itemModel.roomNode]: '',
  [itemModel.type]: '',
  [itemModel.advice]: ''
})

const tableData = reactive([
  {
    address: '3333',
    communityId: '2022090665021542',
    createUser: '-1',
    floorId: '732022092298980213',
    floorNum: '30',
    idCard: '444442200106859654',
    link: '16986354215',
    name: '333',
    page: -1,
    prrId: '102022101930331891',
    records: 0,
    remark: '123',
    roomId: '752022092675190390',
    roomNum: '10001',
    row: 0,
    state: '0',
    stateName: '未审核',
    statusCd: '0',
    total: 0,
    unitId: '742022092344140262',
    unitNum: '1'
  }
])

const dialogShow = reactive({
  change: false,
  add: false,
  showDetails: false,
  process: false
})

const pageObject = reactive({
  pageNum: 1,
  total: 0,
})

function Search() {
  listPropertyRightRegistration(searchFormModel).then(res=>{
    if(res&&res.code===10000){
      pageObject.pageNum=res.data.pageIndex
      pageObject.total=res.data.total
      tableData.splice(0, tableData.length,...res.data.rows)
    }

  })
}
Search()

function ChangePropertyDetail (item) {
  updatePropertyDetail(item).then(res=>{
    if(res&&res.code===10000){
      Search()
    }
  })
}
</script>
