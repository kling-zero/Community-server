<template>
  <PageLayout>
    <template #header>
      <Form
        :formHeader="basicFormHeader"
        :formInline="false"
        :formConfig="basicFormConfig"
        :formValue="basicFormValue"
      />
    </template>

    <template #default>
      <Table
        :header="tableHeader"
        :table-data="tableData"
        :table-label="tableLabel"
      >
      </Table>
    </template>
  </PageLayout>

  <!--添加菜单组的表单-->
  <Dialog
    v-model:model-value="modelValue"
    :title="modelTitle"
    class="dialog"
  >
    <el-divider />
    <el-form
      :label-position="labelPosition"
      label-width="100px"
      :model="addFormValue"
      style="max-width: 460px"
      class="addForm"
    >
      <section class="form-main--input">
        <el-form-item
          v-for="(inputItem, index) in addFormConfig.formItemList"
          v-show="inputItem.more"
          :key="index"
          :class="inputItem.type"
          :label="inputItem.label"
          :prop="inputItem.prop"
        >
          <!-- 输入框 -->
          <el-input
            v-if="inputItem.type === 'text'"
            v-model="addFormValue[inputItem.prop]"
            :placeholder="inputItem.placeholder"
            :clearable="true"
          />
          <!-- 富文本编辑器 -->
          <el-input
            v-if="inputItem.type === 'textarea'"
            v-model="addFormValue[inputItem.prop]"
            type="textarea"
            :placeholder="inputItem.placeholder"
            :clearable="true"
            :autosize="{minRows: 2}"
          />
          <!-- 选择框 -->
          <el-select
            v-if="inputItem.type === 'select'"
            v-model="addFormValue[inputItem.prop]"
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
    </el-form>
  </Dialog>
</template>

<script setup>
import {PageLayout, Form, Table, Dialog} from "@/components";
import {reactive, ref} from "vue";


// 表单
// 表单头
const moreButtonName = ref("更多")
const moreOption = ref(false)
const basicFormHeader = reactive({
  title: '查询条件',
  headerBtn: [
    {
      name: moreButtonName,
      type: 'default',
      func: () => {
        moreOption.value = !moreOption.value;
        moreButtonName.value = moreOption.value ? "隐藏" : "更多";
      }
    }
  ]
})
// 表单项
const basicFormConfig = reactive({
  formItemList:[
    {
      more: true,
      type: 'text',
      label: '',
      prop: 'menuGroupId',
      placeholder: '请输入菜单组ID',
    },
    {
      more: true,
      type: 'text',
      label: '',
      prop: 'menuGroupName',
      placeholder: '请输入菜单组名称',
    },
    {
      more: true,
      type: 'text',
      label: '',
      prop: 'icon',
      placeholder: '请输入图标',
    },
    {
      more: moreOption,
      type: 'select',
      label: '',
      prop: 'merchant',
      placeholder: '请选择商户',
    },
  ],
  operate: [
    {
      name: '查询',
      type: 'primary',
      func: () => {
        console.log("basicFormHeader的查询")
      }
    },
    {
      name: '重置',
      type: 'primary',
      func: () => {
        console.log("basicFormHeader的重置")
      }
    },
  ]
})
// 表单值
const basicFormValue = reactive({
  menuGroupId: '',
  menuGroupName: '',
  icon: '',
  merchant: '',
})

// 表格
const tableHeader = reactive({
  title: '菜单组信息',
  headerBtn: [
    {
      name: '添加',
      type: 'primary',
      func: () => {
        console.log("添加")
        modelValue.value = !modelValue.value
      }
    }
  ]

})
const tableData = reactive([
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
  }
])
const tableLabel = reactive([
  {
    prop: 'menuGroupId',
    label: '菜单组id',
  },
  {
    prop: 'menuGroupName',
    label: '菜单组名称',
  },
  {
    prop: 'menuGroupType',
    label: '菜单组类型',
  },
  {
    prop: 'merchant',
    label: '归属商户',
  },
  {
    prop: 'icon',
    label: '图标',
  },
  {
    prop: 'tab',
    label: '标签',
  },
  {
    prop: 'ordering',
    label: '序列',
  },
  {
    prop: 'operation',
    label: '操作',
    btn: [
      {
        name: '修改',
        type: 'default'
      },
      {
        name: '删除',
        type: 'default'
      }
    ]
  }
])

// 添加表单
const modelValue = ref(false)
const modelTitle = ref("添加菜单组")
const labelPosition = ref('left')

const addFormConfig = reactive({
  formItemList: [
    {
      more: true,
      type: 'text',
      label: '组名称',
      prop: 'menuGroupName',
      placeholder: '必填，请填写组名称'
    },
    {
      more: true,
      type: 'text',
      label: '图标',
      prop: 'icon',
      placeholder: '必填，请填写图标'
    },
    {
      more: true,
      type: 'select',
      label: '标签',
      prop: 'tab',
      placeholder: '选填，请选择标签'
    },
    {
      more: true,
      type: 'text',
      label: '序列',
      prop: 'ordering',
      placeholder: '必填，请填写序列'
    },
    {
      more: true,
      type: 'select',
      label: '组类型',
      prop: 'menuGroupType',
      placeholder: '选填，请选择组类型'
    },
    {
      more: true,
      type: 'select',
      label: '归属商户',
      prop: 'merchant',
      placeholder: '选填，请选择商户类型'
    },
    {
      more: true,
      type: 'textarea',
      label: '描述',
      prop: 'description',
      placeholder: '选填，请填写描述'
    },
  ]
})

const addFormValue = reactive({
  menuGroupName: '',
  icon: '',
  tab: '',
  ordering: '',
  menuGroupType: '',
  merchant: '',
  description: '',
})
</script>

<style scoped>
/deep/ .w-80 {
  width: 40%;
}

/deep/ .dialog, .el-form {
  margin: 0 58px;
}

/deep/ .addForm .el-select {
  width: 100%;
}
</style>