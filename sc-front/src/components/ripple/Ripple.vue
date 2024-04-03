<script setup>
import { computed, ref } from 'vue'

const props = defineProps(['twColor', 'show'])

const container = ref()

const diameter = computed(() => {
  const w = container.value.offsetWidth
  const h = container.value.offsetHeight
  const long = w > h ? w : h
  return long * 2.9
})

const { createRipple, removeRipple } = (() => {
  function newRipple(diameter, x, y) {
    const ripple = document.createElement('span')
    ripple.classList.add('ripple', props.twColor ?? 'bg-black')
    ripple.style.width = diameter + 'px'
    ripple.style.height = diameter + 'px'
    ripple.style.left = x + 'px'
    ripple.style.top = y + 'px'
    return ripple
  }

  const queue = []

  function createRipple(event) {
    if (props.show) {
      const ripple = newRipple(diameter.value, event.offsetX, event.offsetY)
      container.value.appendChild(ripple)
      queue.push(ripple)
    }
  }

  function removeRipple() {
    if (props.show) {
      const ripple = queue.shift()
      setTimeout(() => ripple.classList.add('ripple-leave'), 200)
      setTimeout(() => ripple.remove(), 800)
    }
  }

  return { createRipple, removeRipple }
})()
</script>

<template>
  <div
    class="ripple-container"
    ref="container"
    @mousedown="createRipple"
    @mouseup="removeRipple"
  ></div>
</template>

<style>
.ripple-container {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  overflow: hidden;
  border-radius: inherit;
}

@keyframes ripple {
  from {
    transform: translate(-50%, -50%) scale(0, 0);
  }
  to {
    transform: translate(-50%, -50%) scale(1, 1);
  }
}

.ripple {
  position: absolute;
  display: inline-block;
  animation: ripple 300ms forwards ease-in-out;
  transition: opacity 200ms;
  border-radius: 9999px;
  pointer-events: none;
  opacity: 16%;
}

.ripple-leave {
  opacity: 0;
}
</style>
