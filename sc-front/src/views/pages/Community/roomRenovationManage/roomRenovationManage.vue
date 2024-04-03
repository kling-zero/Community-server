<template>
    <PageLayout>
        <template #header>
            <Form :form-config="formConfig" :form-header="formHeader" :formValue="{}" />
        </template>
        <template #default>
            <Table :header="TableHeader" :tableLabel="tableLabels" :table-data="[]" />    
        </template>
    </PageLayout>
</template>

<script setup>
import { Table, Form } from '@/components'

const formHeader = {
    title: '查询条件',
    headerBtn: [
        {
            name: '更多',
            type: 'default',
            func: (...args) => {
                console.log(args)
            }
        }
    ]
}
const formConfig = {
    formItemList: [
        {
            more: 1,
            prop: 'roomNode',
            type: 'text',
            placeholder: '请填写房屋编号 格式 楼栋-单元-房屋',
        },
        {
            more: 1,
            prop: 'username',
            type: 'text',
            placeholder: '请输入联系人',
        },
        {
            more: 1,
            prop: 'phone',
            type: 'text',
            placeholder: '请输入联系电话',
        }
    ],
    operate: [
    {
            name: '查询',
            type: 'primary',
            func: (...args) => {
                console.log(args)
            }
        },
        {
            name: '重置',
            type: 'default',
            func: (...args) => {
                console.log(args)
            }
        },
    ]
}
const TableHeader = {
    title: '装修信息',
    headerBtn: [
        {
            name: '添加',
            type: 'primary',
            func: (...args) => {
                console.log(args)
            }
        }
    ]
}
const tableLabels = [
    {
        label: '房屋',
        prop: 'city',
    },
    {
        label: '联系人',
        prop: 'communityName',
    },
    {
        label: '联系电话',
        prop: 'telephone',
    },
    {
        label: '装修时间',
        prop: 'area',
    },
    {
        label: '申请时间',
        prop: 'beginDate',
    },
    {
        label: '装修单位',
        prop: 'type',
    },
    {
        label: '装修负责人',
        prop: 'type',
    },
    {
        label: '负责人',
        prop: 'type',
    },
    {
        label: '状态',
        prop: 'type',
    },
    {
        label: '是否延期',
        prop: 'idOutOfDeadline',
    },
    {
        label: '延期时间',
        prop: 'outOfDeadline',
    },
    {
        label: '是否违规',
        prop: 'outOfDeadline',
    },
    {
        label: '违规说明',
        prop: 'outOfDeadline',
    },
    {
        label: '备注',
        prop: 'text',
    },
    {
        label: '操作',
        prop: 'operation',
        btn: [
            {
                name: '装修验收',
                type: 'default',
                func: (...args) => console.log(args)
            },
            {
                name: '修改',
                type: 'default',
                func: (...args) => console.log(args)
            },
            {
                name: '删除',
                type: 'default',
                func: (...args) => console.log(args)
            },
            {
                name: '跟踪记录',
                type: 'default',
                func: (...args) => console.log(args)
            },
        ]
    }
]
</script>
