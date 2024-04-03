<template>
  <el-card>
    <!-- 标题 -->
    <template v-if="header" #header>
      <div class="card-header">
        <!-- 标题内容 -->
        <span class="title">{{ header.title }}</span>
        <!-- 标题按钮 -->
        <span v-if="header.headerBtn">
          <el-button
            v-for="item in header.headerBtn"
            :key="item.name"
            :type="item.type"
            align="right"
            class="button"
            text
            @click="item.func()"
            >{{ item.name }}</el-button
          >
        </span>
      </div>
    </template>
    <slot name="rolePermissions"></slot>
    <!-- 表格 -->
    <el-table :data="tableData">
      <!-- 表格列表 -->
      <el-table-column
        v-for="item in tableLabel"
        :fixed="item.prop === 'operation' ? 'right' : false"
        :key="item.ID"
        :prop="item.prop"
        :label="item.label"
        :width="item.width||null"
        header-align="center"
        align="center"
      >
        <template #default="scope" v-if="item.btn">
          <!-- 表格操作按钮 -->
          <template v-if="!props.dropdown">
            <el-button
              v-for="btnContent in item.btn"
              :key="btnContent.name"
              :type="btnContent.type"
              :text="btnContent.text"
              size="small"
              @click="btnContent.func(scope.row)"
              >{{ btnContent.name }}
            </el-button>
          </template>

          <!-- 压缩操作按钮 -->
          <el-dropdown placement="bottom" trigger="click" v-if="props.dropdown">
            <el-button type="primary" :icon="ArrowDown" size="small" />
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item v-for="b in item.btn" :key="b.name" disabled>
                  <el-button
                    size="small"
                    :type="b.type"
                    :text="b.text"
                    @click="b.func(scope.row)"
                  >
                    {{ b.name }}
                  </el-button>
                </el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <!-- ---------- -->
        </template>
      </el-table-column>
    </el-table>
    <!-- 底部 -->
    <!-- 分页功能暂未实现 -->
    <div>
      <el-pagination
        class="page"
        background
        layout="prev, pager, next"
        :total="total"
        :current-page="currentPage"
        @current-change="PageChange"
      />
      <!-- 备注插槽 -->
      <slot class="remarks" name="remarks"></slot>
    </div>
  </el-card>
</template>

<script setup>
import { toRefs } from 'vue'
import { ArrowDown } from '@element-plus/icons-vue'

// 接收父组件数据
const props = defineProps({
  header: {
    type: Object,
    default: null
  },
  tableData: {
    type: Array,
    required: true
  },
  tableLabel: {
    type: Array,
    required: true
  },
  dropdown: {
    type: Boolean,
    required: false
  },
  total: {
    type: Number,
    required: true,
    default: 10,
  },
  currentPage: {
    type: Number,
    required: true,
    default: 1,
  }
})
const { header, tableData, tableLabel } = toRefs(props)

const emit = defineEmits(['changePage','update:currentPage'])

function PageChange (index) {
  emit('changePage', index)
  emit('update:currentPage', index)
}
</script>

<style lang="scss" scoped>
:deep(.cell) {
  color: #333739;
  font-size: 14px;
}

:deep(.el-table__header) {
  border-bottom: 2px solid #c8c4c0;
  font-size: 14px;
  .cell {
    font-weight: bold;
  }
  .remarks {
    font-size: 8px;
  }
}

:deep(.page) {
  display: flex;
  justify-content: right;
  padding-top: 40px;
}

:deep(.el-card__header) {
  padding: 8px 12px;

  .card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 10px;
    color: #676a6c;
    .title {
      font-size: 14px;
      font-weight: 600;
    }
  }
}
</style>
