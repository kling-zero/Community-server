<template>
    <PageLayout>
        <template #header>
            <!-- 表单 -->
            <Form :formHeader="formHeader" :formInline="true" :formConfig="formConfig" :formValue="formValue" />
        </template>
        <template #default>
            <Table :header="header" :tableLabel="tableLabels" :tableData="tableData" />
        </template>
    </PageLayout>
    <!-- 添加弹窗 -->
    <el-dialog v-model="dialogTableVisible" title="添加常用菜单">
        <el-form :model="form" label-width="120px" inline="true">
            <el-form-item label="菜单" :label-width="formLabelWidth">
                <el-select v-model="addFormData.mid" placeholder="请选择菜单">
                    <el-option v-for="mData in menuData" :key="mData.mid" :label=menuData.name :value=menuData.mid />
                </el-select>
            </el-form-item>
            <el-form-item label="图标" :label-width="formLabelWidth">
                <el-radio-group v-model="addFormData.icon" class="ml-4">
                    <el-radio label="1">Option 1</el-radio>
                    <el-radio label="2">Option 2</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="列顺序" :label-width="formLabelWidth">
                <el-input v-model="addFormData.seq" autocomplete="off" />
            </el-form-item>

        </el-form>

        <template #footer>
            <span class="dialog-footer">
                <el-button @click="dialogTableVisible = false">关闭</el-button>
                <el-button type="primary" @click="confirm"> 保存 </el-button>
            </span>
        </template>
    </el-dialog>
    <!-- 删除弹窗 -->
    <el-dialog v-model="dialogVisible" title="删除菜单" width="30%" :before-close="handleClose">
        <span>确认删除常用菜单吗？</span>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click="dialogVisible = false">
                    确认
                </el-button>
            </span>
        </template>
    </el-dialog>
</template>
  
<script setup>
import { Table, PageLayout } from '@/components'
import { reactive, ref } from 'vue'
import { delMenuUser, addMenuUser, menuList } from '@/apis/MenuUserManage'

const itemModel = {
    icon: 'icon',
    muId: 'muId',
    name: 'name',
    seq: 'seq',
    staffId: 'staffId',
    statusCd: 'statusCd',
    url: 'url',
}
const dialogTableVisible = ref(false);
const dialogVisible = ref(false);

//查询相关
const formHeader = reactive({
    title: "查询条件",
});
const formValue = reactive({
    muId: '',
    name: '',
    seq: ''
});

const formConfig = reactive({
    formWidth: "",
    formItemList: [
        {
            more: true,
            type: "text",
            label: "",
            prop: "muId",
            placeholder: "请输入编号",
        },
        {
            more: true,
            type: "text",
            label: "",
            prop: "name",
            placeholder: "请输入菜单",
        },
        {
            more: true,
            type: "text",
            label: "",
            prop: "seq",
            placeholder: "请输入列顺序",
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
        {
            name: "重置",
            type: "primary",
            func: (v) => {
                console.log(v);
            },
        },
    ],
});

//表格相关
const header = {
    title: '常用菜单',
    headerBtn: [
        {
            name: "添加",
            type: "primary",
            func: () => {
                dialogTableVisible.value = true;
            },
        },
    ],
}
const tableLabels = [
    { label: '编号', prop: itemModel.muId },
    { label: '菜单', prop: itemModel.name },
    { label: '图标', prop: itemModel.icon },
    { label: '顺序', prop: itemModel.seq },
    {
        label: '操作',
        prop: 'operation',
        btn: [
            {
                name: '删除',
                type: 'danger',
                func: (item) => {
                    console.log(item)
                    dialogVisible.value = true
                }
            }
        ]
    }
]

const tableData = [
    {

        icon: '',
        muId: '102022102996301151',
        name: '业主成员',
        seq: '1',
        staffId: '',
        statusCd: '',
        url: '',
    }
]
const confirm = () => {
    console.log("保存数据");
}

const addFormData = reactive({
    staffId: '',
    icon: "",
    seq: "",
    url: ""
})

const menuData = reactive({
    mid: "",
    name: '',
})
</script>
<style>
.el-dialog {
    width: 700px;
}

.el-input {
    width: 300px;
}

.el-form-item {
    margin: 15px 0;
}
</style>