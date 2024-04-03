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
  title: "进场记录",
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
      label: "出场时间",
      prop: "time",
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
