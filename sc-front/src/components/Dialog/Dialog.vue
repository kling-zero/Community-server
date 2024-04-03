<script setup>
import { computed } from 'vue'
import { Close } from '@element-plus/icons-vue'

const props = defineProps(['modelValue', 'title'])
const emits = defineEmits(['update:modelValue', 'submit'])

const value = computed({
  get: () => props.modelValue,
  set: (newValue) => emits('update:modelValue', newValue)
})

const onSubmit = () => {
  emits('submit')
  value.value = false
}
</script>

<template>
  <Transition enter-from-class="opacity-0" leave-to-class="opacity-0">
    <div
      v-show="value"
      class="fixed inset-0 z-30 flex items-center justify-center bg-black bg-opacity-20 backdrop-blur-sm transition"
    >
      <Transition
        enter-from-class="-translate-y-2"
        leave-to-class="translate-y-2"
      >
        <div class="w-80 rounded bg-white transition" v-show="value">
          <div class="mb-2 flex flex-row items-start text-2xl text-slate-700 p-4">
            <span class="mr-auto font-semibold">
              {{ props.title }}
            </span>
            <el-button :icon="Close" link @click="value = false" />
          </div>
          <div class='px-4'>
            <slot></slot>
          </div>
          <div class="mt-6 flex flex-row justify-end bg-gray-100 px-4 py-2 rounded-b border-t border-slate-300">
            <el-button type="default" @click="value = false">取消</el-button>
            <el-button type="primary" @click="onSubmit">确定</el-button>
          </div>
        </div>
      </Transition>
    </div>
  </Transition>
</template>
