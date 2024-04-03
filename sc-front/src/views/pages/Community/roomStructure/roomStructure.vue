<template>
  <PageLayout>
    <template #aside>
      <ZOTree class="aside-container" :value="value" :option="option" @change="selectChange" />
    </template>
    <template #default>
      <div class="cards-container">
        <el-card
          v-for="(item, index) in tableData"
          :key="index"
          class="card-item"
        >
          <ul>

            <li>
              {{ item[ItemModel.unitNum] }}-{{ item[ItemModel.floorNum] }}-{{
                item[ItemModel.roomNum]
              }}
            </li>
            <li>
              {{item.stateName}}
            </li>
            <li>
              {{ item[ItemModel.ownerName] }}
            </li>
            <li>
              欠费
              {{ item[ItemModel.oweAmount] }}
            </li>
          </ul>
        </el-card>
      </div>
    </template>
  </PageLayout>
</template>

<script setup>
// import { reactive } from 'vue'
import { ZOTree, PageLayout } from '@/components'
import { reactive } from 'vue'
import { listRoomStructure } from '@/apis/Community/carStructure'
import { ElMessage } from 'element-plus';
const value = [
  {
    id: 'dioiwen23',
    label: '一栋',
    children: [
      {
        id: 'in23r8vdin23',
        label: '一单元'
      }
    ]
  },
  {
    id: 'dioiwn23',
    label: '二栋',
    children: [
      {
        id: 'in23r8vd23',
        label: '一单元'
      }
    ]
  }
]
const option = {
  parent: '/floor.png',
  child: '/unit.png'
}

const ItemModel = {
  apartment: 'apartment',
  builtUpArea: 'builtUpArea',
  communityId: 'communityId',
  createTime: 'createTime',
  feeCoefficient: 'feeCoefficient',
  floorId: 'floorId',
  floorNum: 'floorNum',
  idCard: 'idCard',
  layer: 'layer',
  link: 'link',
  oweAmount: 'oweAmount',
  ownerId: 'ownerId',
  ownerName: 'ownerName',

  remark: 'remark',
  roomArea: 'roomArea',
  roomId: 'roomId',
  roomNum: 'roomNum',
  roomRent: 'roomRent',
  roomSubType: 'roomSubType',
  roomType: 'roomType',
  section: 'section',
  state: 'state',
  status_cd: "status_cd",
  total: 'total',
  unitId: 'unitId',
  unitNum: 'unitNum'
}

const tableData = reactive([
  {
    apartment: '20101',
    builtUpArea: '200.00',
    communityId: '2022090665021542',
    createTime: '2022-10-28 09:26:43',
    feeCoefficient: '1.00',
    floorId: '732022102687720005',
    floorNum: '1',
    idCard: '110',
    layer: '1',
    link: '110',
    oweAmount: '0.00',
    ownerId: '772022102811220722',
    ownerName: '小段',
    page: -1,
    records: 0,
    roomArea: '192.50',
    roomId: '752022102842210172',
    roomNum: '1',
    roomRent: '0.00',
    roomSubType: '110',
    roomType: '1010301',
    row: 0,
    section: '2',
    state: '2005',
    stateName: '已装修',
    statusCd: '0',
    total: 0,
    unitId: '742022102702820062',
    unitNum: '0'
  }
])

function getList (communityId,unitId) {
  listRoomStructure({
    communityId,
    unitId
  }).then((result) => {
    tableData.splice(0, tableData.length, ...result.data.rows)
  }).catch((err) => {
    ElMessage({
      message: '数据获取失败',
      type: 'warning'
    })
  });
}
getList(2022090665021542)

function selectChange (item){
  getList()
}
</script>


<style>
.cards-container{
  display: flex;
  flex-wrap: wrap;
}
.card-item{
  width: 150px;
  margin: 0 10px 10px 0;
}
.card-item li{
  text-align: center;
}
</style>