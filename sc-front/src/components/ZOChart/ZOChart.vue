<script setup>
import { onMounted, ref, watch } from 'vue'
import ZOChart from "./ZOChart"
const chartRef = ref(null)
const containerRef = ref(null)
const props = defineProps({
  chartData: {
    type: Object,
    required: true
  },
  chartType: {
    type: String,
    required: true
  },
  size: {
    type: Array,
    default: ['auto', 'auto']
  },
  position: {
    type: Array,
    default: ['50%', '50%']
  },
  focus: {
    type: Boolean,
    default: false
  },
  color: {
    type: Array,
    default: [
      '#5470c6',
      '#91cc75',
      '#fac858',
      '#ee6666',
      '#73c0de',
      '#3ba272',
      '#fc8452',
      '#9a60b4',
      '#ea7ccc'
    ]
  },
  toolbox: {
    type: Boolean,
    default: false
  },
  toolboxOrient: {
    type: String,
    default: 'vertical'
  },
  toolboxPos: {
    type: Array,
    default: ['bottom 12%', 'left right']
  },
  legend: {
    type: [Boolean, String],
    default: false
  },
  legendOrient: {
    type: String,
    default: 'vertical'
  },
  legendPos: {
    type: Array,
    default: ['top top', 'left right']
  },
  legendText: {
    type: String,
    default: 'light'
  },
  label: {
    type: [Boolean, String],
    default: false
  },
  labelSize: {
    type: String,
    default: 'medium'
  },
  labelLine: {
    type: [Boolean, String],
    default: false
  }
})

let chart

function init(data) {
  chart = new ZOChart({
    container: containerRef.value,
    target: chartRef.value,
    options: props,
    data
  })
}

function $render() {
  chart.render()
}

onMounted(() => {
  init(props.chartData)
  $render()
})

watch(props.chartData,() => {
  $render()
})
</script>

<template>
  <div class="zo-chart-container" ref="containerRef">
    <div class="zo-chart-main" ref="chartRef" />
  </div>
</template>

<style scoped>
.zo-chart-container {
  width: 720px;
  height: 480px;
}

.zo-chart-container .zo-chart-main {
  width: 100%;
  height: 100%;
}
</style>
