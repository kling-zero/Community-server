<script setup>
import { reactive, ref } from 'vue'
import { ZOTree, Table, PageLayout } from '@/components'
import MemberInfo from '../ownerMember/MemberInfo.vue'


let checkMore = ref(0)
let showDialog = ref(false)

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
      placeholder: '请填写房屋编号 格式 楼栋-单元-房屋',
      prop: 'roomName',
      more:'true'
    },
    {
      type: 'text',
      placeholder: '请输入联系方式',
      prop: 'link',
      more:'true'
    },
    {
      type: 'text',
      placeholder: '请输入业主ID',
      prop: 'memberId',
      more:checkMore
    },
    {
      type: 'text',
      placeholder: '请输入业主身份证号',
      prop: 'idCard',
      more:checkMore
    }
  ],
  operate: [
    {
      name: '查询',
      func: (data) => {
        console.log('query', data)
      }
    },
    {
      name: '重置',
      func: () => {
        console.log('reset')
      }
    }
  ]
})

const formValue = reactive({
  acctName: '',
  roomName: '',
  link: ''
})


const tableHeader = reactive({
  title: '业主信息',
  headerBtn: [
    {
      name: '添加业主',
      link: true,
      type:'primary',
      func: () => {
        console.log('添加业主')
        showDialog.value = true
      }
    }
  ]
})

const tableLabel = reactive([
  {
    label: '业主ID',
    prop: 'memberId'
  },
  {
    label: '姓名',
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
    label: '门禁钥匙	',
    prop: 'key' //变量名称不确定
  },
  {
    label: 'QQ',
    prop: 'qq'//变量名称不确定
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '变更',
        type: 'primary',
        func() {
          console.log('变更')
        }
      },
      {
        name: '详情',
        type: 'primary',
        func() {
          console.log('详情')
          showDetailDialog.value = true
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
    age: '22',
    idCard: '420000000000000000',
    link: '15666666666',
    userName: 'wuxw',
    key: '123456',
    qq: '31290000000'
  }
])

const form = reactive({
  name: '',
  sex: '',
  age: '',
  idCard: '',
  link: '',
  key: '',
  qq: '',
  remarks: '',
})

const onSubmit = () => {
  console.log('submit!')
}
const closeDialog = () => {
  console.log('submit!')
  showDialog.value = false
}
const showChangeDialog = ref(true)
const showDetailDialog = ref(false)
const showChangeBox = ref(false)

</script>

<template>
  <PageLayout>
    <template #header>
    
      <div>Info --- on the top</div>
    </template>
    <template #default>
      <Form
        :formInline="true"
        :formHeader="formHeader"
        :formConfig="formConfig"
        :formValue="formValue"
      />

      <div class="data-table">
        <el-row class="data-table-header">
          <el-col :span="5"><h4>业主信息</h4></el-col>
          <el-col :span="5" :push="17">
            <el-button type="primary" size="default" @click="showAddDialog = true">
              添加业主
            </el-button>
          </el-col>
        </el-row>
        <el-table :data="tableData" style="width: 100%" :table-layout="auto" class="data-table-content">
        
          <el-table-column prop="memberId" label="业主ID"/>
          <el-table-column prop="name" label="姓名" />
          <el-table-column prop="sex" label="性别" />
          <el-table-column prop="age" label="年龄" />
          <el-table-column prop="idCard" label="身份证" />
          <el-table-column prop="link" label="联系方式" />
          <el-table-column prop="userName" label="创建员工" />
          <el-table-column prop="key" label="门禁钥匙" />
          <el-table-column prop="qq" label="QQ" />
          <el-table-column fixed="right" label="操作" width="120">
            <template #default >
              <el-popover :visible="showChangeBox" placement="top" :width="140">
                <div style="text-align: center; margin: 0">
                  <el-button size="small" text @click="showChangeBox = false">cancel</el-button>
                  <el-button size="small" text @click="showChangeBox = false">confirm</el-button>
                  <el-button size="small" text @click="showChangeBox = false">confirm</el-button>
                  <el-button size="small" text @click="showChangeBox = false">confirm</el-button>
                </div>
                <template #reference>
                  <el-button @click="showChangeBox = true">变更</el-button>
                </template>
              </el-popover>
              <el-button link type="primary" size="small" @click="showDetailDialog = true"
                >详情
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      
      <!--添加业主弹窗  -->
      <el-dialog
        v-model="showDialog"
        title="添加业主"
        width="50%"
        :before-close="handleClose"
      >
          <el-form :model="form" label-width="120px">
            <el-row class="row-bg">
              <el-col :span="12"><div class="grid-content ep-bg-purple" />
                <el-form-item label="姓 名">
                  <el-input v-model="form.name" placeholder="必填，请填写姓名"/>
                </el-form-item>
                <el-form-item label="性 别">
                  <el-select v-model="form.sex" placeholder="必填，请选择性别">
                    <el-option label="男" value="男" />
                    <el-option label="女" value="女" />
                  </el-select>
                </el-form-item>
                <el-form-item label="年 龄">
                  <el-input v-model="form.age" placeholder="必填，请填写年龄" />
                </el-form-item>
                <el-form-item label="身 份 证">
                  <el-input v-model="form.idCard" placeholder="必填，"/>
                </el-form-item>

              </el-col>
              <el-col :span="12"><div class="grid-content ep-bg-purple" />
                <img src="/noPhoto.jpg" alt="用户头像"/>
              </el-col>
            </el-row>
            <el-row class="row-bg">
              <el-col :span="12"><div class="grid-content ep-bg-purple" />
                <el-form-item label="手 机">
                  <el-input v-model="form.link" placeholder="必填，请填写联系方式"/>
                </el-form-item>
                <el-form-item label="门 禁 钥 匙">
                  <el-input v-model="form.key" placeholder="必填，请填写门禁钥匙"/>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="r-input">
                <el-form-item label="备注">
                  <el-input v-model="form.remarks" placeholder="可填，请填写备注"/>
                </el-form-item>
                <el-form-item label="QQ">
                  <el-input v-model="form.qq" placeholder="必填，请填写QQ"/>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="19"></el-col>
              <el-col :span="5">
                <el-button type="primary" @click="onSubmit">保存</el-button>
                <el-button @click="closeDialog">取消</el-button>
              </el-col>
            </el-row>
          </el-form>  

      </el-dialog>
      <!-- 详情弹窗 -->
      <el-dialog
        v-model="showDetailDialog"
        width="80%"
        :before-close="handleClose"
        :show-close="false"
        class="detail-box"
      >
        <MemberInfo :ownerInfo="ownerInfo" :chooseAble="false"></MemberInfo>
      </el-dialog>

    </template>

  </PageLayout>
</template>

<style >
.r-input .el-form-item__label{
  justify-content: center !important;
  width: 90px !important;
}

.detail-box{
  background-color: transparent;
}

.data-table{
  margin-top: 5px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgb(215, 218, 224);
}
.data-table-header{
  border-bottom: 1px solid rgb(231, 234, 236);
  padding: 15px 15px 8px 15px;
}

.data-table-content{
  padding: 22px;

}
</style>
