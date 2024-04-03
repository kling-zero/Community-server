<template>
<div>
  <PageLayout>
    <template #header>
      <!-- 表单 -->
      <Form
        :formHeader="formHeader"
        :formInline="true"
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
        :total="pageControl.total"
        v-model:current-page="pageControl.pageNum"
      >
      <template #remarks>
          温馨提示：新添加员工默认密码为123456，组织分配小区和员工分配权限后登录
        </template>
      </Table>
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
</div>
</template>

<script setup>
import { reactive, ref } from "vue";
import { PageLayout } from "@/components";
import { addMemberInfo,deleteMemberInfo,getMemberFullInfo,getMemberInfoList,resetPassword } from '@/apis/Organization'
import { ElMessage,ElMessageBox } from "element-plus";
// 表单数据
// 表单标题
const more = ref(false);
const moreBtnName = ref("更多");

const pageControl = reactive({
  pageNum: 1,
  total: 1,
})

const formHeader = reactive({
  title: "查询条件",
});
// 表单结构
const formConfig = reactive({
  formWidth: "",
  formItemList: [
    {
      more: true,
      type: "text",
      label: "",
      prop: "name",
      placeholder: "请填写员工名称",
    },
    {
      more: true,
      type: "text",
      label: "",
      prop: "number",
      placeholder: "请输入手机号",
    },
    {
      more: true,
      type: "text",
      label: "",
      prop: "ID",
      placeholder: "请填写员工ID",
    },
  ],
  operate: [
    {
      name: "查询",
      type: "primary",
      func: (v) => {
        console.log(v);
      },
    },
    {
      name: "重置",
      type: "primary",
      func: (v) => {
        console.log(v);
      },
    },
  ],
});
// 初始值
const formValue = reactive({
  number:'',
  name: '',
  ID:''
});

// 表格数据
const header = reactive({
  title: '员工管理',
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
    label: '员工编号',
    prop: 'ID'
  },
  {
    label: '名称',
    prop: 'name'
  },
  {
    label: '手机号',
    prop: 'number'
  },
  {
    label: '关联组织',
    prop: 'relation'
  },
  {
    label: '岗位',
    prop: 'job'
  },
  {
    label: '邮箱',
    prop: 'email'
  },
  {
    label: '地址',
    prop: 'address'
  },
  {
    label:'性别',
    prop:'gender'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '修改',
        type: 'default',
        func: ({ ID }) => {}
      },
      {
        name: '重置密码',
        type: 'default',
        func: (item) => {
          ElMessageBox.confirm(
          `即将重置${item.name}的密码，请确认`,
          '重置密码',
          {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
          }
        )
          .then(() => {
            resetPassword({id: item.ID}).then(res=>{
              if(res&&res.code===10000){
                ElMessage({
                  message:'重置密码成功',
                  type: 'success'
                })
                GetMembers()
              }
            })
          })
          .catch(() => {
            ElMessage({
              type: 'info',
              message: '重置密码中止',
            })
          })
        }
      },
      {
        name: '删除',
        type: 'default',
        func: (item) => {
          ElMessageBox.confirm(
            `即将删除${item.name}的信息，请确认`,
            '删除',
            {
              confirmButtonText: '确认',
              cancelButtonText: '取消',
              type: 'warning',
            }
          )
          .then(() => {
            deleteMemberInfo({id: item.ID}).then(res=>{
                if(res&&res.code===10000){
                  ElMessage({
                    message:'删除成功',
                    type: 'success'
                  })
                  GetMembers()
                }
              })
            })
            .catch(() => {
              ElMessage({
                type: 'info',
                message: '删除中止',
              })
            })

        }
      },
      {
        name: '详情',
        type: 'default',
        func: ({ ID }) => {}
      },
    ]
  }
])
const tableData = reactive([])


function GetMembers() {
  const pagePost = {
    pageSize: 10,
    pageIndex: pageControl.pageNum,
    id: formValue.ID,
    name: formValue.name,
    tel: formValue.number,
  }
  getMemberInfoList(pagePost).then(res=>{
    if(res&&res.code===10000){
      tableData.splice(0,tableData.length, ...res.data.rows)
      // pageControl.pageNum=res.data.pageIndex
      pageControl.total=res.data.total
    }
  })
}
GetMembers()
</script>

<style lang="scss" scoped></style>
