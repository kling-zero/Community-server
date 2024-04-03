<template>
  <PageLayout>
    <template #header>
      <div class="menu-config-step">
        <el-steps :active="stepNumber" align-center finish-status="success" >
          <el-step title="选择菜单组"/>
          <el-step title="菜单信息" />
          <el-step title="权限信息" />
        </el-steps>
      </div>
    </template>

    <template #default>
      <!-- 卡片 -->
      <el-card class="box-card" >
        <!-- 卡片头 -->
        <template #header>
          <div class="card-header" v-if="stepNumber === 0">
            <!-- 标题 -->
            <span>菜单组信息</span>
            <!-- 按钮 -->
            <div class="card-button">
              <el-button type="primary" :icon="Search" @click="selectMenuGroup">选择菜单组</el-button>
              <el-button type="primary" :icon="Plus" @click="addMenuGroup">添加菜单组</el-button>
            </div>
          </div>
          <div class="card-header" v-if="stepNumber === 1">
            <span>配置菜单</span>
          </div>
          <div class="card-header" v-if="stepNumber === 2">
            <span>菜单权限</span>
          </div>
        </template>

        <!-- 卡片体 -->
        <div class="step1-card-body" v-show="stepNumber === 0">
          <!-- 第一行 -->
          <div class="card-row1" style="display: flex; flex-direction: row; margin-bottom: 30px">
            <div class="row1-col1" style="max-width: 33.333333%; width: 100%">
              <label>
                <span>组名称</span>
                ：
              </label>
              <label>{{formValue.menuGroupName}}</label>
            </div>
            <div class="row1-col2" style="max-width: 33.333333%; width: 100%">
              <label>
                <span>icon：</span>
              </label>
              <label>{{formValue.icon}}</label>
            </div>
            <div class="row1-col3" style="max-width: 33.333333%; width: 100%">
              <label>
                <span>标签：</span>
              </label>
              <label>{{formValue.tab}}</label>
            </div>
          </div>
          <!-- 第二行 -->
          <div class="card-row2" style="display: flex; flex-direction: row; margin-bottom: 30px">
            <div class="row2-col1" style="max-width: 33.333333%; width: 100%  ">
              <label>
                <span>序列：</span>
              </label>
              <label>{{formValue.menuOrdering}}</label>
            </div>
            <div class="row2-col2" style="max-width: 33.333333%; width: 100%  ">
              <label>
                <span>描述：</span>
              </label>
              <label>{{formValue.groupDescription}}</label>
            </div>
          </div>
        </div>
        <div class="step2-card-body" v-show="stepNumber === 1">
          <el-form
            :label-position="'left'"
            ref="form"
            :model="formValue"
          >
            <el-form-item
              v-for="(inputItem, index) in step2InputList"
              :key="index"
              :label="inputItem.label"
              :required="inputItem.required"
              :prop="inputItem.prop"
            >
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
                :type="inputItem.type"
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
          </el-form>
        </div>
        <div class="step3-card-body" v-show="stepNumber === 2">
          <el-form
            :label-position="'left'"
            show-message
            :model="formValue"
            ref="form2"
          >
            <el-form-item
              v-for="(inputItem, index) in step3InputList"
              :key="index"
              :label="inputItem.label"
              :prop="inputItem.prop"
              :required="inputItem.required"
            >
              <el-input
                v-if="inputItem.type === 'text'"
                v-model="formValue[inputItem.prop]"
                :placeholder="inputItem.placeholder"
                :clearable="true"
                :disabled=inputItem.disabled
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
          </el-form>
        </div>
      </el-card >

      <!-- 按钮 -->
      <div style="display: flex; flex-direction: row-reverse; margin-top: 10px">
        <div class="btn" style="position: relative; right: 10px">
          <el-button type="info" @click="back">上一步</el-button>
          <el-button
            type="primary"
            @click="next"
          >
            {{ stepNumber === 2 ? "完成" : "下一步" }}
          </el-button>
        </div>
      </div>
    </template>

  </PageLayout>

  <!-- 选择菜单组的对话框 -->
  <div>
    <el-dialog
      v-model="selectGroup"
      :title="selectGroupTitle"

    >
      <el-divider />
      <div class="input-group" style="display: flex; flex-direction: row;">
        <div class="bak" style="min-width: 58.333333%"></div>
        <el-input placeholder="输入菜单组名称"></el-input>
        <el-button type="primary">查询</el-button>
      </div>
      <el-table :data="selectGroupTableData" stripe style="width: 100%" :min-width="600">
        <el-table-column
          v-for="(tableLabel, index) in selectGroupTableLabel"
          :key="index"
          :prop="tableLabel.prop"
          :label="tableLabel.label"
          :min-width="tableLabel.minWidth"
        >
          <template #default="scope" v-if="tableLabel.btn">
            <!-- 表格操作按钮 -->
            <el-button
              v-for="btnContent in tableLabel.btn"
              :key="btnContent.name"
              :type="btnContent.type"
              size="small"
              @click="btnContent.func(scope.row)"
            >{{ btnContent.name }}
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>

  <!-- 添加菜单组的对话框-->
  <Dialog
    v-model:model-value="modelValue"
    :title="modelTitle"
    class="dialog2"
    ref="childDialogRef"
  >
    <el-divider />
    <el-form
      :label-position="labelPosition"
      label-width="100px"
      :model="addFormValue"
      style="max-width: 460px"
      class="addForm"
      ref="addForm"
    >
      <section class="form-main--input">
        <el-form-item
          v-for="(inputItem, index) in addFormConfig.formItemList"
          v-show="inputItem.more"
          :key="index"
          :class="inputItem.type"
          :label="inputItem.label"
          :prop="inputItem.prop"
          :required="inputItem.required"
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
    <div style="display: flex; flex-direction: row; margin-top: 30px">
      <div style="min-width: 75%"></div>
      <el-button type="default" @click="modelValue = false">取消</el-button>
      <el-button type="primary" @click="submit">确定</el-button>
    </div>
  </Dialog>
</template>

<script setup>
import {PageLayout, Dialog, Table} from "@/components";
import { Search, Plus } from '@element-plus/icons-vue'
import axios from 'axios'
import {reactive, ref} from "vue";
const stepNumber = ref(0);

// 下一步的按钮方法
function next() {
  if (stepNumber.value === 2) {
    form2.value.validate((valid, fields) => {
      if (valid) {
        axios
          .post('')
          .then(response => {})
          .catch(error => {
            console.log(error)})
      } else {
        console.log("false");
        return false;
      }
    })
  }

  if (stepNumber.value === 1) {
    form.value.validate((valid, fields) => {
      if (valid) {
        formValue.authorityName = formValue.menuName;
        stepNumber.value++;
      } else {
        console.log("false");
        return false;
      }
    })
  }
  if (stepNumber.value === 0) {
    if (formValue.menuGroupName !== ""){
      stepNumber.value++;
    }else {
      window.alert("请选择菜单组")
    }
  }

}
// 上一步的按钮方法
function back() {
  if (stepNumber.value > 0) {
    stepNumber.value--;
  }
}
const form = ref()
const form2 = ref()

// 表单
// 表单标题
const formHeader = ref("")
// 第二步的输入列表
const step2InputList = reactive([
  {
    type: "text",
    label: "菜单名称",
    prop: "menuName",
    required: true,
    placeholder: "必填，请填写菜单名称",
  },
  {
    type: "text",
    label: "菜单地址",
    prop: "menuAddress",
    required: true,
    placeholder: "必填，请填写菜单地址",
  },
  {
    type: "text",
    label: "序列",
    prop: "ordering",
    required: true,
    placeholder: "必填，请填写序列",
  },
  {
    type: "select",
    label: "菜单显示",
    prop: "showMenu",
    required: true,
    placeholder: "必填，请选择菜单显示",
    optList: [
      {
        label: "必填，请选择菜单显示",
        value: "0",
      },
      {
        label: "显示菜单",
        value: "1",
      },
      {
        label: "不显示菜单",
        value: "2",
      },
    ]
  },
  {
    type: "textarea",
    label: "描述",
    prop: "description",
    required: false,
    placeholder: "选填，请填写描述",
  },
])
// 第三步的输入列表
const step3InputList = reactive([
  {
    type: "text",
    label: "权限名称",
    prop: "authorityName",
    placeholder: "",
    disabled: true
  },
  {
    type: "text",
    label: "资源路径",
    prop: "resourcePath",
    required: true,
    placeholder: "必填，请填写资源路径",

  },
  {
    type: "select",
    label: "商户类型",
    prop: "merchantType",
    required: true,
    placeholder: "必填，请填写商户类型",
  },
  {
    type: "text",
    label: "描述",
    prop: "description",
    placeholder: "",
    disabled: true
  },
])
// 表单的值
const formValue = reactive({
  menuGroupId: "",
  menuGroupName: "",
  icon: "",
  tab: "",
  groupOrdering: "",
  groupDescription: "",
  menuName: "",
  menuAddress: "",
  menuOrdering: "",
  showMenu: "",
  menuDescription: "",
  authorityName: "",
  merchantType: "",
  resourcePath: "",
})

// 选择菜单组
const selectGroup = ref(false)
const selectGroupTitle = ref("选择菜单组")
const selectGroupTableData = reactive([
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
  {
    menuGroupId: '1',
    menuGroupName: '2',
    menuGroupType: '3',
    merchant: '4',
    icon: '5',
    tab: '6',
    ordering: '7',
    description: '8',
  },
])
const selectGroupTableLabel = reactive([
  {
    prop: 'menuGroupId',
    label: '组id',
  },
  {
    prop: 'menuGroupName',
    label: '组名称',
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
    prop: 'merchant',
    label: '归属商户',
  },
  {
    prop: 'ordering',
    label: '序列',
  },
  {
    prop: 'description',
    label: '描述',
  },
  {
    prop: 'operation',
    label: '操作',
    btn: [
      {
        name: '选择',
        type: 'primary',
        func: (data) => {
          formValue.menuGroupName = data.menuGroupName
          formValue.icon = data.icon
          formValue.tab = data.tab
          formValue.menuOrdering = data.ordering
          formValue.groupDescription = data.description

          selectGroup.value = false
        }
      },
    ]
  }
])
function selectMenuGroup() {
  selectGroup.value = true
  console.log('查询菜单组')
}



// 添加菜单组
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
      placeholder: '必填，请填写组名称',
      required: true
    },
    {
      more: true,
      type: 'text',
      label: '图标',
      prop: 'icon',
      placeholder: '必填，请填写图标',
      required: true
    },
    {
      more: true,
      type: 'select',
      label: '标签',
      prop: 'tab',
      placeholder: '选填，请选择标签',
      required: false
    },
    {
      more: true,
      type: 'text',
      label: '序列',
      prop: 'ordering',
      placeholder: '必填，请填写序列',
      required: true
    },
    {
      more: true,
      type: 'select',
      label: '组类型',
      prop: 'menuGroupType',
      placeholder: '选填，请选择组类型',
      required: false
    },
    {
      more: true,
      type: 'select',
      label: '归属商户',
      prop: 'merchant',
      placeholder: '请选择商户类型',
      required: false
    },
    {
      more: true,
      type: 'textarea',
      label: '描述',
      prop: 'description',
      placeholder: '选填，请填写描述',
      required: false
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

const childDialog = ref()


function addMenuGroup() {
  modelValue.value = true;
}

const addForm = ref()
function submit() {
  addForm.value.validate((isPass) => {
    if (isPass) {
      console.log("保存数据到后端")
    }else {
      return false
    }
  })
}

</script>

<style scoped>
.menu-config-step {
  margin-top: 30px;
  margin-bottom: 30px;
}
/deep/ .menu-config-step .el-step__line {
  height: 5px;
  background-color: rgb(211, 211, 211);
}
/deep/ .menu-config-step .el-step__line-inner {
  border-width: 3px !important;
}

/deep/ .card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

/deep/ .el-form-item__label {
  min-width:15%;
}

.el-select {
  width: 100%
}


/deep/ .w-80 {
  max-width: 800px;
  width: 100%;
}

.el-form /deep/ {
  margin: 0 60px;
}

/deep/ .addForm .el-select {
  width: 100%;
}
.addForm {
  max-width: 100% !important;
}

/deep/ .el-dialog {
  margin-top: 20px;
}

/deep/ .justify-end {
  display: none;
}
</style>

