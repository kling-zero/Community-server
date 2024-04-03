<script setup>
import { reactive,ref } from 'vue'
import { ZOTree, Table, PageLayout ,Dialog} from '@/components'
import MemberInfo from './MemberInfo.vue'
import { queryOwnerList} from "@/apis/property/ownerMember"
import { ElMessage } from 'element-plus'

const showDialog = ref(false)
const showEditDialog = ref(false)

const formHeader = reactive({
  title: '业主信息',
  headerBtn:[
    {
      name:'选择业主',
      link:'true',
      func:()=>{
        console.log("选择业主")
        showDialog.value = true
      }
    }
  ]

})

const formConfig = reactive({
  formItemList:[]
})

const tableHeader = reactive({
  title: ''
})

const tableLabel = reactive([
  {
    label: '成员ID',
    prop: 'memberId'
  },
  {
    label: '名称',
    prop: 'name'
  },
  {
    label: '性别',
    prop: 'sex'
  },
  {
    label: '年龄',
    prop: 'age'
  },
  {
    label: '类型',
    prop: 'type'//不确定变量名称
  },
  {
    label: '身份证',
    prop: 'idCard'
  },
  {
    label: '联系方式',
    prop: 'link'
  },
  {
    label: '创建员工',
    prop: 'userName'
  },
  {
    label: '备注',
    prop: 'remark'
  },
  {
    label: '门禁钥匙',
    prop: 'key'
  },
  {
    label: 'QQ',
    prop: 'qq'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '修改',
        type: 'primary',
        func() {
          console.log('change')
          showEditDialog.value = true
        }
      }
    ]
  }
])

const tableData = reactive([
  {
    memberId: '772022102853620921',
    name: '李四',
    sex: '男',
    age: '13',
    type: '类型',
    idCard: '420000000000000000',
    link: '15666666666',
    userName: 'wuxw',
    remark: '',
    key: '123456',
    qq: '31290000000'
  }
])

//信息卡显示的数据
const ownerInfo = reactive({
    memberId:'772022102853620921',
    name: '李四',
    sex: '男',
    age: '13',
    idCard: '420000000000000000',
    link: '15666666666',
    userName: 'wuxww',
    remark:''
})

//修改操作对象信息
const memberInfo = reactive({
  memberId:'772022102853620921',
  name: '',
  sex: '',
  age: '',
  type:'',
  idCard: '',
  link: '',
  userName: '',
  remark:'',
  key:'',
  qq:''
})

//获取业主成员列表数据列表
async function queryOwnerListInfo(params){
  await queryOwnerList(params).then(resp=>{
    tableData.length = 0  //清空列表
    tableData.push(...resp.data.rows) //将返回的数据加入数组
  }).catch(err=>{
    console.log(err)
    ElMessage.error("获取业主列表失败")
  })

}

</script>

<template>
  <PageLayout>
    <template #header>
      <div>Member --- on the top</div>
    </template>
    
    <template #default>
      <!-- <Form
        :formHeader="formHeader"
        :formConfig="formConfig"
      ></Form> -->
      <MemberInfo :ownerInfo="ownerInfo" :chooseAble="true"></MemberInfo>
      <Table
      :header="tableHeader"
      :tableLabel="tableLabel"
      :tableData="tableData"
      ></Table>
      <!-- 修改操作弹窗 -->
      <el-dialog
        v-model="showEditDialog"
        title="修改信息"
        width="50%"
        :before-close="handleClose">
        <el-form :model="memberInfo" label-width="120px" >
          <el-form-item label="成员ID">
            <el-input v-model="memberInfo.memberId" placeholder="必填，请填写业主手机"/>
          </el-form-item>
          <el-form-item label="名称">
            <el-input v-model="memberInfo.name" placeholder="必填，请填写名称"/>
          </el-form-item>
          <el-form-item label="性别">
            <el-select v-model="memberInfo.sex" placeholder="必填，请选择性别">
              <el-option label="必填，请选择性别" value="男" />
              <el-option label="男" value="男" />
              <el-option label="女" value="女" />
            </el-select>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="memberInfo.age" placeholder="必填，请填写年龄" type="number"/>
          </el-form-item>
          <el-form-item label="类型">
            <el-select v-model="memberInfo.type" placeholder="必填，请选择类型">
              <el-option label="必填，请选择性别" value="男" />
              <el-option label="男" value="男" />
              <el-option label="女" value="女" />
            </el-select>
          </el-form-item>
          <el-form-item label="身份证">
            <el-input v-model="memberInfo.idCard" placeholder="必填，请填写身份证"/>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="memberInfo.link" placeholder="必填，请填写联系方式"/>
          </el-form-item>
          <el-form-item label="QQ">
            <el-input v-model="memberInfo.qq" placeholder="必填，请填写qq"/>
          </el-form-item>
          <el-row>
            <el-col :span="19"></el-col>
            <el-col :span="5">
              <el-button @click="showEditDialog = false" type="info">取消</el-button>
              <el-button type="primary" @click="onSubmit"><el-icon :size="20" color="#fff"><Check /></el-icon>保存</el-button>
            </el-col>
          </el-row>

        </el-form>
      </el-dialog>

    </template>
    
  </PageLayout>
</template>

<style scoped></style>
