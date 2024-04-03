<template>
  <div>
    <PageLayout>
      <template #header>
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span>修改密码</span>
            </div>
          </template>
          <div class="content">
            <el-form :model="form" label-width="120px">
            <el-form-item label="原密码">
              <el-input v-model="form.passwordOld" placeholder="必填，请输入原始密码" />
            </el-form-item>
            <el-form-item label="新密码">
              <el-input v-model="form.passwordNew" placeholder="必填，请输入新密码" />
            </el-form-item>
            <el-form-item label="新密码">
              <el-input
                v-model="form.secondPassword"
                placeholder="必填，请输入确认密码"
              />
            </el-form-item>
          </el-form>
          </div>
        </el-card>
      </template>
      <el-button type="primary" @click="onSubmit" class="onSubmit">确认修改</el-button>
    </PageLayout>
  </div>
</template>

<script setup>
import { reactive } from "vue";

// do not use same name with ref
const form = reactive({
  passwordOld: "",
  passwordNew: "",
  secondPassword: "",
});

const onSubmit = () => {
  console.log("submit!");
};
</script>

<style lang="scss" scoped>
.content{
  width:840px
}
.onSubmit{float: right;}
</style>
