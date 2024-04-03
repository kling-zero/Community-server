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
      <Table @changePage="pageCheck" :header="TableHeader" :tableLabel="tableLabel"
             :table-data="tableData" :current-page="pageIndex" :total="total"/>
    </template>
  </PageLayout>

  <el-dialog  v-model="dialogShow.community" title="商户小区">
    <div class="flex flex-row justify-end">
      <div class="w-1/3 mx-1">
        <el-input v-model="dialogComName" placeholder="请输入小区名称"/>
      </div>
      <div>
        <el-button type="primary" @click="dialogSearch">查询</el-button>
      </div>
    </div>

    <div class="my-6">
      <el-table :data="dialogCommunity" stripe style="width: 100%">
        <el-table-column prop="communityId" label="小区ID" width="180" />
        <el-table-column prop="name" label="名称" width="180" />
        <el-table-column prop="address" label="地址" width="180" />
        <el-table-column prop="state" label="状态" />
      </el-table>
    </div>

    <div class="flex justify-end">
      <el-pagination @current-change="checkDialogPage" background small
                     :current-page="dialogPage" layout="prev, pager, next"
                     :total="dialogTotal"/>
    </div>
  </el-dialog>

  <el-dialog v-model="dialogShow.login" title="密码确认">
    <el-form ref="formRef" size="large" :rules="rules" :model="formData" class="w-80">
      <el-form-item prop="password">
        <el-input v-model="formData.password" type="password" placeholder="请输入密码" show-password>
          <template #prefix>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
              <path stroke-linecap="round" stroke-linejoin="round" d="M16.5 10.5V6.75a4.5 4.5 0 10-9 0v3.75m-.75 11.25h10.5a2.25 2.25 0 002.25-2.25v-6.75a2.25 2.25 0 00-2.25-2.25H6.75a2.25 2.25 0 00-2.25 2.25v6.75a2.25 2.25 0 002.25 2.25z" />
            </svg>
          </template>
        </el-input>
      </el-form-item>

      <el-form-item prop="check">
        <el-input v-model="formData.code" placeholder="请输入验证码" style="width: 220px;">
          <template #prefix>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
              <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 5.25a3 3 0 013 3m3 0a6 6 0 01-7.029 5.912c-.563-.097-1.159.026-1.563.43L10.5 17.25H8.25v2.25H6v2.25H2.25v-2.818c0-.597.237-1.17.659-1.591l6.499-6.499c.404-.404.527-1 .43-1.563A6 6 0 1121.75 8.25z" />
            </svg>
          </template>
        </el-input>
        <div id="checkCode" class="code" @click="captchaCheck">
          <img :src="code" />
        </div>
      </el-form-item>
    </el-form>

    <div class="flex flex-row justify-end">
      <div class="mx-3">
        <el-button type="warning"
                   @click="dialogShow.login = false">取消</el-button>
      </div>
      <div>
        <el-button type="primary" @click="dialogLogin">√ 登录</el-button>
      </div>
    </div>
  </el-dialog>

  <el-dialog v-model="dialogShow.strain" title="请确认您的操作!" width="30%" center>
    <span>
      {{ strainText }}
    </span>
    <template #footer>
      <span class="dialog-footer">
        <el-button type="info" @click="dialogShow.strain = false">点错了</el-button>
        <el-button type="primary" @click="strainLogin">确认</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { Table, Form, PageLayout } from '@/components'
import {onBeforeUnmount, onMounted, reactive, ref} from 'vue'
import { itemModel } from './DataModels'
import {getAllAdmins, modifyRestrict, queryAllSubCommunities} from "@/apis/storemanager";
import {captcha, login} from "@/apis/login";
import {ElMessage} from "element-plus";
import {debounce} from "@/methods/method";
import {useRouter} from "vue-router/dist/vue-router";

// 定义登录数据对象
const formData = reactive({
  password: '',
  code:''
})

const rules = {
  password:[
    {
      required: true,
      message: '密码不能为空',
      trigger: 'blur'
    }],
  code:[
    {
      required: true,
      message: '验证码不能为空',
      trigger: 'blur'
    }],
}

//获取验证码
let code = ref("")
//更换验证码
function captchaCheck(){
  captcha().then(res=>{
    // console.log(res)
    code.value = res.data.imageBase64
  })
}

//移除键盘监听
onBeforeUnmount(()=>{
  document.removeEventListener("keyup", onKeyUp)
})

//监听回车时间
function onKeyUp(e){
  if(e.key === "Enter")
    submitForm()
}

// 获取router对象
const $router = useRouter()
let message = "账号密码错误"
// 定义登录提交函数
function submitForm() {
  //TODO[TEST_CODE]:测试直接进入主界面
  // $router.push('/home')

  // 发送登录请求
  login(
      {
        ...formData,
        username:dialogShow.currentName,
        clientId: import.meta.env.VITE_CLIENT_ID
      },
      () => {
        dialogShow.login = false
        queryData({pageSize:10})
        // 登录成功提示
        ElMessage.success('登录成功!')
      },
      (msg) => {
        message = msg
        loginError()
      }
  )
}
const loginError = debounce(() => {
  ElMessage.error(message)
}, 1000)


//页码修改逻辑
let pageIndex = ref(1)
let total = ref(10)

//向后端请求数据同时改变前端的渲染
//注意这个参数是非常灵活的, args可以适用于页码切换和各种查询
function queryData(args){
  //这里得到的数据是后端传递过来的数据，
  // 需要更新tableData的值 和 页码的值
  getAllAdmins(args).then((res)=>{
    // console.log(res)
    //更新当前表格的值
    tableData.splice(0,tableData.length)
    if(res.data.rows){
      for(let i=0; i<res.data.rows.length; i++){
        if(res.data.rows[i].status === "48001"){
          res.data.rows[i].status = "正常登录"
          res.data.rows[i].button = "限制登录"
        }else{
          res.data.rows[i].status = "登录受限"
          res.data.rows[i].button = "解除限制"
        }
        tableData.push(res.data.rows[i])
      }
    }
    //更新页码
    pageIndex.value = res.data.pageIndex
    //更新当前的total值
    total.value = res.data.total
  })
}

let dialogTotal = ref(10)
function querySmallData(args){
  //这里得到的数据是后端传递过来的数据，
  // 需要更新小表单的值 和 小表单页码的值
  queryAllSubCommunities(args).then((res)=>{
    // console.log(args)
    // console.log(res)
    //更新当前表格的值
    dialogCommunity.splice(0,dialogCommunity.length)
    if(res.data.rows !== undefined){
      for(let i=0; i<res.data.rows.length; i++)
        dialogCommunity.push(res.data.rows[i])
    }
    //更新页码
    dialogPage.value = res.data.pageIndex
    //更新当前的total值
    dialogTotal.value = res.data.total
  })
}

//页码更新事件
function pageCheck(index){
  queryData({pageIndex:index})
}

//表格数据
const tableData = reactive([])
onMounted(()=>{
  queryData({pageSize:10})
  document.addEventListener("keyup", onKeyUp)
})

//保存与弹窗相关的信息，包括弹窗控制和传递的信息
const dialogShow = reactive({
  community: false,
  login: false,
  strain: false,
  currentId: '',
  currentName:'',
  propertyCompanyName:''
})

//登录按钮
function dialogLogin(){
  submitForm()
}

//这是小表单的页码
let dialogPage = ref(1)
function checkDialogPage(index){
  querySmallData({pageIndex:index})
}

//查询小区需要做的操作
let dialogComName = ref("")
//隶属校区的弹窗数据,需要从后端获取
const dialogCommunity = reactive([])
function dialogSearch(args){
  // console.log(args)
  //向后端传递数据的时候，将propertyId改为communityId(接口文档这么写的)
  let argsChanged = {
    // communityId : args["propertyId"],
    communityId : "102022081507340423",
    pageIndex: 1,
    pageSize: 10
  }
  //如果用户查找小区名称，需要将此参数也返回
  if(dialogComName.value !== "")
    argsChanged.name = dialogComName.value

  // console.log(argsChanged)
  querySmallData(argsChanged)
}

//限制登录的操作, 该id为当前点击的id
let strainText = ref("")
function strainLogin(){
  // console.log({id:dialogShow.currentId})
  modifyRestrict({id:dialogShow.currentId}).then((res)=>{
    // console.log("strainName", dialogShow.propertyCompanyName)
    //如果响应成功了,就要改变table里面的值，并且不允许该用户登录
    for(let key in tableData){
      //说明找到了被限制的用户
      if(tableData[key].propertyCompanyName === dialogShow.propertyCompanyName){
        if(tableData[key].status === "登录受限"){
          tableData[key].status = "正常登录"
        }else{
          tableData[key].status = "登录受限"
        }
        break
      }
    }
  }).finally(()=>{
    // console.log(tableData)
    dialogShow.strain = false
  })
}

const formHeader = {
  title: '查询条件',
  headerBtn: [
    {
      name: '更多',
      type: 'default',
      func: (...args) => {
        // console.log(args)
      }
    }
  ]
}
const formConfig = {
  formItemList: [
    {
      more: true,
      // label: '',
      prop: itemModel.propertyCompanyName,
      type: 'text',
      placeholder: '请输入物业名称'
    },
    {
      more: true,
      // label: '',
      prop: itemModel.username,
      type: 'text',
      placeholder: '请输入管理员'
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
        searchFormModel.username = ''
        searchFormModel.phone = ''
        searchFormModel.propertyCompanyName = ''
        queryData({pageSize:10})
      }
    }
  ]
}

const TableHeader = {
  title: '物业信息',
}

const tableLabel = [
  {
    label: '物业名称',
    prop: itemModel.propertyCompanyName
  },
  {
    label: '管理员',
    prop: itemModel.username
  },
  {
    label: '管理员电话',
    prop: itemModel.phone
  },
  {
    label: '管理员ID',
    prop: itemModel.adminId
  },
  {
    label: '创建时间',
    prop: itemModel.createTime
  },
  {
    label: '状态',
    prop: itemModel.status
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '隶属小区',
        type: 'default',
        func: (args) => {
          dialogComName.value = ""
          dialogSearch(args)
          dialogShow.community = true
        }
      },
      {
        name: '登录',
        type: 'default',
        func: (args) => {
          // console.log(args)
          if(args.status === "正常登录"){
            //显示弹窗
            dialogShow.login = true
            //添加验证码
            captcha().then(res=>{
              code.value = res.data.imageBase64
              // console.log(res)
            })
            //保存当前点击的用户名
            dialogShow.currentName = args.username
          }else{
            ElMessage.error("不允许登录当前账号!")
          }
        }
      },
      {
        name: '限制/解除限制',
        type: 'default',
        func: (args) => {
          // console.log(args)
          dialogShow.currentId = args.propertyId
          dialogShow.propertyCompanyName = args.propertyCompanyName
          if(args.status === "登录受限"){
            strainText.value = "请确认是否对该账号解除登录限制?"
          }else{
            strainText.value = "请确认是否对该账号进行登陆受限?"
          }
          dialogShow.strain = true
        }
      },
    ]
  }
]

const searchFormModel = reactive({
  [itemModel.propertyCompanyName]: '',
  [itemModel.username]: '',
  [itemModel.phone]: '',
})



</script>

<style scoped>
.code
{
  /* font-family:Arial;
  font-style:italic; */
  margin: auto;
  /* color:blue;
  font-size:18px; */
  border:0;
  /* padding:2px 3px; */
  letter-spacing:3px;
  font-weight:bolder;
  float:left;
  cursor:pointer;
  width:90px;
  height:30px;
  line-height:30px;
  /* text-align:center; */
  vertical-align:middle;
  /* background-color:#D8B7E3; */
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
