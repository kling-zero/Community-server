<template>
  <el-card shadow="hover">
    <div class="flex">
      <span class="text-2xl font-bold">{{props.title}}</span>
    </div>
    <div style="width: 100%; height: 300px" class="flex items-center">
      <ZOChart :chartData="chartData" chartType='pie' label-size="small"
      />
    </div>

    <div class="flex justify-between">
      <div class="flex px-1 py-3" v-for="(item) in inform">
        <div class="px-2 grid justify-items-center">
          <div class="text-1xl font-bold">{{item[0]}}</div>
          <div class="text-sm text-gray-400">{{item[1]}}</div>
        </div>
      </div>
    </div>
  </el-card>
</template>

<script setup>
import ZOChart from '../../../components/ZOChart/ZOChart.vue'
import {reactive} from "vue";
let myChart = null

let inform = reactive(props.source)

let chartData = reactive({
  dimensions: props.dimensions,
  source: props.source.slice(1,props.source.length)
})

const props = defineProps({
  title:{
    type:String,
    default:"暂无数据"
  },
  dimensions:{
    type:Array,
    default:[]
  },
  source:{
    type:Array,
    default:[]
  },
  myChart:{
    type:String,
    default:"myChart"
  }
})


</script>

<style scoped>

</style>
