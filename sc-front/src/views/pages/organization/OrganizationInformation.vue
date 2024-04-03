<template>
  <div>
    <PageLayout>
      <template #aside>
        <el-card class="box-card">
          <el-button size="small">添加</el-button>
          <el-button size="small">修改</el-button>
          <el-button size="small">删除</el-button>
        </el-card>
        <ZOTree :option="{label: 'text'}" :value="OrganizationTree"/>
      </template>
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
        >
        
        </Table>
      </template>
    </PageLayout>
    <!-- 弹窗 -->
    <el-dialog v-model="dialogTableVisible">
      <el-form :model="form" label-width="120px" inline="true">
        <el-form-item>
          <el-input v-model="form.name" placeholder="请输入员工名称" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
      </el-form>
      <el-table :data="gridData">
        <el-table-column property="name" label="员工名称" width="150" />
        <el-table-column property="phone" label="员工电话" width="200" />
        <el-table-column property="ID" label="员工编号" />
      </el-table>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogTableVisible = false">关闭</el-button>
          <el-button type="primary" @click="confirm"> 提交 </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import { PageLayout, ZOTree } from "@/components";
import { getOrganizations, associateEmployees, deleteOrganization, insertOrganization, queryNotAssociatedPersonnelByName, queryPersonnelByName } from '@/apis/Organization'
// 表单数据
// 表单标题
const more = ref(false);
const moreBtnName = ref("更多");
const dialogTableVisible = ref(false);

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
  ],
  operate: [
    {
      name: "查询",
      type: "primary",
      func: (v) => {

      },
    },
  ],
});
// 初始值
const formValue = reactive({
  name: "",
});

// 表格数据
const header = reactive({
  title: "关联员工",
  headerBtn: [
    {
      name: "关联员工",
      type: "primary",
      func: () => {
        dialogTableVisible.value = true;
      },
    },
  ],
});
const tableLabel = reactive([
  {
    label: "名称",
    prop: "name",
  },
  {
    label: "手机号",
    prop: "number",
  },
  {
    label: "岗位",
    prop: "job",
  },
  {
    label: "邮箱",
    prop: "email",
  },
  {
    label: "地址",
    prop: "address",
  },
  {
    label: "性别",
    prop: "gender",
  },
  {
    label: "操作",
    prop: "operation",
    btn: [
      {
        name: "删除",
        type: "default",
        func: ({ ID }) => {},
      },
      {
        name: "详情",
        type: "default",
        func: ({ ID }) => {},
      },
    ],
  },
]);
const tableData = reactive([
  {
    name: "张三",
    number: "110",
    job: "法外狂徒",
    email: "125",
    address: "5",
    gender: "男",
  },
  {
    name: "李四",
    number: "110",
    job: "法外狂徒",
    email: "125",
    address: "5",
    gender: "男",
  },
  {
    name: "王五",
    number: "110",
    job: "法外狂徒",
    email: "125",
    address: "5",
    gender: "男",
  },
]);

// 弹窗数据
const gridData = [
  {
    name: "2016-05-02",
    phone: "John Smith",
    ID: "No.1518,  Jinshajiang Road, Putuo District",
  },
];

const OrganizationTree = reactive([])

const selectedOrganize = ref()

const confirm = () => {
  dialogTableVisible.value = false;
};
// 弹窗员工名称查询
const form = reactive({
  name: "",
});

const onSubmit = () => {
  console.log("submit!");
};

function GetTreeData () {
  getOrganizations().then(res=>{
    if(res&&res.code===10000){
      OrganizationTree.splice(0, OrganizationTree.length, ...res.data)
    }
  })
}

function GetTableData (organizationId, personnelId) {
  associateEmployees({organizationId, personnelId}).then(res=>{
    if(res&&res.code===10000){
      tableData.splice(0, tableData.length, ...res.data)
    }
  })
}

GetTreeData()

GetTableData()
</script>

<style lang="scss" scoped></style>
