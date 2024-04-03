<script setup>
import { IconSettings, IconLogout, IconMenu } from '../icons'
import { Ripple } from '@/components'
import CommonMenu from '@/components/CommonMenu/CommonMenu.vue'
import { ref } from 'vue';
import { logout } from '@/apis/login'

const menuOpen = ref(false)
const fns = {
  // menu: {
  //   text: '常用菜单',
  //   icon: IconMenu,
  //   fn: () => { 
  //     console.log('常用菜单');
  //     menuOpen.value = true
  //   }
  // },
  // settings: {
  //   text: '设置',
  //   icon: IconSettings,
  //   fn: () => { }
  // },
  logout: {
    text: '注销',
    icon: IconLogout,
    fn: () => { 
      logout()
    }
  },

}
</script>

<template>
  <div class="ml-auto flex cursor-pointer flex-row flex-nowrap">
    <CommonMenu :menuOpen="menuOpen" @close="menuOpen = false"/>
    <div v-for="(item, name) in fns" :key="name"
      class="relative flex h-12 flex-row flex-nowrap items-center rounded p-2 text-gray-500 transition-colors hover:bg-gray-100 hover:text-gray-700"
      @click='item.fn'>
      <span class="flex w-8 items-center justify-center sm:w-10">
        <component :is="item.icon"></component>
      </span>
      <span class="hidden pr-4 sm:inline">{{ item.text }}</span>
      <Ripple show="true" />
    </div>
    
  </div>
</template>
