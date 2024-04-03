<script lang="ts">
/**
 * 树状组件
 * 目前支持单选
 * @author 江源
 * @version 1.0.0
 *
 * props:
 *  value: 数组数据
 *  option:{
 *    children	如果传入数据的子项字段名不为children，则使用该属性指定对应的字段名
 *
 *    parent	指定父类节点的图标
 *
 *    child		指定非父节点的图标
 *
 *    label		如果传入数据的显示数据的字段名不为label，用该属性指定对应的字段名
 *
 *    id			如果传入数据的标识属性不为id，则用该属性指定
 *  }
 */
import { ElCard } from 'element-plus'
import { h, PropType } from 'vue'
import Node from './ZOTreeNode.vue'

interface TreeOption {
  children?: String
  parent?: String | any
  child?: String | any
  label?: String
  id?: String
}

export default {
  props: {
    value: Array,
    option: Object as PropType<TreeOption>
  },
  emits: ['select', 'change'],
  data() {
    return {
      Tvalue: this.$props.value || [],
      Toption: this.$props.option || {},
      selected: null
    }
  },
  methods: {
    getTreeNode(v) {
      let children
      if (v[this.Toption.children || 'children']) {
        children = v[this.Toption.children || 'children'].map((v) =>
          this.getTreeNode(v)
        )
      }
      return h(
        Node,
        {
          key: v[this.Toption.id || 'id'],
          id: v[this.Toption.id || 'id'],
          label: v[this.Toption.label || 'label'],
          children: !!v[this.Toption.children || 'children'],
          icon: v[this.Toption.children || 'children']
            ? this.Toption.parent
            : this.Toption.child,
          source: v,
          selected: this.selected,
          onClick: () => this.CallBack(v)
        },
        { default: () => children }
      )
    },
    CallBack(item) {
      this.$emit('select', item)
      if (item !== this.selected) {
        this.$emit('change', item, this.selected)
        this.selected = item
      }
    }
  },
  render() {
    return h(
      ElCard,
      () => this.Tvalue.map((v) => this.getTreeNode(v))
    )
  }
}
</script>
