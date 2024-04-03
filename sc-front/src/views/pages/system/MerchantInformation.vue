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
    <!-- 表单弹窗 -->
    <el-dialog v-model="dialogFormVisible" title="添加">
      <el-form :model="form">
        <el-form-item label="配置类型" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="必填，请选择配置类型">
            <el-option label="装修" value="shanghai" />
            <el-option label="费用" value="beijing" />
            <el-option label="支付宝支付" value="beijing" />
            <el-option label="云卓全景支付" value="beijing" />
            <el-option label="消息推送" value="beijing" />
          </el-select>
        </el-form-item>
        <el-form-item label="配置名称" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="必填，请选择配置名称">
            <el-option label="装修" value="shanghai" />
            <el-option label="费用" value="beijing" />
            <el-option label="支付宝支付" value="beijing" />
            <el-option label="云卓全景支付" value="beijing" />
            <el-option label="消息推送" value="beijing" />
          </el-select>
        </el-form-item>
        <el-form-item label="配置KEY" :label-width="formLabelWidth">
          <el-input v-model="form.KEY" disabled placeholder="必填，请选择配置KEY" />
        </el-form-item>
        <el-form-item label="配置取值" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" placeholder="必填，请填写配置取值"/>
        </el-form-item>
        <el-form-item label="配置取值" :label-width="formLabelWidth">
          <el-input
            v-model="textarea"
            :rows="2"
            type="textarea"
            placeholder="选填，请填写备注"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false"> 保存 </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import { PageLayout } from "@/components";
// 表单数据
// 表单标题
const more = ref(false);
const moreBtnName = ref("更多");
const dialogFormVisible = ref(false);

const formHeader = reactive({
  title: "基本信息",
});
// 表单结构
const formConfig = reactive({
  formWidth: "",
  formItemList: [
    {
      more: true,
      type: "text",
      label: "",
      prop: "settingName",
      placeholder: "请输入流程名称",
    },
    {
      more: true,
      type: "select",
      label: "",
      prop: "type",
      placeholder: "请选择流程",
      optList: [
        {
          label: "投诉建议",
          value: "投诉建议",
        },
        {
          label: "采购",
          value: "采购",
        },
        {
          label: "支付宝支付",
          value: "支付宝支付",
        },
        {
          label: "云卓全景支付",
          value: "云卓全景支付",
        },
        {
          label: "消息推送",
          value: "消息推送",
        },
        {
          label: "富友支付",
          value: "富友支付",
        },
        {
          label: "预约车登记次数",
          value: "预约车登记次数",
        },
      ],
    },
    {
      more: true,
      type: "text",
      label: "",
      prop: "settingKeyName",
      placeholder: "请输入流程编码",
    },
    {
      more: true,
      type: "text",
      label: "",
      prop: "settingName",
      placeholder: "请输入信息ID",
    },
  ],
  operate: [
    {
      name: "查询",
      type: "primary",
      func: (v) => {
        tableData = tableData.filter((item) => item.name === v.name);
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
  title: "商户信息",
  headerBtn: [
    {
      name: "添加",
      type: "primary",
      func: () => {
        dialogFormVisible.value = true;
      },
    },
  ],
});
const tableLabel = reactive([
  {
    label: "流程名称",
    prop: "name",
  },
  {
    label: "流程类型",
    prop: "number",
  },
  {
    label: "流程编码",
    prop: "job",
  },
  {
    label: "创建时间",
    prop: "email",
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
let tableData = reactive([
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
const form = reactive({
  name: "",
  region: "",
  date1: "",
  date2: "",
  delivery: false,
  type: [],
  resource: "",
  desc: "",
});
const confirm = () => {
  dialogFormVisible.value = false;
};
const onSubmit = () => {
  console.log("submit!");
};
</script>

<style lang="scss" scoped></style>
