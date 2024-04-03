<script setup>
import { ref } from 'vue'

const isFold = ref(true)

const unfold = () => (isFold.value = false)

const fold = () => (isFold.value = true)
</script>

<template>
  <div class="absolute inset-0">
    <div id="home" class="absolute inset-0 -left-48 grid sm:left-0">
      <!-- tabs -->
      <div id="tabs" class="relative shadow-lg shadow-gray-300">
        <div
          class="absolute top-0 bottom-0 z-20 flex w-full flex-col flex-nowrap border-r border-r-slate-300 bg-white transition-all sm:inset-0 sm:border-transparent"
          :class="isFold ? 'left-0' : 'left-full'"
        >
          <slot name="tabs"></slot>
        </div>

        <!-- shade -->
        <Transition enter-from-class="opacity-0" leave-to-class="opacity-0">
          <div
            v-show="!isFold"
            class="fixed inset-0 z-10 bg-black bg-opacity-20 backdrop-blur-sm transition-opacity sm:hidden"
            @click="fold"
          ></div>
        </Transition>
      </div>

      <!-- head -->
      <div
        id="head"
        class="flex flex-row flex-nowrap items-center border-b border-slate-300 p-2"
      >
        <span
          class="inline-flex h-10 w-10 items-center justify-center rounded-full active:bg-gray-200 sm:hidden"
          @click="unfold"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke-width="1.5"
            stroke="currentColor"
            color="#757575"
            class="h-5 w-5"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25H12"
            />
          </svg>
        </span>
        <slot name="head"></slot>
      </div>

      <!-- main -->
      <div id="main" class="relative overflow-auto">
        <div class="absolute top-0 left-0 right-0">
          <slot name="main"></slot>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
#home {
  grid-template-areas:
    'tabs head'
    'tabs main';
  grid-template-rows: 3.5rem 1fr;
  grid-template-columns: 12rem 1fr;
}

#tabs {
  grid-area: tabs;
}

#head {
  grid-area: head;
}

#main {
  grid-area: main;
}
</style>
