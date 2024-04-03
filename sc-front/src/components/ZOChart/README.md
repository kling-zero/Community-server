## Echarts组件封装

> 目标: 简单易用 能在各个场景使用
> 目前封装包括: 饼图 环状图 柱状图

### 如何使用

```vue
<script setup>
  // 父组件中引入
  import { ZOChart } from '@/component'
</script>

<template>
  <!-- options 具体参数在下方 -->
  <ZOChart :chartData="{
    dimensions: ['a1','a2'],
    source: [
        ['a1',1],
        ['a2', 2]
      ]
  }" chartType='pie' ...options />
</template>
```

### 所有参数

**ZOChart组件参数表**

| 属性名 | 说明 | 类型 | 可选值 | 默认值 |
| :---: | :---: | :---: | :---: | :---: |
| <span style="display:inline-block;width:200px">-</span> | <span style="display:inline-block;width:200px">-</span> | <span style="display:inline-block;width:200px">-</span> | - | - |
| **chartType** | 图表类型 | `String` | `'pie'`/`'cycle'`/`'bar'` | `'pie'` |
| **size** | 图表大小 | `String[]/Number[]` | - | `['auto','auto']` |
| **position** (*当类型为`bar`时不生效*) | 图表位置 | `String[]` | - | `['50%','50%']` |
| **color** | 图表数据颜色 | `String[]` | - | - |
| **focus** (*4.xx版本不支持*) | 是否开启聚焦模式  | `Boolean` | - | `false` |
| **toolbox** | 是否生成工具箱 | `Boolean` | - | `false` |
| **toolboxOrient** | 工具箱方向 | `String` | `'vertical'`/`'horizontal'` | `'vertical'` |
| **toolboxPos** (*`toolbox`值为`false`时不生效*)  | 工具箱位置 | `String[]` | - | `['bottom 12%','left right']` |
| **legend** | 是否生成图例 | `Boolean/String` | `true/false/'plain'` / `'scroll'` | `false` |
| **legendOrient** | 图例方向 | `String` | `'vertical'`/`'horizontal'` | `'vertical'` *当类型为`bar`时为`'horizontal'`* |
| **legendPos** | 图例位置 | `String[]` | - | `['top top','left right']` |
| **legendText** | 图例文字样式 | `String` | `'light'`/`'dark'` |  `'light'` |
| **label** | 未选中时是否需要展示标签 | `Boolean/String` | `true/false/'outside'`/`'inside'`/`'center'` | `false` |
| **labelSize** | 标签字体大小 | `String` | `'small'`/`'medium'`/`'large'` | `'medium'` |
| **labelLine** (*`label`值为`false`或类型为`bar`时不生效*) | 标签线样式 | `Boolean/Object` | `'short'`/`'middle'`/`'long'` | `'middle'` |

**示例**

```html
<ZOChart
  chartType="pie"
  size=['auto','auto']
  position=['50%','50%']
  color=[color1,color2,color3,...]
  focus="none"
  toolbox="true"
  toolboxOrient='vertical'
  toolboxPos=['bottom 20%', 'left right']
  legend='plain'
  legendOrient='vertical'
  legendPos=['top 10', 'left 20']
  legendText='light'
  label='outside'
  labelSize='large'
  labelLine='short'
/>
```
