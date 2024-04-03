<template>
  <PageLayout>
    <template #default>
      <Table
        :header="header"
        :tableLabel="tableLabels"
        :tableData="tableData"
        :total="total"
        v-model:current-page="pageNum"
        @change-page="getIndex"
      />
    </template>
  </PageLayout>
  <el-dialog title="修改" v-model="formShow">
    <el-form :model="formData" label-width="80px" >
        <el-form-item label="小区名称">
            <el-input v-model="formData[itemModel.name]" disabled></el-input>
        </el-form-item>
        <el-form-item label="小区地址">
            <el-input v-model="formData[itemModel.address]" disabled></el-input>
        </el-form-item>
        <el-form-item label="小区地标">
            <el-input v-model="formData[itemModel.communityId]" disabled></el-input>
        </el-form-item>
        <el-form-item label="城市编码">
            <el-input v-model="formData[itemModel.cityCode]" disabled></el-input>
        </el-form-item>
        <el-form-item label="地区X坐标">
            <el-input v-model="formData[itemModel.mapX]" disabled></el-input>
        </el-form-item>
        <el-form-item label="地区Y坐标">
            <el-input v-model="formData[itemModel.mapY]" disabled></el-input>
        </el-form-item>
        <el-form-item label="联系方式">
            <el-input v-model="formData[itemModel.tel]"></el-input>
        </el-form-item>
        <el-form-item label="小区面积">
            <el-input v-model="formData[itemModel.communityArea]"></el-input>
        </el-form-item>
    </el-form>
    <template #footer>
      <span>
        <el-button type="primary" @click="Submit">确认</el-button>
        <el-button @click="formShow = false">取消</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { Table, PageLayout } from '@/components'
import { reactive, ref } from 'vue'
import { queryStoreCommunitys,updateStoreCommunity } from '@/apis/Community/myCommunity'

const total = ref(100)

const pageNum = ref(1)

const itemModel = {
  address: 'address',
  areaName: 'areaName',
  auditStatusCd: 'auditStatusCd',
  cityCode: 'cityCode',
  //   省份
  cityName: 'cityName',
  communityArea: 'communityArea',
  communityId: 'communityId',
  endTime: 'endTime',
  mapX: 'mapX',
  mapY: 'mapY',
  memberId: 'memberId',
  name: 'name',
  nearbyLandmarks: 'nearbyLandmarks',
  provName: 'provName',
  startTime: 'startTime',
  statusCd: 'statusCd',
  tel: 'tel'
}
const formShow = ref(false)
const formData = reactive({
    address: '',
    areaName: '',
    auditStatusCd: '',
    cityCode: '',
    //   省份
    cityName: '',
    communityArea: '',
    communityId: '',
    endTime: '',
    mapX: '',
    mapY: '',
    memberId: '',
    name: '',
    nearbyLandmarks: '',
    provName: '',
    startTime: '',
    statusCd: '',
    tel: ''
})

function getIndex(...args){
  console.log(args)
}

const header = {
  title: '我的小区'
}
const tableLabels = [
  {
    label: '省份',
    prop: itemModel.provName
  },
  {
    label: '市/州',
    prop: itemModel.cityName
  },
  {
    label: '区/县',
    prop: itemModel.areaName
  },
  {
    label: '小区名称',
    prop: itemModel.name
  },
  {
    label: '小区编码',
    prop: itemModel.communityId
  },
  {
    label: '联系方式',
    prop: itemModel.tel
  },
  {
    label: '面积',
    prop: itemModel.communityArea
  },
  {
    label: '开始时间',
    prop: itemModel.startTime,
    width: 200
  },
  {
    label: '结束时间',
    prop: itemModel.endTime,
    width: 200
  },
  {
    label: '状态',
    prop: itemModel.statusCd
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '修改',
        type: 'default',
        func: (item) => {
            for(const key in formData){
                formData[key]=item[key]
            }
            formShow.value=true
        }
      }
    ]
  }
]

const tableData = reactive([
  {
    address: '天津省天津市河东区演示物业',
    areaName: '河东区',
    auditStatusCd: '1100',
    cityCode: '120102',
    cityName: '天津市',
    communityArea: '999992.10',
    communityId: '2022090665021542',
    endTime: '2023-09-06 16:59:04',
    mapX: '101.33',
    mapY: '101.33',
    memberId: '102022090662291416',
    name: '演示物业（误删）',
    nearbyLandmarks: '演示物业',
    page: -1,
    provName: '天津省',
    records: 0,
    row: 0,
    startTime: '2022-09-06 16:59:04',
    statusCd: '0',
    tel: '11113',
    total: 0
  }
])

function ClearForm () {
    for(const key in formData){
        formData[key]=''
    }
}

function Submit () {
    //执行接口命令
    formShow.value=false
    updateStoreCommunity(formData).then(res=>{
      tableData.splice(0, tableData.length, ...res.data.rows)
      total.value = res.data.total
      pageNum.value = res.data.pageIndex
    })
}
function ReFreshData (){
  queryStoreCommunitys({ condition: 1}).then(res => {
    tableData.splice(0, tableData.length, ...res.data.rows)
    total.value = res.data.total
    pageNum.value = res.data.pageIndex
  })
}

ReFreshData()
</script>
