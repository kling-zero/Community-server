<template>
  <el-card>
    <!-- 表单标题 -->
    <template v-if="formHeader" #header>
      <header class="form-header">
        <!-- 标题内容 -->
        <span class="form-header--title">{{ formHeader.title }}</span>
        <!-- 标题按钮 -->
        <el-button
          v-for="btnItem in formHeader.headerBtn"
          :key="btnItem.name"
          :type="btnItem.type || 'primary'"
          :link="btnItem.link"
          :icon="btnItem.icon"
          @click="btnItem.func()"
        >
          {{ btnItem.name }}
        </el-button>
      </header>
    </template>
    <template #default>
      <!-- 表单数据 -->
      <el-form class="form-main" :inline="formInline" :model="formValue">
        <section class="form-main--input">
          <el-form-item
            v-for="(inputItem, index) in formConfig.formItemList"
            v-show="inputItem.more"
            :key="index"
            :class="inputItem.type"
            :label="inputItem.label"
            :prop="inputItem.prop"
          >
            <!-- 输入框 -->
            <el-input
              v-if="inputItem.type === 'text'"
              v-model="formValue[inputItem.prop]"
              :placeholder="inputItem.placeholder"
              :clearable="true"
            />
            <!-- 富文本编辑器 -->
            <el-input
              v-if="inputItem.type === 'textarea'"
              v-model="formValue[inputItem.prop]"
              :placeholder="inputItem.placeholder"
              :clearable="true"
            />
            <!-- 选择框 -->
            <el-select
              v-if="inputItem.type === 'select'"
              v-model="formValue[inputItem.prop]"
              :placeholder="inputItem.placeholder"
              :multiple="inputItem.multiple"
            >
              <!-- 选择框选项 -->
              <el-option
                v-for="(optItem, index) in inputItem.optList"
                :key="index"
                :label="optItem.label"
                :value="optItem.value"
              />
            </el-select>
          </el-form-item>
        </section>
        <section class="form-main--button">
          <el-form-item class="button">
            <el-button
              v-for="(operateItem, index) in formConfig.operate"
              :key="index"
              :type="operateItem.type || 'primary'"
              :link="operateItem.link"
              :icon="operateItem.icon"
              @click="operateItem.func(formValue)"
            >
              {{ operateItem.name }}
            </el-button>
          </el-form-item>
        </section>
      </el-form>
    </template>
  </el-card>
</template>

<script setup>
const props = defineProps({
  formHeader: {
    type: Object,
    required: false
  },
  formInline: {
    type: Boolean,
    default: false
  },
  formConfig: {
    type: Object,
    require: true
  },
  formValue: {
    type: Object,
    require: true
  }
  // 表单规则
  // rules: {
  //   type: Object,
  //   require: true,
  // },
})
</script>

<style lang="scss" scoped>
:deep(.el-card__header) {
  padding: 8px 12px;
  .form-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 10px;
    color: #676a6c;
    .form-header--title {
      font-size: 14px;
      font-weight: 600;
    }
  }
}

.form-main {
  display: flex;
  .form-main--input {
    flex-wrap: wrap;
    min-width: 80%;
  }
  .form-main--button {
    flex: 1;
  }
  :deep(.el-form-item) {
    margin: 0;
    padding: 0 32px 16px 0;
    &:not(.button) {
      flex: 1 0 30%;
      max-width: 40%;
    }
    .el-select {
      flex: 1;
    }
    .el-button {
      margin: 4px;
    }
  }
}
</style>
