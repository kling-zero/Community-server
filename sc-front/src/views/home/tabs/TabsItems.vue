<script setup>
import TabsItemChildren from './TabsItemChildren.vue'
import { Ripple } from '@/components'
import { useRoute, useRouter } from 'vue-router'
import { onMounted, ref } from 'vue'
import { IconArrow } from '@/views/home/icons'

const route = useRoute()
const router = useRouter()

const routes = ref([])

const currentTab = ref('')

onMounted(() => {
  router.options.routes.forEach((r) => {
    if (r.name === 'Home') {
      routes.value = r.children
    }
  })
})

function handleClickTap(tab) {
  currentTab.value = tab.name
  if ('children' in tab) {
    router.push({ name: tab.children[0].name })
  } else {
    router.push({ name: tab.name })
  }
}
</script>

<template>
  <div class="absolute inset-0 top-14 flex flex-col flex-nowrap">
    <div class="tabs overflow-auto">
      <div
        v-for="(item, index) in routes"
        :key="index"
        class="m-2 overflow-hidden rounded-lg bg-gray-100"
      >
        <!-- tab -->
        <div
          @click="handleClickTap(item)"
          class="relative flex h-10 cursor-pointer flex-row flex-nowrap items-center rounded-lg px-2 transition-colors duration-300 hover:bg-gray-100"
          :class="
            currentTab === item.name
              ? route.name === item.name
                ? 'bg-blue-200 text-blue-900 hover:bg-blue-100'
                : 'bg-gray-100 text-black hover:bg-gray-100'
              : 'bg-white text-gray-500 hover:text-gray-700'
          "
        >
          <!-- icon -->
          <span
            class="ml-2 flex h-full w-10 flex-row items-center justify-center"
          >
            <img :src="item.meta ? item.meta.icon : ''" alt="" />
          </span>

          <!-- text -->
          <span class="flex-grow">{{
            item.meta ? item.meta.text : 'NONE'
          }}</span>

          <Ripple tw-color="bg-gray-500" :show="currentTab !== item.name" />

          <span
            v-if="item.children"
            class="mr-4 text-gray-500 transition-transform"
            :class="currentTab === item.name ? 'rotate-90' : 'rotate-0'"
          >
            <IconArrow />
          </span>
        </div>
        <!-- --- -->

        <!-- secondary menu -->
        <TabsItemChildren
          v-if="item.children"
          :children="item.children"
          :show="currentTab === item.name"
        />
        <!-- -------------- -->
      </div>
    </div>
  </div>
</template>

<style>
.tabs::-webkit-scrollbar {
  width: 8px;
}

.tabs::-webkit-scrollbar-thumb {
  border-radius: 9999px;
  background-color: lightgrey;
}
</style>
