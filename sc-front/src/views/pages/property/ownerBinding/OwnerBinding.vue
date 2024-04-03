<script setup>
import { reactive, ref } from 'vue'
import { ZOTree, Table, PageLayout } from '@/components'
import {queryCheckList,queryCheckType,changeBindType} from "@/apis/property/ownerBinding"

let checkMore = ref(false)
const resetPwdDialog = ref(false)
const showUnbindDialog = ref(false)
//解绑或重置密码的对象的参数
const optObj = reactive({
  appUserName:'',
  operation:''
})

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
      prop: 'appUserName',
      more:'true'
    },
    {
      type: 'text',
      placeholder: '请输入业主身份证号',
      prop: 'idCard',
      more:'true'
    },
    {
      type: 'select',
      placeholder: '请选择状态',
      prop: 'stateName',
      optList:[
        {
          value:'请选择状态'
        },
        {
          value:'审核中'
        },
        {
          value:'审核完成'
        },
        {
          value:'审核失败'
        }
      ],
      more:'true'
    },
    {
      type: 'text',
      placeholder: '请输入业主手机',
      prop: 'link',
      more:checkMore
    }
  ],
  operate: [
    {
      name: '查询',
      func: (data) => {
        data.pageSize = 10
        data.pageIndex = 1
        //state转换=========
        queryCheckListInfo(data)
        console.log('查询query', data)
      }
    },
    {
      name: '重置',
      func: () => {
        formValue.appUserName= ''
        formValue.acctId= ''
        formValue.stateName= ''
        formValue.link=''
        console.log('reset')
      }
    }
  ]
})
const formValue = reactive({
  appUserName: '',
  idCard: '',
  stateName: '',
  link:'',
  pageSize:'',
  pageIndex:'',
  state:''
})

const tableHeader = reactive({
  title: '审核业主绑定'
})
const tableLabel = reactive([
  {
    label: '绑定ID',
    prop: 'appUserId'
  },
  {
    label: '业主ID',
    prop: 'memberId'
  },
  {
    label: '小区ID',
    prop: 'communityId'
  },
  {
    label: '小区名称',
    prop: 'communityName'
  },
  {
    label: '关联业主	',
    prop: 'appUserName'
  },
  {
    label: '身份证',
    prop: 'idCard'
  },
  {
    label: '手机号',
    prop: 'link'
  },
  {
    label: '状态',
    prop: 'stateName'
  },
  {
    label: '申请时间',
    prop: 'createTime'
  },
  {
    label: '手机端类型',
    prop: 'appTypeName'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '解绑',
        type: 'info',
        func(data) {
          console.log('解绑'+data.appUserName)
          optObj.appUserName = data.appUserName
          optObj.operation = 0  //设置操作类型 删除
          showUnbindDialog.value = true
        }
      },
      {
        name: '重置密码',
        type: 'info',
        func(data) {
          console.log('reset pwd'+data.appUserName)
          optObj.appUserName = data.appUserName
          optObj.operation = 0  //设置操作类型 重置
          resetPwdDialog.value = true
        }
      }
    ]
  }
])
const tableData = reactive([
  {
    appUserId: '982022102816390935',
    memberId: '772022102853620921',
    communityId: '2022090665021542',
    communityName: '演示物业（误删）',
    appUserName: '李四1',
    idCard: '420000000000000000',
    link: '15666666666',
    stateName: '审核成功',
    createTime: '2022-10-28 14:45:38',
    appTypeName: '公众号'
  },
  {
    appUserId: '982022102816390935',
    memberId: '772022102853620921',
    communityId: '2022090665021542',
    communityName: '演示物业1（误删）',
    appUserName: '李四2',
    idCard: '420000000000000000',
    link: '15666666666',
    stateName: '审核成功',
    createTime: '2022-10-28 14:45:38',
    appTypeName: '公众号'
  }
])

//查询操作
async function queryCheckListInfo(params){
  await queryCheckList(params).then(resp=>{
    tableData.length=0//清空
    tableData.push(...resp.data.rows)
  }).catch(err=>{
    console.log(err)
    ElMessage.error("查询数据失败，请稍后重试！")
  })
}
//解绑和重置密码操作
async function changeBindTypeOperation(params){
  await changeBindType(params).then(resp=>{
    if(resp.code === 10000){
      if(resp.data.operation==0){//删除操作
        ElMessage.success("删除成功")
        queryCheckListInfo(formValue)//重新查询列表
      }else{//重置密码操作
        ElMessage.success("重置成功，新密码："+resp.data.newPassword)
      }
    }else{
      ElMessage.error(resp.data.message)
    }
  }).catch(err=>{
    console.log(err)
    ElMessage.error("查询数据失败，请稍后重试！")
  })
}

</script>

<template>
  <PageLayout>
    <template #header>
      <div>Binding --- on the top</div>
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
      <!-- 重置密码 确认弹窗 -->
      <el-dialog
        v-model="resetPwdDialog"
        title="请确认您的操作!"
        width="30%"
        :before-close="handleClose"
      >
        <span>确认是否重置密码!</span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="resetPwdDialog = false" type="info">点错了</el-button>
            <el-button type="primary" :plain="true" @click="changeBindTypeOperation(optObj)">
              确认重置
            </el-button>
          </span>
        </template>
      </el-dialog>
      <!-- 解绑确认弹窗 -->
      <el-dialog
        v-model="showUnbindDialog"
        title="请确认您的操作!"
        width="30%"
        :before-close="handleClose"
      >
        <span>确认是否解绑!</span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="showUnbindDialog = false" type="info">点错了</el-button>
            <el-button type="primary"  @click="changeBindTypeOperation(optObj)">
              确认解绑
            </el-button>
          </span>
        </template>
      </el-dialog>

    </template>
    
  </PageLayout>
</template>

<style scoped></style>
