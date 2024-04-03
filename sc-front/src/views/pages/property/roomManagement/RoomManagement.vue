<script setup>
import { reactive, ref } from 'vue'
import { ZOTree, Table, PageLayout } from '@/components'


const treeData = reactive([
  {
    id: '125125125',
    label: '一栋',
    children: [
      {
        id: '12561261',
        label: '一单元'
      },
      {
        id: '12561261',
        label: '二单元'
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
      type: 'text',
      placeholder: '请填写房屋编号  格式 楼栋-单元-房屋',
      prop: 'room',
      more:'true'
    },
    {
      type: 'select',
      placeholder: '必填, 请选择房屋类型',
      prop: 'roomType',
      optList: [
        {
          value: 'type1'
        },
        {
          value: 'type2'
        },
        {
          value: 'type3'
        },
        {
          value: 'type4'
        }
      ],
      more:'true'
    },
    {
      type: 'select',
      placeholder: '请选择状态',
      prop: 'roomState',
      optList: [
        {
          value: 'state1'
        },
        {
          value: 'state2'
        },
        {
          value: 'state3'
        },
        {
          value: 'state4'
        }
      ],
      more:'true'
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
        formValue.room= ''
        formValue.roomType= ''
        formValue.roomState= ''
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

const editValue = reactive({
    roomId:'123',
    room: 'room1',
    floor: 'floor1',
    owner: 'Jack',
    phone: '13590613061',
    roomType: 'apartment',
    buildingArea: '120',
    indoorArea: '98',
    roomRent: '2000',
    roomState: 'leisure',
    enterTime: '暂无',
    decoration: '暂无'
})

const tableHeader = reactive({
  title: '房屋信息'
})

const tableLabel = reactive({
  labelList: [
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
          type: 'primary',
          func(e) {
            console.log('change')
            // 获取当前数据 回显=====================
            console.log()
            showEditDialog.value = true
          }
        },{
          name: '删除',
          type: 'primary',
          func() {
            deleteDialog.value = true
            console.log('delete')
          }
        }
      ]
    }
  ]
})

const tableData = reactive([
  {
    room: 'room1',
    floor: 'floor1',
    owner: 'Jack',
    phone: '13590613061',
    roomType: 'apartment',
    buildingArea: '120',
    indoorArea: '98',
    roomRent: '2000',
    roomState: 'leisure',
    enterTime: '暂无',
    decoration: '暂无'
  }
])

const showEditDialog = ref(false)
const deleteDialog = ref(false)


// 删除操作
const deleteShop = (id)=>{
  console.log('delete')
}
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
        :tableLabel="tableLabel.labelList"
        :tableData="tableData"
      >
        <template #remarks>
            <div>
              房屋状态 分为：未销售，未入住，已交房，已装修，已入住 等状态
            </div> 
            <div>
              1、未销售表示 房屋和业主之间还没有任何关系，所以修改时状态不能手工修改 需要业主入住房屋的方式 将未销售改为已入住
            </div> 
            <div>
              2、未入住 已交房 已装修 已入住 状态表示业主和房屋之间已经有关系 可以相互修改，主要作用为在房屋创建费用时根据不同的状态去创建不同的费用
            </div>
            <div>
                租金：主要用于园区类或者房屋出租比较多的物业使用，小区物业忽略
            </div>
        </template>     
      </Table>
      <!-- 修改弹窗 -->
      <el-dialog
        v-model="showEditDialog"
        title="修改房屋"
        width="50%"
        :before-close="handleClose">

        <el-form :model="editValue" label-width="120px">
          <el-form-item label="房屋ID：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId" readonly/>
          </el-form-item>
          <el-form-item label="房屋编号：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId"/>
          </el-form-item>
          <el-form-item label="房屋楼层：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId"/>
          </el-form-item>
          <el-form-item label="房屋单元：">
            <el-select v-model="editValue.roomId" placeholder="必填，请选择单元">
              <el-option label="必填，请选择单元" value="none" />
              <el-option label="0单元" value="0单元" />
              <el-option label="1单元" value="1单元" />
              <el-option label="2单元" value="2单元" />
            </el-select>
          </el-form-item>
          <el-form-item label="房屋户型：">
            <el-select v-model="editValue.roomId" placeholder="必填，请选择房屋户型">
              <el-option label="一室" value="一室" />
              <el-option label="二室" value="二室" />
              <el-option label="三室" value="三室" />
              <el-option label="四室" value="四室" />
            </el-select>
            <el-select v-model="editValue.roomId" placeholder="必填，请选择房屋户型">
              <el-option label="一厅" value="一厅" />
              <el-option label="二厅" value="二厅" />
              <el-option label="三厅" value="三厅" />
            </el-select>
          </el-form-item>
          <el-form-item label="房屋类型：">
            <el-select v-model="editValue.roomId" placeholder="必填，请选择房屋类型">
              <el-option label="必填，请选择房屋类型" value="none" />
              <el-option label="住宅" value="住宅" />
              <el-option label="办公室" value="办公室" />
              <el-option label="宿舍" value="宿舍" />
              <el-option label="储藏室" value="储藏室" />
            </el-select>
          </el-form-item>
          <el-form-item label="建筑面积：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId"/>
          </el-form-item>
          <el-form-item label="室内面积(平方)：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId"/>
          </el-form-item>
          <el-form-item label="算费系数：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId"  type="number"/>
          </el-form-item>
          <el-form-item label="房屋状态：">
            <el-select v-model="editValue.roomId" placeholder="必填，请选择房屋状态">
              <el-option label="已入住" value="已入住" />
              <el-option label="已交房" value="已交房" />
              <el-option label="已装修" value="已装修" />
              <el-option label="未入住" value="未入住" />
              <el-option label="空闲" value="空闲" />
              <el-option label="装修中" value="装修中" />
            </el-select>           
          </el-form-item>
          <el-form-item label="精装修：">
            <el-select v-model="editValue.roomId" placeholder="是否精装修">
              <el-option label="是否精装修" value="是否精装修" />
              <el-option label="是" value="是" />
              <el-option label="否" value="否" />
            </el-select> 
          </el-form-item>
          <el-form-item label="备注：">
            <el-input v-model="editValue.roomId" :placeholder="editValue.roomId"/>
          </el-form-item>
          <el-row>
            <el-col :span="19"></el-col>
            <el-col :span="5">
              <el-button type="primary" @click="onSubmit">保存</el-button>
              <el-button @click="closeEditDialog" type="info">取消</el-button>
            </el-col>
          </el-row>

        </el-form>
      </el-dialog>
      <!-- 删除弹窗 -->
      <el-dialog
        v-model="deleteDialog"
        title="请确认您的操作!"
        width="30%"
        :before-close="handleClose"
      >
        <span>确认是否删除!</span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="deleteDialog = false" type="info">点错了</el-button>
            <el-button type="primary" @click="deleteShop">
              确认删除
            </el-button>
          </span>
        </template>
      </el-dialog>
    </template>
  </PageLayout>
</template>

<style scoped>
 


</style>