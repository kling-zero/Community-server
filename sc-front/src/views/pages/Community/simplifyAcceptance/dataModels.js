export const itemModel = {
  ['房屋费用']: {
    additionalAmount: 'additionalAmount', //附加费用
    amount: 'amount',                        //金额
    amountOwed: 'amountOwed',                  //应收金额
    batchId: 'batchId',          //批次id
    communityId: 'communityId',        //小区id
    computingFormula: 'computingFormula',            //计算公式  面积*单价+附加费
    configId: 'configId',         //费用id    
    deadlineTime: 'deadlineTime',       //计费结束日期
    endTime: 'endTime',             //计费起始时间
    feeFlag: 'feeFlag',                     //费用标识
    feeFlagName: 'feeFlagName',               //费用标识名称
    feeId: 'feeId',            //费用id
    feeName: 'feeName',                         //费用项名称
    feePrice: 'feePrice',                   //订单单价
    feeTotalPrice: 'feeTotalPrice',            //订单总价格
    feeTypeCd: 'feeTypeCd',          //费用类型
    feeTypeCdName: 'feeTypeCdName',            //费用类型名称
    incomeObjId: 'incomeObjId',//收款方id
    isDefault: 'isDefault',                 //默认费用，只能修改，不能做删除
    offlinePayFeeSwitch: 'offlinePayFeeSwitch',       //离线缴费开关
    payerObjId: 'payerObjId',   //付费对象id
    payerObjName: 'payerObjName', //付费对象名称
    payerObjType: 'payerObjType',       //付费对象类型 3333房屋 6666车位
    paymentCd: 'paymentCd',          //付费类型
    paymentCycle: 'paymentCycle',         //缴费周期
    receivedAmountSwitch: 'receivedAmountSwitch', //实收金额开关
    squarePrice: 'squarePrice',   //单价
    startTime: 'startTime',       //建账时间
    state: 'state',                       //状态 1001待支付   2002支付完成 3003 支付失败 4004已退
    stateName: 'stateName', //状态文字描述
    userId: 'userId',//
    val: 'val'
  },
  ['停车费用']: [],
  ['业主合同']: [],
  ['家庭成员']: [],
  ['车辆信息']: [],
  ['报修单']: [],
  ['投诉单']: [],
  ['门禁同步']: [],
  ['道闸同步']: [],
  ['补打收据']: [],
  ['绑定记录']: [],
  ['抄表记录']: []
}


export const tableOperations = {
  ['房屋费用']: {
    formItemList: [
      {
        more: true,
        type: 'select',
        prop: '',
        placeholder: '选择费用类型',
        optList: [
            {label:'物业费', value:1},
            {label:'押金', value:2},
            {label:'煤气费', value:3},
            {label:'取暖费', value:4},
            {label:'维修费', value:5},
            {label:'服务费', value:6},
            {label:'其他', value:7},
            {label:'临时车费用', value:8},
            {label:'水费', value:9},
            {label:'电费', value:10},
            {label:'公摊费', value:11},
            {label:'系统费用', value:12},
            {label:'租金', value:13},
        ]
      },
      {
          more: true,
          type: 'select',
          prop: '',
          placeholder: '请选择收费项目',
          optList: [

          ]
      },
      {
        more: true,
        type: 'select',
        prop: '',
        placeholder: '请选择状态',
        optList: [
          {
            label: '收费中',
            value: 1,
          },
          {
            label: '收费结束',
            value: 2,
          },
        ]
      },
      {
        more: true,
        type: 'select',
        prop: '',
        placeholder: '',
        optList: [
          {
            label: '当前房间',
            value: 1,
          },
          {
            label: '当前业主',
            value: 2,
          },
        ]
      },

    ],
    operate: [
        {
            name: '批量缴费',
            func: () => {

            }
        },
        {
          name: '临时收费',
          func: () => {

          }
        },
        {
          name: '代收费用',
          func: () => {

          }
        },
        {
          name: '水电抄表',
          func: () => {

          }
        },
        {
          name: '费用套餐',
          func: () => {

          }
        },
        {
          name: '创建费用',
          func: () => {

          }
        },
        {
          name: '欠费缴费',
          func: () => {

          }
        },
]
  },
  ['停车费用']: {
    formItemList:[

    ],
    operate: [

    ],
  },
  ['业主合同']: [],
  ['家庭成员']: [],
  ['车辆信息']: [],
  ['报修单']: [],
  ['投诉单']: [],
  ['门禁同步']: null,
  ['道闸同步']: [],
  ['补打收据']: [],
  ['绑定记录']: null,
  ['抄表记录']: []
}