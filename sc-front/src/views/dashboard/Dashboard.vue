<template>
  <div class="p-4">
    <div>
      <el-row :gutter="0">
        <el-col :span="15" :offset="0">
          <el-space>
            <el-card shadow="hover">
              <div class="pb-8 text-2xl font-bold">小区信息</div>
              <div class="flex">
                <div class="flex px-10 py-3">
                  <el-avatar shape="square" size='large' :src="picture.build"/>
                  <div class="px-2">
                    <div class="text-3xl font-bold">{{ communityInfo.floorCount }}</div>
                    <div class="text-gray-400">楼宇</div>
                  </div>
                </div>
                <div class="flex px-10 py-3">
                  <el-avatar shape="square" size='large' :src="picture.house"/>
                  <div class="px-2">
                    <div class="text-3xl font-bold">{{ communityInfo.roomCount }}</div>
                    <div class="text-gray-400">房屋</div>
                  </div>
                </div>
                <div class="flex px-10 py-3">
                  <el-avatar shape="square" size='large' :src="picture.shop"/>
                  <div class="px-2">
                    <div class="text-3xl font-bold">{{ communityInfo.shopCount }}</div>
                    <div class="text-gray-400">商铺</div>
                  </div>
                </div>
                <div class="flex px-10 py-3">
                  <el-avatar shape="square" size='large' :src="picture.parking"/>
                  <div class="px-2">
                    <div class="text-3xl font-bold">{{ communityInfo.spaceCount }}</div>
                    <div class="text-gray-400">车位</div>
                  </div>
                </div>
              </div>

              <el-divider></el-divider>

              <el-row :gutter="20">
                <el-col :span="12" :offset="0">
                  <el-card shadow="hover">
                    <div class="flex justify-between">
                      <span class="text-2xl text-gray-400">住户登记</span>
                      <el-avatar shape="square" size='large' :src="picture.person"/>
                    </div>
                    <div class="justify-center">
                      <span class="text-3xl font-bold">{{ communityInfo.ownerCount }}</span>
                    </div>
                    <el-divider/>
                    <div class="flex text-sm text-gray-400">
                      查看登记住户详情>>
                    </div>
                  </el-card>
                </el-col>

                <el-col :span="12" :offset="0">
                  <el-card shadow="hover">
                    <div class="flex justify-between">
                      <span class="text-2xl text-gray-400">车辆登记</span>
                      <el-avatar shape="square" size='large' :src="picture.car"/>
                    </div>
                    <div class="justify-center">
                      <span class="text-3xl font-bold">{{ communityInfo.carCount }}</span>
                    </div>
                    <el-divider/>
                    <div class="flex text-sm text-gray-400">
                      查看车辆详情>>
                    </div>
                  </el-card>
                </el-col>
              </el-row>
            </el-card>
          </el-space>
        </el-col>

        <el-col :span="9" :offset="0">
          <el-card shadow="hover">
            <div class="text-2xl font-bold pb-5">小区公告</div>
            <div>
              <el-scrollbar height="345px">
                <div class="flex justify-between" v-for="communityBulletin in communityBulletins">
                  <span style="text-overflow: ellipsis;white-space: nowrap; overflow: hidden; width: 280px" >{{ communityBulletin.message }} </span>
                  <span class="text-gray-400" style="width: 160px">{{ communityBulletin.releaseDate }}</span>
                </div>
              </el-scrollbar>
            </div>

          </el-card>
        </el-col>
      </el-row>
    </div>


    <el-row :gutter="20" class="mt-5">
      <el-col :span="8" :offset="0">
        <IndexChart my-chart="chart1" :source="RepairInfo.source" :dimensions="RepairInfo.dimensions"
                    :title="RepairInfo.title"/>
      </el-col>

      <el-col :span="8" :offset="0">
        <IndexChart my-chart="chart2" :source="ComplaintInfo.source" :dimensions="ComplaintInfo.dimensions"
                    :title="ComplaintInfo.title"
        />
      </el-col>

      <el-col :span="8" :offset="0">
        <IndexChart my-chart="chart3" :source="RegisterInfo.source" :dimensions="RegisterInfo.dimensions"
                    :title="RegisterInfo.title"/>
      </el-col>
    </el-row>
  </div>

</template>
<script setup>
import {ref, onMounted, reactive} from 'vue'
import IndexChart from './ChartCard/IndexChart.vue'
import build from "./pict/building.png"
import house from "./pict/house.png"
import shop from "./pict/shop.png"
import car from "./pict/car.png"
import person from "./pict/person.png"
import parking from "./pict/parking.png"
import {getBulletin, getCommunityInfo, getRepairCount, getRegisterCount, getComplaintCount} from "@/apis/dashboard";
import {ElMessage} from "element-plus";

onMounted(async ()=>{
  //获取报修统计
  await getRepairInfo(param)
  //获取投诉统计
  await getComplaintInfo(param)
  //获取注册统计
  await getRegisterInfo(param)
})


let picture = {
  car: car,
  build: build,
  house: house,
  shop: shop,
  person: person,
  parking: parking,
}
//TODO！小区id获取途径未知
const param = reactive({
  communityId: '2022090665021542'
})


//绘制echarts图表，依次是保修统计、投诉统计、住户统计
const RepairInfo = reactive({
  title: "报修统计",
  dimensions: [
    '全部保修', '待派单', '已处理', '处理中'
  ],
  source: [
    ['全部保修', 30],
    ['待派单', 15],
    ['已处理', 5],
    ['处理中', 10]
  ]
})
//定义获取报修统计
async function getRepairInfo(data) {
  await getRepairCount(data).then(resp => {
    if (resp.code === 10000) {
      RepairInfo.source[0][1] = resp.data.total //全部保修总数
      RepairInfo.source[1][1] = resp.data.standby//待派单
      RepairInfo.source[2][1] = resp.data.handled
      RepairInfo.source[3][1] = resp.data.inProcess
    } else {
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}




//投诉统计

const ComplaintInfo = reactive({
  title: "投诉统计",
  dimensions: [
    '全部投诉', '处理中', '已处理'
  ],
  source: [
    ['全部投诉', 40],
    ['处理中', 19],
    ['已处理', 21]
  ]
})

//定义获取投诉统计
async function getComplaintInfo(data) {
  await getComplaintCount(data).then(resp => {
    if (resp.code === 10000) {
      ComplaintInfo.source[0][1] = resp.data.allComplaints//全部投诉
      ComplaintInfo.source[1][1] = resp.data.inProcess//处理中
      ComplaintInfo.source[2][1] = resp.data.processed//已处理
    } else {
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}



//住户注册统计
const RegisterInfo = reactive({
  title: "住户注册统计",
  dimensions: [
    '未注册', '已注册', '未绑定房屋', '已绑定房屋'
  ],
  source: [
    ['未注册', 80],
    ['已注册', 6],
    ['未绑定房屋', 9],
    ['已绑定房屋', 31]
  ]
})

//定义注册统计
function getRegisterInfo(data) {
  getRegisterCount(data).then(resp => {
    if (resp.code === 10000) {
      //成功
      RegisterInfo.source[0][1] = resp.data.unregistered//未注册
      RegisterInfo.source[1][1] = resp.data.registered//已注册
      RegisterInfo.source[2][1] = resp.data.unBound//未绑定房屋
      RegisterInfo.source[3][1] = resp.data.bound//未绑定房屋
    } else {
      //失败
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}



//小区公告对象
const communityBulletins = reactive([{
  message: '111111',  //公告内容
  releaseDate: '2023-01-01 23:00:05"' //公告发布时间
}])

//定义获取小区公告
function getCommunityBulletin(data) {
  getBulletin(data).then(resp => {
    if (resp.code === 10000) {
      communityBulletins.splice(0, communityBulletins.length, ...resp.data)
    } else {
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}

//获取公告
getCommunityBulletin(param)

//小区信息对象
const communityInfo = reactive({
  floorCount: 7, //楼宇数量
  roomCount: 58, //房屋数量
  shopCount: 13, //商铺数量
  spaceCount: 36,  //车位数量
  ownerCount: 81, //住户登记数量
  carCount: 63 //车辆数量
})

//定义查询小区信息
function communityInformation(data) {
  getCommunityInfo(data).then(resp => {
    if (resp.code === 10000) {
      communityInfo.floorCount = resp.data.buildingsNumber
      communityInfo.roomCount = resp.data.housesNumber
      communityInfo.shopCount = resp.data.shopsNumber
      communityInfo.spaceCount = resp.data.parkingSpacesNumber
      communityInfo.carCount = resp.data.vehiclesNumber
      communityInfo.ownerCount = resp.data.householdsNumber
    } else {
      ElMessage.error(resp.data.message)
    }
  }).catch(err => {
    console.log(err)
    ElMessage.error("请求数据失败，请稍后重试！")
  })
}

//查询小区信息
communityInformation(param)


</script>

<style>
body {
  @apply bg-gray-100
}


.el-row .el-card {
  min-width: 100%;
  height: 100%;
  margin-right: 20px;
  transition: all .5s;
}
</style>

