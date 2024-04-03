<script setup>
import { Ripple } from '@/components'
import { useRoute, useRouter } from 'vue-router'
import { IconUnordered } from '../icons'

const props = defineProps(['children', 'show'])

const route = useRoute()
const router = useRouter()

function jumpTo(name) {
  router.push({ name })
}
</script>

<template>
  <Transition>
    <div
      class="relative flex cursor-pointer select-none flex-col flex-nowrap overflow-hidden transition-all duration-300"
      :style="{
        minHeight: show ? props.children.length * 36 + 24 + 'px' : '0'
      }"
      v-if="children.length !== 0"
    >
      <div class="absolute bottom-2 left-0 right-0">
        <span
          v-for="(child, index) in children"
          :key="index"
          class="relative mx-2 mt-1 flex h-8 flex-row flex-nowrap items-center rounded-md pl-6 transition-colors hover:bg-gray-200"
          :class="
            route.name === child.name
              ? 'bg-blue-200 text-blue-800 hover:bg-blue-200'
              : 'text-gray-600'
          "
          @click="jumpTo(child.name)"
        >
          <!-- icon -->
          <IconUnordered />

          <!-- text -->
          <span class="ml-4 text-sm hover:text-gray-800">
            {{ child.meta ? child.meta.text : 'NONE' }}
          </span>

          <Ripple show="true" tw-color="bg-gray-500" />
        </span>
      </div>
    </div>
  </Transition>
</template>
