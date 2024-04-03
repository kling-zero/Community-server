<template>
    <!-- <ZOTable />     -->
</template>

<script setup>
import { reactive } from 'vue';
// import { ZOTable } from '../../../../components'

const header = reactive({
    title: '商户审核',
})
const tableLabel = reactive([
    {
        label: '小区ID',
        prop: 'ID',
    },
    {
        label: '小区名称',
        prop: 'communityName',
    },
    {
        label: '商户名称',
        prop: 'businessName',
    },
    {
        label: '商户类型',
        prop: 'businessType',
    },
    {
        label: '联系电话',
        prop: 'phone',
    },
    {
        label: '商户地址',
        prop: 'address',
    },
    {
        label: '状态',
        prop: 'manageType',
    },
    {
        label: '操作',
        prop: 'operation',
        btn: [
            {
                
            }
        ]
    }
])
</script>
