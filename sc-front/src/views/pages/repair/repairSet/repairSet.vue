<template>
    <PageLayout>
        <template #header>
            <!-- 表单 -->
            <Form :formHeader="formHeader" :formInline="true" :formConfig="formConfig" :formValue="formValue" />
        </template>
        <template #default>
            <!-- 表格 -->
            <Table class="box-card" :header="header" :tableLabel="tableLabel" :tableData="tableData">
                <template #remarks>
                    <div>派单方式：</div>
                    <div>1、抢单 是员工（报修类型下的师傅）自主抢单维修处理，比较实用于物业每单给维修是否提成的场景</div>
                    <div>2、指派专门由客服派单员工（报修类型下的师傅）维修处理，一般物业的选择</div>
                    <div>3、轮训由系统定时派单员工（报修类型下的师傅）维修处理 公共区域</div>
                    <div>公共区域：</div>
                    <div>小区、楼栋、单元 为公共区域 房屋为非公共区域</div>
                    <div>注意：一般业主房屋报修我们必须要添加一个非公共区域的类型才能正常报修</div> 
                </template>
            </Table>
        </template>
    </PageLayout>
</template>

<script setup>
import { PageLayout } from '@/components'
import { reactive, ref } from 'vue'
// 表格数据
const header = reactive({
    title: '报修设置',
    headerBtn: [
        {
            name: '添加',
            type: 'primary',
            func: () => {
                console.log(11)
            }
        }
    ]
})
const tableLabel = reactive([
    {
        label: "类型名称",
        prop: "className",
    },
    {
        label: "报修设置类型",
        prop: "class",
    },
    {
        label: "派单方式",
        prop: "dispatchMethod",
    },
    {
        label: "派单类型",
        prop: "classID",
    },
    {
        label: "公共区域",
        prop: "publicArea",
    },
    {
        label: "是否回访",
        prop: "returnVisit",
    },
    {
        label: "创建时间",
        prop: "createTime",
    },
    {
        label: '操作',
        prop: 'operation',
        btn: [
            {
                name: "修改",
                type: "default",
                func: ({ ID }) => { },
            },
            {
                name: "绑定维修师傅",
                type: "default",
                func: ({ ID }) => { },
            },
            {
                name: "删除",
                type: "default",
                func: ({ ID }) => { },
            },
        ]
    }
])
const tableData = reactive([
    {
        className: '马桶维修',
        classID: '102022102131432063',
        class: '维修单',
        dispatchMethod: '抢单',
        publicArea: '是',
        returnVisit: '没有回访',
        createTime: '2022-10-21 16:03:41'
    },

])

// 表单数据
// 表单标题
const more = ref(false)
const moreBtnName = ref('')

const formHeader = reactive({
    title: '查询条件',
    headerBtn: [
        {
            link: true,
            name: moreBtnName,
            type: 'primary',
            func: () => {
                more.value = !more.value
                if (more.value) {
                    moreBtnName.value = '隐藏'
                } else {
                    moreBtnName.value = '更多'
                }
            }
        }
    ]
})
// 表单结构
const formConfig = reactive({
    formWidth: '',
    formItemList: [
        {
            more: true,
            type: 'text',
            label: '',
            prop: 'className',
            placeholder: '请输入类型名称'
        },
        {
            more: true,
            type: 'select',
            label: '',
            prop: 'dispatchMethod',
            placeholder: '请选择派单方式',
            optList: [
                {
                    label: "抢单",
                    value: "抢单",
                },
                {
                    label: "指派",
                    value: "指派",
                },
                {
                    label: "轮训",
                    value: "轮训",
                },
            ]
        },

        {
            more: true,
            type: 'text',
            label: '',
            prop: 'className',
            placeholder: '请输入派单类型'
        },
        {
            more: more,
            type: 'select',
            label: '',
            prop: '类型',
            placeholder: '请选择车位状态',
            optList: [
                {
                    label: '出售',
                    value: '地上停车场'
                },
                {
                    label: '出租',
                    value: '地下停车场'
                },
                {
                    label: '空闲',
                    value: '地下停车场'
                }
            ]
        },
        {
            more: more,
            type: 'text',
            label: '',
            prop: 'ID2',
            placeholder: '请输入车位编号'
        }
    ],
    operate: [
        {
            name: '查询',
            type: 'primary',
            func: (v) => {
                console.log(v)
            }
        },
        {
            name: '重置',
            type: 'primary',
            func: (v) => {
                console.log(v)
            }
        },
        {
            name: '重置',
            type: 'primary',
            func: (v) => {
                console.log(v)
            }
        }
    ]
})
// 初始值
const formValue = reactive({
    编号: '',
    类型: '',
    ID: ''
})
</script>

<style scoped>

</style>