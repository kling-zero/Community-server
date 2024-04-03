<script setup>
import { onBeforeMount, onUnmounted, ref, useSlots, watch } from 'vue'
import { setStyle, minmax } from '@/methods/method'

const RATIO = 0.24
const MIN_WID = 180
const MAX_WID = 320

const slot = useSlots()
const pageRef = ref(null)
const asideRef = ref(null)
const mainRef = ref(null)
const asideWid = ref(null)
const isShow = (name) => name in slot

/* 改变视窗大小事件函数 */
function resize() {
  asideWid.value = pageRef.value.offsetWidth * RATIO
}

/* 挂载事件 */
function mountEvent() {
  const width = pageRef.value.offsetWidth * RATIO
  asideWid.value = minmax(width, [MIN_WID, MAX_WID])
  window.addEventListener('resize', resize, false)
}

/* 解绑事件 */
function dismountEvent() {
  window.removeEventListener('resize', resize, false)
}

watch(asideRef, (VNode) => {
  /* 存在aside元素则挂载事件 */
  if (VNode) mountEvent()
})

watch(asideWid, (newVal) => {
  newVal = minmax(newVal, [MIN_WID, MAX_WID])
  setStyle(asideRef.value, { width: newVal + 'px' })
  setStyle(mainRef.value, { left: newVal + 30 + 'px' })
})

onBeforeMount(() => {
  dismountEvent()
})

onUnmounted(() => {
  dismountEvent()
})
</script>

<template>
  <div class="page-layout" ref="pageRef">
    <section class="page-aside" ref="asideRef" v-if="isShow('aside')">
      <slot name="aside"></slot>
    </section>
    <section class="page-main" ref="mainRef">
      <header class="page-header" v-if="isShow('header')">
        <slot name="header"></slot>
      </header>
      <main class="page-content">
        <slot name="default"></slot>
      </main>
    </section>
  </div>
</template>

<style scoped>
:deep(.el-card) {
  border-radius: 8px;
}

.page-layout {
  position: relative;
}

.page-aside {
  position: absolute;
  top: 10px;
  left: 10px;
}

.page-main {
  position: absolute;
  top: 10px;
  left: 10px;
  right: 10px;
}

.page-header {
  margin-bottom: 8px;
}
</style>
