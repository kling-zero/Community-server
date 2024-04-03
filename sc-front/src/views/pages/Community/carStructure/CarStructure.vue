<template>
  <PageLayout>
    <template #aside>
      <ZOTree class="aside-container" :value="value" :option="option" />
    </template>
    <template #default>
      <div class="cards-container">
        <el-card v-for="(item, index) in tableData" :key="index" class="card-item">
          <ul>
            <li>
              {{ item[ItemModel.num] }}
            </li>
            <li>
              {{ item[ItemModel.carNum] }}
            </li>
            <li>
              {{ item[ItemModel.unitNum] }}-{{ item[ItemModel.floorNum] }}-{{
                item[ItemModel.roomNum]
              }}
            </li>
            <li>
              {{ item[ItemModel.ownerName] }}
            </li>
            <li>欠费
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
import { listCarStructure } from '@/apis/Community/carStructure'
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
  carNum: 'carNum',
  floorNum: 'floorNum',
  idCard: 'idCard',
  link: 'link',
  memberId: 'memberId',
  num: 'num',
  oweAmount: 'oweAmount',
  ownerName: 'ownerName',
  page: 'page',
  records: 'records',
  roomNum: 'roomNum',
  row: 'row',
  state: 'state',
  statusCd: 'statusCd',
  total: 'total',
  unitId: 'unitId',
  unitNum: 'unitNum',
  withOwner: 'withOwner'
}

const tableData = reactive([
  {
    areaNum: '11',
    carNum: '10',
    floorNum: '1',
    idCard: '',
    link: '16602905643',
    memberId: '772022100993004972',
    num: '11',
    oweAmount: '333.00',
    ownerId: '772022100993004972',
    ownerName: 'lisi',
    page: -1,
    records: 0,
    roomNum: '109',
    row: 0,
    state: '2001',
    statusCd: '0',
    total: 0,
    unitId: '742022100905171031',
    unitNum: '1',
    withOwner: false
  },
  {
    areaNum: '03-912',
    carNum: '123',
    floorNum: '1',
    idCard: '',
    link: '16602905643',
    memberId: '772022100993004972',
    num: '7',
    oweAmount: '0.00',
    ownerId: '772022100993004972',
    ownerName: 'lisi',
    page: -1,
    records: 0,
    roomNum: '109',
    row: 0,
    state: '2001',
    statusCd: '0',
    total: 0,
    unitId: '742022100905171031',
    unitNum: '1',
    withOwner: false
  },
  {
    areaNum: '1001',
    carNum: '12352',
    floorNum: '1',
    idCard: '',
    link: '18985136859',
    memberId: '772022101005705404',
    num: '11',
    oweAmount: '111.00',
    ownerId: '772022101005705404',
    ownerName: 'he71',
    page: -1,
    records: 0,
    roomNum: '6666666',
    row: 0,
    state: '2001',
    statusCd: '0',
    total: 0,
    unitId: '742022100905171031',
    unitNum: '1',
    withOwner: false
  },
])
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