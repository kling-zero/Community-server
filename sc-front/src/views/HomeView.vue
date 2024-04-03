<script setup>
import { toDisplayString } from 'vue';
import HomeLayout from './home/layout/HomeLayout.vue'
import { TabsLogo, TabsItems } from './home/tabs'
import { HeadFunction } from './home/head'
import {userStore} from '@/stores/user';
const userS = userStore()
userS.loadUser()
</script>

<template>
  <HomeLayout>
    <template #head>
      <HeadFunction />
    </template>

    <template #tabs>
      <TabsLogo />
      <TabsItems />
    </template>

    <template #main>
      <main class="main">
        <RouterView v-slot="{ Component }">
          <KeepAlive>
            <Component :is="Component" />
          </KeepAlive>
        </RouterView>
      </main>
    </template>
  </HomeLayout>
</template>

<style>
#main {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}
.aside-container{
  height: 100%;
  width: 300px;
}
@media screen and (max-width:640px) {
  /* .main {
    display: block;
  } */
  .aside-container{
    height: auto;
    max-width: 100%;
  }
}
</style>