<template>
    <PageLayout>
        <template #default>
            <Form :form-config="formConfig" :formValue="{}" />
            <el-card>
                <div class="detail-inner-container">
                    <img class="detail-item-img" :src="detailsInformaion.avatar" />
                    <div class="detail-text-items">
                        <div class="detail-item">
                            <span>业主编号</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>业主名称</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>练习电话</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>身份证</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>入住日期</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>性别</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>业主备注</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>商务编号</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>房屋面积</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>房屋类型</span>
                            <span></span>
                       </div>
                        <div class="detail-item">
                            <span>户型</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>房屋状态</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>室内面积</span>
                            <span></span>
                        </div>
                        <div class="detail-item">
                            <span>房屋备注</span>
                            <span></span>
                        </div>
                        <div class="detail-item space-item"></div>
                        <div class="detail-item space-item"></div>
                        <div class="detail-item space-item"></div>
                        <div class="detail-item space-item"></div>
                        <div class="detail-item space-item"></div>
                        <div class="detail-item space-item"></div>
                    </div>
                </div>
            </el-card>
            <el-card>
                <el-radio-group v-model="tableType" size="large">
                    <el-radio-button label="房屋费用" />
                    <el-radio-button label="停车费用" />
                    <el-radio-button label="业主合同" />
                    <el-radio-button label="家庭成员" />
                    <el-radio-button label="车辆信息" />
                    <el-radio-button label="报修单" />
                    <el-radio-button label="投诉单" />
                    <el-radio-button label="门禁同步" />
                    <el-radio-button label="道闸同步" />
                    <el-radio-button label="补打收据" />
                    <el-radio-button label="绑定记录" />
                    <el-radio-button label="抄表记录" />
                </el-radio-group>
            </el-card>
            <Form v-if="tableOperations[tableType]" :form-config="tableOperations[tableType]" :form-value="{}" />
            <Table :table-label="tableLabel[tableType]" :table-data="tableData[tableType]" />
        </template>
    </PageLayout>
</template>

<script setup>
import { Table, PageLayout, Form } from '@/components'
import { reactive, ref } from 'vue';
import { itemModel, tableOperations } from './dataModels'

const formConfig = {
    formItemList: [
        {
            more: true,
            type: 'select',
            prop: '',
            placeholder: '选择筛选条件',
            optList: [
                {label:'房间号', value:1},
                {label:'业主姓名', value:2},
                {label:'业主电话', value:3},
                {label:'业主身份证', value:4},
                {label:'车牌号', value:5},
                {label:'成员姓名', value:6},
                {label:'成员手机号', value:7},
                {label:'成员身份证', value:8},
                {label:'商铺号', value:9},
                {label:'合同号', value:10},
            ]
        },
        {
            more: true,
            type: 'text',
            prop: '',
            placeholder: '请输入房屋编号 楼栋-单元-房屋 如1-1-1'
        }
    ],
    operate: [
        {
            name: '查询',
            func: () => {

            }
        },
        {
            name: '选择房屋',
            func: () => {

            }
        },
    ]
}

const detailsInformaion = reactive({
    avatar: '/noPhoto.jpg'
})

const tableType = ref('房屋费用')



const tableLabel = reactive({
    ['房屋费用']:[
        {
            label: '费用项目',
            prop: itemModel.房屋费用.feeName
        },
        {
            label: '费用标识',
            prop: itemModel.房屋费用.feeFlagName
        },
        {
            label: '费用类型',
            prop: itemModel.房屋费用.feeTypeCdName
        },
        {
            label: '应收金额',
            prop: itemModel.房屋费用.feeTotalPrice
        },
        {
            label: '建账时间',
            prop: itemModel.房屋费用.startTime
        },
        {
            label: '计费起始时间',
            prop: itemModel.房屋费用.endTime
        },
        {
            label: '计费结束时间',
            prop: itemModel.房屋费用.deadlineTime
        },
        {
            label: '说明',
            prop: itemModel.房屋费用.squarePrice
        },
        {
            label: '状态',
            prop: itemModel.房屋费用.stateName
        },
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['停车费用']:[
        { label: '费用项目',prop: ''},
        { label: '费用标识',prop: ''},
        { label: '费用类型',prop: ''},
        { label: '应收金额',prop: ''},
        { label: '建账时间',prop: ''},
        { label: '计费起始时间',prop: ''},
        { label: '计费结束时间',prop: ''},
        { label: '说明',prop: ''},
        { label: '状态',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['业主合同']:[
        { label: '合同名称',prop: ''},
        { label: '合同编号',prop: ''},
        { label: '父合同编号',prop: ''},
        { label: '合同类型',prop: ''},
        { label: '开始时间',prop: ''},
        { label: '结束时间',prop: ''},
        { label: '状态',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['家庭成员']:[
        { label: '成员ID',prop: ''},
        { label: '名称',prop: ''},
        { label: '性别',prop: ''},
        { label: '年龄',prop: ''},
        { label: '类型',prop: ''},
        { label: '身份证',prop: ''},
        { label: '联系方式',prop: ''},
        { label: '创建员工',prop: ''},
        { label: '备注',prop: ''},
        { label: '门禁钥匙',prop: ''},
        { label: 'QQ',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['车辆信息']:[
        { label: '车辆号',prop: ''},
        { label: '车辆品牌',prop: ''},
        { label: '车辆类型',prop: ''},
        { label: '颜色',prop: ''},
        { label: '业主',prop: ''},
        { label: '车位',prop: ''},
        { label: '起租时间',prop: ''},
        { label: '截止时间',prop: ''},
        { label: '状态',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['报修单']:[
        { label: '工单编码',prop: ''},
        { label: '位置',prop: ''},
        { label: '报修类型',prop: ''},
        { label: '报修人',prop: ''},
        { label: '联系方式',prop: ''},
        { label: '预约时间',prop: ''},
        { label: '状态',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['投诉单']:[
        { label: '投诉类型',prop: ''},
        { label: '房屋',prop: ''},
        { label: '投诉人',prop: ''},
        { label: '投诉人电话',prop: ''},
        { label: '投诉状态',prop: ''},
        { label: '处理人',prop: ''},
        { label: '处理电话',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },

    ],
    ['门禁同步']:[
        { label: '设备编码',prop: ''},
        { label: '设备名称',prop: ''},
        { label: '对象类型',prop: ''},
        { label: '对象名称',prop: ''},
        { label: '指令',prop: ''},
        { label: '状态',prop: ''},
        { label: '说明',prop: ''},
        { label: '同步时间',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },

    ],
    ['道闸同步']:[
        { label: '同步ID',prop: ''},
        { label: '设备编码',prop: ''},
        { label: '对象类型',prop: ''},
        { label: '对象名称',prop: ''},
        { label: '指令',prop: ''},
        { label: '状态',prop: ''},
        { label: '说明',prop: ''},
        { label: '同步时间',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },

    ],
    ['补打收据']:[
        { label: '费用类型',prop: ''},
        { label: '合同',prop: ''},
        { label: '业主',prop: ''},
        { label: '费用项目',prop: ''},
        { label: '总金额',prop: ''},
        { label: '缴费时间',prop: ''},
        { label: '收据ID',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['绑定记录']:[
        { label: '业主名称',prop: ''},
        { label: '业主电话',prop: ''},
        { label: '开始时间',prop: ''},
        { label: '结束时间',prop: ''},
        { label: '创建时间',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],
    ['抄表记录']:[        
        { label: '表类型',prop: ''},
        { label: '对象名称',prop: ''},
        { label: '上期度数',prop: ''},
        { label: '本期度数',prop: ''},
        { label: '上期读表时间',prop: ''},
        { label: '本期读表时间',prop: ''},
        { label: '创建时间',prop: ''},
        {
            label: '操作',
            prop: 'operation',
            btn: [
                {

                }
            ]
        },
    ],

})

const tableData = reactive({
    ['房屋费用']:[],
    ['停车费用']:[],
    ['业主合同']:[],
    ['家庭成员']:[],
    ['车辆信息']:[],
    ['报修单']:[],
    ['投诉单']:[],
    ['门禁同步']:[],
    ['道闸同步']:[],
    ['补打收据']:[],
    ['绑定记录']:[],
    ['抄表记录']:[],
})
</script>

<style>
.detail-inner-container{
    width: 100%;
    display: flex;
    flex-wrap: nowrap;
}
.detail-item-img{
    width: 120px;
    height: 160px;
    margin: 20px;
}
.detail-text-items{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    padding-top: 20px;
}
.detail-item{
    box-sizing: border-box;
    padding: 10px;
    min-width: 200px;
    display: flex;
    justify-content: space-between;
}
.space-item{
    height: 0;
    padding: 0;
}
</style>
