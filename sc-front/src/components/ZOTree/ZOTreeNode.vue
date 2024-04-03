<template>
    <ul :id="id" class="tree-list" @click.stop="close()">
        <li>
            <img v-if="children" :class="showChildren ? 'open-node' : ''" src="https://cfan.cc/tc/static/img/tree.png" />
            <span v-else class="no-img-li"></span>
            <span :class="selected==source ? 'node-selected-li' : ''">
              <img v-if="icon" :src="icon" />
              {{label}}
            </span>
        </li>
        <transition name="el-zoom-in-top">
            <li v-if="showChildren" class="transition-box children-list-li">
                <slot></slot>
            </li>
        </transition>
    </ul>
</template>

<script setup>
import { ref } from 'vue'

const props = defineProps({
  id: String,
  label: String,
  children: Boolean,
  icon: String,
  source: Object,
  selected: Object
})

const showChildren = ref(false)

const close = props.children
  ? () => {
      showChildren.value = !showChildren.value
    }
  : () => {
    }
</script>

<style>
.tree-list{
  list-style-type: none;
  list-style-image: none;
  user-select: none;
  -moz-user-select: none;
  -webkit-user-select: none;
  cursor: pointer;
  margin: 0;
  padding: 0;
}
.tree-list img{
    height: 20px;
    vertical-align: top;
    transition: all 0.5s;
    display: inline-block;
}
.no-img-li{
  width: 20px;
  display: inline-block;
}
.children-list-li{
  margin-left: 30px;
}
.node-selected-li{
  background-color: #beebfe;
}
</style>
