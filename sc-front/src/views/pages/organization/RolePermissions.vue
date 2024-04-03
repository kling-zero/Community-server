<template>
  <PageLayout>
    <template #aside>
      <el-card class="box-card">
        <el-button size="small">添加</el-button> <el-button size="small">修改</el-button>
        <el-button size="small">删除</el-button>
      </el-card>
      <ZOTree :option="{label: 'text'}" :value="OrganizationTree"/>
    </template>
    <template #header>
       <!-- 表格 -->
       <Table
        class="box-card"
        :header="header"
        :tableLabel="tableLabel"
        :tableData="tableData"
      >
      <template #rolePermissions>
        <div class="rolePermissions">
          <div>功能授权</div>
          <div>小区授权</div>
          <div>员工关联</div>
        </div>
      </template>
      </Table>
    </template>

  </PageLayout>
</template>

<script setup>
import { reactive, ref } from "vue";
import { PageLayout } from "@/components";

// 表格数据
const header = reactive({
  title: '',
})
const tableLabel = reactive([
  {
    label: '名称',
    prop: 'name'
  },
  {
    label: '手机号',
    prop: 'number'
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
    label: '性别',
    prop: 'gender'
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
        name: '删除',
        type: 'default',
        func: ({ ID }) => {}
      }
    ]
  }
])
const tableData = reactive([
  {
    name: '张三',
    number: '110',
    job: '法外狂徒',
    email: '125',
    address: '5',
    gender:'男'
  }
])

</script>

<style lang="scss" scoped>
.rolePermissions{
  display: flex;
  justify-content: space-between;
  width: 220px;
  font-size: 14px;
}
</style>
