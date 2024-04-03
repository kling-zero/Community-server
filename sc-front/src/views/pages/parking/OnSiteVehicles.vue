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
  title: "在场车辆",
});
const tableLabel = reactive({
  labelWidth: "105px",
  labelList: [
    {
      label: "进出场ID",
      prop: "ID",
    },
    {
      label: "车辆状态",
      prop: "number",
    },
    {
      label: "车牌号",
      prop: "type",
    },
    {
      label: "进场时间",
      prop: "outNumber",
    },
    {
      label: "在场时间(小时)",
      prop: "time",
    },
    {
      label: "业主",
      prop: "time",
    },
    {
      label: "车位",
      prop: "time",
    },
    {
      label: "起租时间",
      prop: "time",
    },
    {
      label: "截止时间",
      prop: "time",
    },
    {
      label: "状态",
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
      type: "input",
      label: "",
      prop: "ID",
      placeholder: "请输入车位编号",
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
