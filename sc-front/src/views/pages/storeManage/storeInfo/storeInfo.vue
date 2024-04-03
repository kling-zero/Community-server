<template>
  <PageLayout>
    <template #header>
      <Form
          :form-config="formConfig"
          :form-header="formHeader"
          :formValue="searchFormModel"
      />
    </template>
    <template #default>
      <Table @changePage="pageCheck" :header="TableHeader" :tableLabel="tableLabels"
             :table-data="tableData" :current-page="pageIndex" :total="total"/>
    </template>
  </PageLayout>
</template>

<script setup>
import { Table, Form, PageLayout } from '@/components'
import {onMounted, reactive, ref} from 'vue'
import { itemModel } from './DataModels'
import {getAllStoreTypes, getStores} from "@/apis/storemanager";

//页码修改逻辑
let pageIndex = ref(1)
let total = ref(10)




//向后端请求数据同时改变前端的渲染
//注意这个参数是非常灵活的, args可以适用于页码切换和各种查询
async function queryData(args){
  console.log(args)
  //这里得到的数据是后端传递过来的数据，
  // 需要更新tableData的值 和 页码的值
  await getStores(args).then((res)=>{
    // console.log(res)
    //更新当前表格的值
    tableData.splice(0,tableData.length)
    if(res.data.rows){
      for(let i=0; i<res.data.rows.length; i++)
        tableData.push(res.data.rows[i])
    }
    //更新页码
    pageIndex.value = res.data.pageIndex
    //更新当前的total值
    total.value = res.data.total
  }).finally(()=>{
    //说明没有数据
    if(tableData.length === 0){
      //需要进行处理
    }
  })
}

const tableData = reactive([])
//动态输入查询的商户类型
const queryType = reactive([])
//页面刚启动就要进行数据渲染
onMounted(()=>{
  getAllStoreTypes().then((res)=>{
    for(let i=0; i<res.data.length; i++){
      let one = {
        label:res.data[i],
        value:res.data[i]
      }
      queryType.push(one)
    }
  })
  //由于后端的请求数据非常奇怪，我必须传入页码才能得到数据
  queryData({pageSize:10})
})

//页码更新事件
function pageCheck(index){
  queryData({pageIndex:index,pageSize:10})
}

const formHeader = {
  title: '查询条件',
  headerBtn: [
    {
      name: '更多',
      type: 'default',
      func: (...args) => {
        console.log(args)
      }
    }
  ]
}
const formConfig = {
  formItemList: [
    {
      more: true,
      // label: '',
      prop: itemModel.name,
      type: 'text',
      placeholder: '请输入商户名称'
    },
    {
      more: true,
      // label: '',
      prop: itemModel.type,
      type: 'select',
      placeholder: '请选择商户类型',
      optList: queryType
    },
    {
      more: true,
      // label: '',
      prop: itemModel.phone,
      type: 'text',
      placeholder: '请输入联系电话'
    }
  ],
  operate: [
    {
      name: '查询',
      type: 'primary',
      func: (args) => {
        queryData(args)
      }
    },
    {
      name: '重置',
      type: 'default',
      func: () => {
        searchFormModel.name = ''
        searchFormModel.type = ''
        searchFormModel.phone = ''
        //重置之后需要更新表单
        queryData({pageSize:10})
      }
    }
  ]
}

const TableHeader = {
  title: '商户信息',
}

const tableLabels = [
  {
    label: '商户名称',
    prop: itemModel.name
  },
  {
    label: '商户地址',
    prop: itemModel.address
  },
  {
    label: '联系电话',
    prop: itemModel.phone
  },
  {
    label: '商户类型',
    prop: itemModel.type
  },
  {
    label: '企业法人',
    prop: itemModel.juridicalPerson
  },
  {
    label: '成立日期',
    prop: itemModel.foundationDay
  },
  {
    label: '操作',
    prop: 'operation',
  }
]
// const tableData =
const searchFormModel = reactive({
  [itemModel.name]: '',
  [itemModel.type]: '',
  [itemModel.phone]: '',
})


</script>

<style scoped>

</style>
