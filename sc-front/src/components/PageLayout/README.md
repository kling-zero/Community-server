### PageLayout 使用说明

**示例**

```vue
<script setup>
// 引入PageLayout
import { PageLayout } from '@/components'
</script>

<template>
  <PageLayout>
    <template #aside> 侧边插槽 </template>
    <template #header> 头部插槽 </template>
    <template #default> 默认插槽 </template>
  </PageLayout>
</template>
```

**在需要的页面直接引入就可以使用**
