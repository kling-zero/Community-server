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
                    <div>注意：此功能使用前请先到保修设置</div>
                    <div>一般业主房屋报修 我们必须要添加一个非公共区域的类型才能正常报修</div>
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
    title: '工单池',
    // headerBtn: [
    //     {
    //         name: '登记',
    //         type: 'primary',
    //         func: () => {
    //             console.log(11)
    //         }
    //     }
    // ]
})
const tableLabel = reactive([
    {
        label: "报修ID",
        prop: "repairID",
    },
    {
        label: "位置",
        prop: "location",
    },
    {
        label: "报修类型",
        prop: "className",
    },
    {
        label: "报修人",
        prop: "reporter",
    },
    {
        label: "联系方式",
        prop: "reporterTel",
    },
    {
        label: "预约时间",
        prop: "appointmentTime",
    },
    {
        label: "状态",
        prop: "processState",
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
                name: "派单",
                type: "default",
                func: ({ ID }) => { },
            },
            {
                name: "详情",
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
        className: '马桶维修',//类型名称，报修类型
        classID: '102022102131432063',//派单类型
        class: '维修单',//报修设置类型
        dispatchMethod: '抢单',//派单方式
        publicArea: '是',//公共区域
        returnVisit: '没有回访',//是否回访
        createTime: '2022-10-21 16:03:41',//创建时间
        repairID: '822022101969361903',//报修id
        location: '114514栋250单元101室',//位置
        reporter: '赛文奥特曼',//报修人
        reporterTel: '13412341234',//报修人联系方式
        appointmentTime: '2022-10-19 11:38:31',//预约时间
        processState: '办理完成',//状态
    },

])

// 表单数据
// 表单标题
const more = ref(false)
const moreBtnName = ref('更多')

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
            type: 'select',
            label: '',
            prop: 'className',
            placeholder: '请选择报修类型',
            optList: [
                {
                    label: '马桶维修',
                    value: '马桶维修'
                },
                {
                    label: '门窗维修',
                    value: '门窗维修'
                },
                {
                    label: '疏通下水',
                    value: '疏通下水'
                }
            ]
        },
        {
            more: true,
            type: 'text',
            label: '',
            prop: 'reporter',
            placeholder: '请输入报修人',
        },

        {
            more: true,
            type: 'select',
            label: '',
            prop: '类型',
            placeholder: '请选择报修状态',
            optList: [
                {
                    label: '未派单',
                    value: '未派单'
                },
                {
                    label: '接单',
                    value: '接单'
                },
                {
                    label: '退单',
                    value: '退单'
                },
                {
                    label: '转单',
                    value: '转单 '
                },
                {
                    label: '申请支付',
                    value: '申请支付'
                },
                {
                    label: '支付失败',
                    value: '支付失败'
                },
                {
                    label: '待评价',
                    value: '待评价'
                },
                {
                    label: '电话回访',
                    value: '电话回访'
                },
                {
                    label: '办理完成',
                    value: '办理完成'
                },
                {
                    label: '未办理结单',
                    value: '未办理结单'
                },
                {
                    label: '暂停',
                    value: '暂停'
                },
            ]
        },
        {
            more: more,
            type: 'select',
            label: '',
            prop: 'class',
            placeholder: '请选择报修设置类型',
            optList: [
                {
                    label: '保洁单',
                    value: '保洁单'
                },
                {
                    label: '维修单',
                    value: '维修单'
                },

            ]
        },
        {
            more: more,
            type: 'text',
            label: '',
            prop: 'repairID',
            placeholder: '请输入报修id',
        },
        {
            more: more,
            type: 'text',
            label: '',
            prop: 'reporterTel',
            placeholder: '请输入报修人电话',
        },
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