<template>
  <div class="contain">
    <!-- 表单 -->
    <Form :formHeader="formHeader" :formConfig="formConfig" :value="value" @input="input(v)"></Form>
    <!-- 表格 -->
    <Table
      class="box-card"
      :header="header"
      :tableLabel="tableLabel"
      :tableData="tableData"
    ></Table>
  </div>
</template>

<script setup>
import { reactive } from "vue";
// 表格数据
const header = reactive({
  title: "岗亭信息",
  headerBtn: [
    {
      name: "添加",
      type: "primary",
      func: () => {
        console.log(11);
      },
    },
  ],
});
const tableLabel = reactive({
  labelWidth: "125px",
  labelList: [
    {
      label: "岗亭编号",
      prop: "ID",
    },
    {
      label: "岗亭名称",
      prop: "number",
    },
    {
      label: "停车场",
      prop: "type",
    },
    {
      label: "临时车进场",
      prop: "outNumber",
    },
    {
      label: "是否收费	",
      prop: "time",
    },
    {
      label: "蓝牌车进场",
      prop: "time",
    },
    {
      label: "黄牌车进场",
      prop: "time",
    },
    {
      label: "备注",
      prop: "time",
    },
    {
      label: "操作",
      prop: "operation",
      btn: [
        {
          name: "共享岗亭",
          type: "default",
          func: ({ ID }) => {},
        },
        {
          name: "控制台",
          type: "default",
          func: ({ ID }) => {},
        },
        {
          name: "修改",
          type: "default",
          func: ({ ID }) => {},
        },
        {
          name: "删除",
          type: "default",
          func: ({ ID }) => {},
        },
      ],
    },
  ],
});
const tableData = reactive([
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "126",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
  {
    ID: "102022101305621558",
    number: "11",
    type: "地上停车场",
    outNumber: "125",
    time: "",
  },
]);

// 表单数据
const formHeader=reactive({
  title: "查询条件",
  headerBtn: [
    {
      name: "更多",
      type: "primary",
      func: () => {
        console.log(11);
      },
    },
  ],
})
const formConfig = reactive({
  inline:true,
  formWidth: "",
  formItemList: [
    {
      type: "input",
      label: "",
      prop: "编号",
      placeholder: "请选择停车场",
    },
    {
      type: "input",
      label: "",
      prop: "ID",
      placeholder: "请输入车位编号",
    },
    {
      type: "select",
      label: "",
      prop: "类型",
      placeholder: "请选择车位状态",
      optList: [
        {
          label: "出售",
          value: "地上停车场",
        },
        {
          label: "出租",
          value: "地下停车场",
        },
        {
          label: "空闲",
          value: "地下停车场",
        },
      ],
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
  ],
});
const value = reactive({
  编号: "5135",
  类型: "地下停车场",
  ID:'7762'
});
</script>

<style lang="scss" scoped></style>
