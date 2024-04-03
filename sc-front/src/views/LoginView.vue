<!-- 登录页面 -->
<template>
  <el-row style="min-height: 100vh" class="bg-indigo-500">
    <el-col
        :lg="16"
        style="display: flex"
        class="items-center justify-center">
      <div>
        <div class="hidden-md-and-down">
          <div class="font-bold text-7xl text-amber-50 mb-7">
            欢迎光临
          </div>
          <div class="text-2xl text-gray-200">
            此站点是零壹智慧社区物业管理系统，一套数字化智能物业管理系统
          </div>
        </div>

        <div class="flex hidden-md-and-down" style="max-width: 700px; max-height: 700px">
          <el-image src="../../register-min.png" fit="fill"></el-image>
        </div>

        <div class="flex hidden-lg-and-up" style="max-width: 400px; max-height: 400px">
          <el-image src="../../register-min.png" fit="fill"></el-image>
        </div>
      </div>
    </el-col>

    <el-col
        :lg="8"
        style="display:flex; flex-direction:column"
        class="bg-white items-center justify-center">
      <div class="font-bold text-3xl text-gray-800 hidden-md-and-down">欢迎回来</div>
      <div class="font-bold text-3xl text-gray-800 hidden-lg-and-up m-5">零壹智慧社区管理系统</div>
      <div class="items-center justify-center my-5
            text-gray-300 space-x-1">
        <span class="divide-indigo-200">———— </span>
        <span>账号密码登录</span>
        <span class="divide-indigo-200"> ————</span>
      </div>

      <el-form ref="formRef" :rules="rules" size="large" :model="formData" class="w-80">
        <el-form-item prop="username">
          <el-input v-model="formData.username" placeholder="请输入用户名">
            <template #prefix>
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                <path stroke-linecap="round"
                      stroke-linejoin="round"
                      d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z" />
              </svg>
            </template>
          </el-input>
        </el-form-item>

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

        <el-form-item>
          <el-button round color="#626aef" type="primary" @click="submitForm"
                     class="w-96">登录</el-button>
        </el-form-item>
      </el-form>

    </el-col>
  </el-row>
</template>

<script setup>
import {reactive, onMounted, onBeforeUnmount, ref} from 'vue'
import { login, captcha} from '../apis/login/index'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { debounce, throttle } from '@/methods/method'
import 'element-plus/theme-chalk/display.css'

// 获取router对象
const $router = useRouter()

// 定义登录数据对象
const formData = reactive({
  username: '',
  password: '',
  code:''
})

const rules = {
  username:[
    {
      required: true,
      message: '用户名不能为空',
      trigger: 'blur'
    }],
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

//监听回车时间
function onKeyUp(e){
  if(e.key === "Enter")
    submitForm()
}

//获取验证码
let code = ref("")
//更换验证码
function captchaCheck(){
  captcha().then(res=>{
    console.log(res)
    code.value = res.data.imageBase64
  })
}
//添加键盘监听
onMounted(()=>{
  document.addEventListener("keyup", onKeyUp)
  captcha().then(res=>{
    code.value = res.data.imageBase64
    // console.log(res)
  })
})
//移除键盘监听
onBeforeUnmount(()=>{
  document.removeEventListener("keyup", onKeyUp)
})

let message = "账号密码错误"
// 定义登录提交函数
function submitForm() {
  //TODO[TEST_CODE]:测试直接进入主界面
  // $router.push('/home')

  // 发送登录请求
  login(
    {
      ...formData,
      clientId: import.meta.env.VITE_CLIENT_ID
    },
    () => {
      // 跳转到首页
      $router.push('/home')
      // 登录成功提示
      ElMessage.success('登录成功，前往首页')
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
</script>

<style>
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
