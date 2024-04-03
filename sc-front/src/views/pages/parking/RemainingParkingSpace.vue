<template>
  <div class="contain">
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
  title: "剩余车位",
});
const tableLabel = reactive({
  labelWidth: "180px",
  labelList: [
    {
      label: "总车位数",
      prop: "ID",
    },
    {
      label: "剩余车位数",
      prop: "number",
    },
    {
      label: "采集时间",
      prop: "type",
    },
    {
      label: "操作",
      prop: "operation",
      btn: [
        {
          name: "刷新",
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

</script>

<style lang="scss" scoped></style>
