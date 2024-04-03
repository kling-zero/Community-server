<script setup>
import { reactive, ref } from 'vue'
import { ZOTree, Table, PageLayout } from '@/components'
import {queryOwnerAccount,queryAccountType,queryAccountDetail,preStorage,querySelectOwner} from "@/apis/property/ownerAccount"

//更多查询框
let checkMore = ref(false)
//显示预存弹框
const showDialog = ref(false)
//显示账户明细
const showAccountDetailDialog = ref(false)

const formHeader = reactive({
  title: '查询条件',
  headerBtn: [
    {
      name: '更多',
      link: true,
      func: () => {
        checkMore.value = !checkMore.value
        console.log('more', checkMore.value)
      }
    }
  ]
})
const formConfig = reactive({

  formItemList: [
    {
      type: 'text',
      placeholder: '请输入业主名称',
      prop: 'acctName',
      more:'true'
    },
    {
      type: 'text',
      placeholder: '请输入业主身份证号',
      prop: 'acctIdCard',
      more:'true'
    },
    {
      type: 'text',
      placeholder: '请输入联系方式',
      prop: 'acctLink',
      more:'true'      
    },
    {
      type: 'select',
      placeholder: '必填，请选择账户类型',
      prop: 'typeName',
      more:checkMore,
      optList:[
        {
          value:'必填，请选择账户类型'
        },
        {
          value:'现金账户',
        },
        {
          value:'积分账户'
        },
        {
          value:'优惠券用户'
        },
        {
          value:'金币账户'
        },
        {
          value:'时间账户'
        }
      ]
    }
  ],
  operate: [
    {
      name: '查询',
      func: (data) => {
        console.log('query', data)
        data.acctType = getTypeId(data.typeName)//通过类型名获取类型编号
        queryOwnerAccountList(data)
      }
    },
    {
      name: '重置',
      func: () => {
        formValue.acctName = ''
        formValue.acctIdCard = ''
        formValue.acctLink = ''
        formValue.typeName = ''
        console.log('reset')
      }
    }
  ]
})
const formValue = reactive({
  acctName: '',
  acctIdCard: '',
  acctLink: '',
  typeName:'',
  acctType:'',
  pageIndex:'1',
  pageSize:'10',
})

const tableHeader = reactive({
  title: '业主账户',
  headerBtn: [
    {
      name: '预存',
      link: true,
      func: () => {
        showDialog.value = true
        querySelectOwnerList()//获取业主选择列表
        console.log('more', showDialog.value)
      }
    }
  ]
})
const tableLabel = reactive([
  {
    label: '账户编号',
    prop: 'acctId',
  },
  {
    label: '账户名称',
    prop: 'acctName'
  },
  {
    label: '账户类型',
    prop: 'acctTypeName'
  },
  {
    label: '账户金额',
    prop: 'amount'
  },
  {
    label: '创建时间',
    prop: 'createTime'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '账户明细',
        type: 'primary',
        func(data) {
          data.pageIndex = 1
          data.pageSize = 10
          console.log('进入账户明细页',data.pageIndex)
          queryAccountDetailInfo(data)//查询账户明细数据
          showAccountDetailDialog.value = true
        }
      }
    ]
  }
])
const tableData = reactive([
  {
    acctId: '312022102868500010',
    acctName: '李四',
    acctTypeName: '现金账户',
    amount: '20000.00',
    createTime: '2022-10-28 22:50:51',
  }
])
//账户明细的表格
const detailTableHeader = reactive({
  title: '账户明细',
  headerBtn: [
    {
      name: '返回',
      link: true,
      func: () => {
        showAccountDetailDialog.value = false
        console.log('more', showAccountDetailDialog.value)
      }
    }
  ]
})
const detailTableLabel = reactive([
  {
    label: '明细编号',
    prop: 'detailId'
  },
  {
    label: '交易编号',
    prop: 'orderId'
  },
  {
    label: '账户名称',
    prop: 'acctName'
  },
  {
    label: '明细类型',
    prop: 'detailType'
  },
  {
    label: '金额',
    prop: 'amount'
  },
  {
    label: '交易时间',
    prop: 'transactionTime'
  },
  {
    label: '说明',
    prop: 'remark'
  }
])
const detailTableData = reactive([
  {
    detailId: '312022102868500010',
    orderId: '321123',
    acctName: '李四',
    detailType: '',
    amount: '20000.00',
    transactionTime: '2022-10-28 22:50:51',
    remark: ''
  }
])
//预存框输入的值
const editValue = reactive({
  ownerPhone:'',
  ownerName:'',
  preStorageAmount:'',
  acctType:'',
  remark:'',

})

//类型名称与编码的关系数组
const typeInfo = reactive([])
//预存账户中的选择业主列表
const onwerSelectList = reactive([])


//通过用户类型名得到类型编号
function getTypeId(name){
  for(i=0;i<typeInfo.length;i++){
    if(name === typeInfo[i].typeName) return typeInfo[i].typeId
  }
}
//查询业主账户方法
async function queryOwnerAccountList(params){
  await queryOwnerAccount(params).then(resp=>{
    if(resp.code === 10000){
      tableData.length=0
      tableData.push(...resp.data.rows)
    }else{
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })

}
//获取账户类型名称与编码的关系数组方法
async function queryAccountTypeInfo(){
  await queryAccountType().then(resp=>{
    if(resp.code === 10000){
      typeInfo.push(...resp.data)
    }else{
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}
//查询操作明细
async function queryAccountDetailInfo(params){
  await queryAccountDetail(params).then(resp=>{
    if(resp.code === 10000){
      detailTableData.length = 0
      detailTableData.push(...resp.data.rows)
    }else{
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}
//预存账户
async function preStorageOperation(params){
  await preStorage(params).then(resp=>{
    if(resp.code === 10000){
      ElMessage.success("预存成功")
    }else{
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("操作失败，请稍后重试！")
  })
}
//获取预存账户中的选择业主列表
async function querySelectOwnerList(){
  await querySelectOwner().then(resp=>{
    if(resp.code === 10000){
      onwerSelectList.length = 0
      onwerSelectList.push(...resp.data)
    }else{
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("获取业主列表失败，请稍后重试！")
  })
}


//查询业主账户
queryOwnerAccountList(formValue)
//获取账户类型名称与编码的关系数组
queryAccountTypeInfo()
</script>

<template>
  <PageLayout>
    <template #header>
      <div>Account --- on the top</div>
    </template>
    <template #default>
      <Form
        :formInline="true"
        :formHeader="formHeader"
        :formConfig="formConfig"
        :formValue="formValue"
      />
        <Table
        :header="tableHeader"
        :tableLabel="tableLabel"
        :tableData="tableData"
      ></Table>

      <!-- 预存弹窗 -->
      <el-dialog
        v-model="showDialog"
        title="预存"
        width="50%"
        :before-close="handleClose">
        <el-form :model="editValue" label-width="120px" >
          <el-form-item label="业主手机">
            <el-input v-model="editValue.ownerPhone" placeholder="必填，请填写业主手机"/>
          </el-form-item>
          <el-form-item label="业主名称">
            <el-select v-model="editValue.ownerName" placeholder="必填，请选择业主">
              <el-option v-for="{owner,index} in onwerSelectList" :key="index" :label="owner.name" :value="owner.name" />
            </el-select>
          </el-form-item>
          <el-form-item label="预存金额">
            <el-input v-model="editValue.preStorageAmount" placeholder="必填，请填写预存金额"/>
          </el-form-item>
          <el-form-item label="账户类型">
            <el-select v-model="editValue.acctType" placeholder="必填，请选择账户类型">
              <el-option label="现金账户" value="2003" />
              <el-option label="积分账户" value="2004" />
              <el-option label="优惠券账户" value="2005" />
              <el-option label="金币账户" value="2006" />
              <el-option label="时间账户" value="2007" />
            </el-select>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="editValue.remark" placeholder="请填写备注信息" type="textarea"/>
          </el-form-item>
          <el-row>
            <el-col :span="19"></el-col>
            <el-col :span="5">
              <el-button @click="showDialog = false" type="info">取消</el-button>
              <el-button type="primary" @click="preStorageOperation(editValue);showDialog=false"><el-icon :size="20" color="#fff"><Check /></el-icon>保存</el-button>
            </el-col>
          </el-row>

        </el-form>
      </el-dialog>

      <!-- 账户明细弹窗 -->
      <el-dialog
        v-model="showAccountDetailDialog"
        width="85%"
        :before-close="handleClose"
        :show-close="false"
        class="detail-box"
        >
        <Table
        :header="detailTableHeader"
        :tableLabel="detailTableLabel"
        :tableData="detailTableData"
        ></Table>
      </el-dialog>

    </template>
  </PageLayout>
</template>

<style>
.detail-box{
  background-color: transparent;
}
</style>
