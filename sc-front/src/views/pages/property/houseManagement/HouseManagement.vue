<script setup>
import { reactive, ref } from 'vue'
import {queryRoomState,queryRoomType} from '@/apis/property/houseManagement/index'

const showEditDialog = ref(false)//显示编辑框
const showDeleteDialog = ref(false)//显示删除框

const treeData = reactive([
  {
    id: '001',
    label: '一栋',
    children: [
      {
        id: '0011',
        label: '一单元'
      },
      {
        id: '0012',
        label: '二单元'
      },
      {
        id: '0015',
        label: '五单元'
      },
      {
        id: '0016',
        label: '六单元'
      }
    ]
  },
  {
    id: '002',
    label: '二栋',
    children: [
      {
        id: '0021',
        label: '一单元'
      },
      {
        id: '0022',
        label: '二单元'
      },
      {
        id: '0025',
        label: '五单元'
      },
      {
        id: '0026',
        label: '六单元'
      }
    ]
  },
  {
    id: '003',
    label: '三栋',
    children: [
      {
        id: '0031',
        label: '一单元'
      },
      {
        id: '0032',
        label: '二单元'
      },
      {
        id: '0035',
        label: '五单元'
      },
      {
        id: '0036',
        label: '六单元'
      }
    ]
  }
])
const treeOpts = reactive({
  parent: '/floor.png',
  child: '/unit.png'
})

const formHeader = reactive({
  title: '查询条件' 
})
const formConfig = reactive({
  formItemList: [
    {
      more: true,
      type: 'text',
      placeholder: '请填写房屋编号  格式 楼栋-单元-房屋',
      prop: 'room'
    },
    {
      more: true,
      type: 'select',
      placeholder: '请选择状态',
      prop: 'roomState',
      optList: [
        {
          value: '未销售'
        },
        {
          value: '已入住'
        },
        {
          value: '已交房'
        },
        {
          value: '已装修'
        
        },
        {
          value: '未入住'
        
        },
        {
          value: '已出售'
        
        },
        {
          value: '已出租'
        
        },
        {
          value: '空闲'
        },
        {
          value: '装修中'
        }
      ]
    },
    {
      more: true,
      type: 'select',
      placeholder: '必填, 请选择房屋类型',
      prop: 'roomType',
      optList: [
        {
          value: '住宅'
        },
        {
          value: '办公室'
        },
        {
          value: '宿舍'
        },
        {
          value: '储藏室'
        }
      ]
    }
  ],
  operate: [
    {
      name: '查询',
      func: (data) => {
        console.log('query', data)
      }
    },
    {
      name: '重置',
      func: () => {
        formValue.room = ''
        formValue.roomType = ''
        formValue.roomState = ''
        console.log('reset')
      }
    }
  ]
})

const formValue = reactive({
  room: '',
  roomType: '',
  roomState: ''
})

const tableHeader = reactive({
  title: '房屋信息'
})

const tableLabel = reactive([
  {
    label: '房屋',
    prop: 'room'
  },
  {
    label: '楼层',
    prop: 'floor'
  },
  {
    label: '业主',
    prop: 'owner'
  },
  {
    label: '电话',
    prop: 'phone'
  },
  {
    label: '类型',
    prop: 'roomType'
  },
  {
    label: '建筑面积',
    prop: 'buildingArea'
  },
  {
    label: '室内面积',
    prop: 'indoorArea'
  },
  {
    label: '租金',
    prop: 'roomRent'
  },
  {
    label: '房屋状态',
    prop: 'roomState'
  },
  {
    label: '入住时间',
    prop: 'enterTime'
  },
  {
    label: '精装修',
    prop: 'decoration'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '修改',
        func() {
          showEditDialog.value = true
          console.log('change')
        }
      },
      {
        name: '删除',
        func() {
          showDeleteDialog.value = true
          console.log('remove')
        }
      }
    ]
  }
])

const tableData = reactive([
  {
    room: '1-0-101',
    floor: '1 层',
    owner: '吴文龙',
    phone: '18909711586',
    roomType: '住宅',
    buildingArea: '120.00 平方米',
    indoorArea: '98.00 平方米',
    roomRent: '0.0',
    roomState: '已入住',
    enterTime: '2022-10-20 10:00:32',
    decoration: '否'
  }
])

const typeList = reactive(
  []
)

const roomInfo = reactive({
  temp:''
})

queryRoomState().then(res=>{
  typeList = res.data
})
</script>

<template>
  <PageLayout>
    <template #aside>
      <ZOTree :value="treeData" :option="treeOpts" />
    </template>
    <template #header>
      <Form
        :formInline="true"
        :formHeader="formHeader"
        :formConfig="formConfig"
        :formValue="formValue"
      />
    </template>
    <template #default>
      <Table
        :header="tableHeader"
        :tableLabel="tableLabel"
        :tableData="tableData"
      />

      <!-- 修改弹窗 -->
      <el-dialog
        v-model="showEditDialog"
        title="修改信息"
        width="50%"
        :before-close="handleClose">
        <el-form :model="roomInfo" label-width="120px" >
          <el-form-item label="房屋ID">
            <el-input v-model="roomInfo.temp" placeholder="必填，请填写房屋ID" readonly/>
          </el-form-item>
          <el-form-item label="房屋编号">
            <el-input v-model="roomInfo.temp" placeholder="必填，请填写房屋编号"/>
          </el-form-item>
          <el-form-item label="房屋楼层">
            <el-select v-model="roomInfo.temp" placeholder="必填，请填写房屋楼层">
              <el-option label="必填，请选择性别" value="男" />
              <el-option label="男" value="男" />
              <el-option label="女" value="女" />
            </el-select>
          </el-form-item>
          <el-form-item label="房屋单元">
            <el-select v-model="roomInfo.temp" placeholder="必填，请填写房屋单元">
              <el-option label="必填，请填写房屋单元" value="必填，请填写房屋单元" />
              <el-option label="0单元" value="0单元" />
              <el-option label="1单元" value="1单元" />
            </el-select>
          </el-form-item>
          <el-form-item label="房屋户型">
            <el-select v-model="roomInfo.temp" placeholder="必填，请选择房屋户型">
              <el-option label="必填，请选择性别" value="必填，请选择性别" />
              <el-option label="一室" value="一室" />
              <el-option label="二室" value="二室" />
              <el-option label="三室" value="三室" />
              <el-option label="四室" value="四室" />
              <el-option label="五室" value="五室" />
            </el-select>
            <el-select v-model="roomInfo.temp" placeholder="必填，请选择房屋户型">
              <el-option label="必填，请选择性别" value="必填，请选择性别" />
              <el-option label="一厅" value="一厅" />
              <el-option label="二厅" value="二厅" />
              <el-option label="三厅" value="三厅" />
              <el-option label="四厅" value="四厅" />
              <el-option label="五厅" value="五厅" />
            </el-select>
          </el-form-item>
          <el-form-item label="房屋类型">
            <el-select v-model="roomInfo.temp" placeholder="必填，请选择房屋类型">
              <el-option label="必填，请选择房屋类型" value="必填，请选择房屋类型" />
              <el-option label="住宅" value="住宅" />
              <el-option label="办公室" value="办公室" />
              <el-option label="宿舍" value="宿舍" />
              <el-option label="储藏室" value="储藏室" />
            </el-select>
          </el-form-item>
          <el-form-item label="建筑面积">
            <el-input v-model="roomInfo.temp" placeholder="必填，请填写建筑面积"/>
          </el-form-item>
          <el-form-item label="室内面积(平方)">
            <el-input v-model="roomInfo.temp" placeholder="必填，请填写室内面积"/>
          </el-form-item>
          <el-form-item label="算费系数">
            <el-input v-model="roomInfo.temp" placeholder="必填，请填写算费系数"/>
          </el-form-item>
          <el-form-item label="房屋状态">
            <el-select v-model="roomInfo.temp" placeholder="必填，请选择房屋状态">
              <el-option label="必填，请选择房屋状态" value="必填，请选择房屋状态" />
              <el-option label="已入住" value="已入住" />
              <el-option label="已交房" value="已交房" />
              <el-option label="已装修" value="已装修" />
              <el-option label="未入住" value="未入住" />
              <el-option label="空闲" value="空闲" />
              <el-option label="装修中" value="装修中" />
            </el-select>
          </el-form-item>
          <el-form-item label="精装修">
            <el-select v-model="roomInfo.temp" placeholder="是否已装修">
              <el-option label="是" value="是" />
              <el-option label="否" value="否" />
            </el-select>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="roomInfo.temp" placeholder="必填，请填写备注"/>
          </el-form-item>
          <el-row>
            <el-col :span="19"></el-col>
            <el-col :span="5">
              <el-button @click="showEditDialog = false" type="info">取消</el-button>
              <el-button type="primary" @click="onSubmit"><el-icon :size="20" color="#fff"><Check /></el-icon>保存</el-button>
            </el-col>
          </el-row>

        </el-form>
      </el-dialog>
      <!-- 删除弹窗 -->
      <el-dialog
        v-model="showDeleteDialog"
        title="请确认您的操作!"
        width="30%"
        :before-close="handleClose"
      >
        <span>确认是否删除!</span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="showDeleteDialog = false" type="info">点错了</el-button>
            <el-button type="primary"  @click="console.log('delete...')">
              确认删除
            </el-button>
          </span>
        </template>
      </el-dialog>
    </template>
  </PageLayout>
</template>
