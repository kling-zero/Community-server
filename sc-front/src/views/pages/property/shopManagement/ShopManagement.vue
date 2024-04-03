<script setup>
import { reactive, ref } from 'vue'
import { ZOTree, Table, PageLayout } from '@/components'
import { rowKey } from 'element-plus/es/components/table-v2/src/common';
import { rowProps } from 'element-plus';

const formHeader = reactive({
  title: '查询条件'
})

const formConfig = reactive({

  formItemList: [
    {
      type: 'text',
      placeholder: '请填写商铺编号 格式 楼栋-商铺',
      prop: 'roomName',
      more:'true'
    },
    {
      type: 'select',
      placeholder: '请选择状态',
      prop: 'state',
      more:'true',
      optList:[
        {
          value:'请选择状态'
        },
        {
          value:'审核中'
        },
        {
          value:'审核完成'
        },
        {
          value:'审核失败'
        }
      ]
    },
    {
      type: 'text',
      placeholder: '请填写商铺ID',
      prop: 'roomId',
      more:'true'
    }
  ],
  operate: [
    {
      name: '查询',
      func: (data) => {
        console.log('query', data)
      }
    }
  ]
  
})

const formValue = reactive({
  roomName: '',
  state: '',
  roomId: ''
})


const tableHeader = reactive({
  title: '商铺信息',
  headerBtn:[
    {
      name: '添加商铺',
      link: true,
      type:'primary',
      func: () => {
        console.log('添加商铺')
        showAddDialog.value = true
      }
    }
  ]
})

const tableLabel = reactive([
  {
    label: '商铺编号',
    prop: 'shopID'
  },
  {
    label: '楼层',
    prop: 'floor'
  },
  {
    label: '业主/租方',
    prop: 'owner'
  },
  {
    label: '联系电话',
    prop: 'phone'
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
    label: '起租时间',
    prop: 'beginTime'
  },
  {
    label: '截租时间',
    prop: 'endTime'
  },
  {
    label: '租金',
    prop: 'shopRent'
  },
  {
    label: '算费系数',
    prop: 'coefficient'
  },
  {
    label: '商铺状态',
    prop: 'shopState'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '解绑',
        show:'false',
        func() {
          console.log('unbind')
          showUnbindDialog.value = true
        }
      },
      {
        name: '修改',
        func() {
          console.log('change')
          showEditDialog.value = true
        }
      }
    ]
  }
])

const tableData = reactive([
  {
    shopID: '1-9009988',
    floor: '1 层',
    owner: '小区业主',
    phone: '134****4444',
    buildingArea: '50.00 平方米',
    indoorArea: '50.00 平方米',
    beginTime: '2022-10-09 00:00:00',
    endTime: '2037-01-01 00:00:00',
    shopRent: '5.00',
    coefficient: '1.00',
    shopState: '已出售'
  },
  {
    shopID: '1-1232',
    floor: '3 层',
    owner: '小区业主',
    phone: '134****4444',
    buildingArea: '132.00 平方米',
    indoorArea: '12.00 平方米',
    beginTime: '1899-12-31 16:00:00',
    endTime: '2022-11-25 11:50:00',
    shopRent: '111.00',
    coefficient: '1.00',
    shopState: '已入住'
  }
])

const showEditDialog = ref(false)
const showAddDialog = ref(false)
const showUnbindDialog = ref(false)

//添加商铺弹窗
const editValue = reactive({
  shopID: '1-1232',
  floor: '3 层',
  building:'',//楼栋 不确定的变量名
  shopRent: '111.00',
  buildingArea: '132.00 平方米',
  indoorArea: '12.00 平方米',
  coefficient: '1.00',
  remarks:''
})

const unbind = ()=>{
  console.log('unbind')
}

// const tableData1 = [
//   {
//     date: '2016-05-03',
//     name: ['Tom','123'],
//     address: 'No. 189, Grove St, Los Angeles',
//   }

// ]

const showData = (data)=>{
  console.log(data)
}
</script>

<template>
  <PageLayout>
    <template #header>
      <div>Shop --- on the top</div>
    </template>
    <template #default>
      <Form
        :formInline="true"
        :formHeader="formHeader"
        :formConfig="formConfig"
        :formValue="formValue"
      />
      <div class="data-table">
        <el-row class="data-table-header">
          <el-col :span="5"><h4>商铺信息</h4></el-col>
          <el-col :span="5" :push="17">
            <el-button type="primary" size="default" @click="showAddDialog = true">
              添加商铺
            </el-button>
          </el-col>
        </el-row>
        <el-table :data="tableData" style="width: 100%" :table-layout="auto" class="data-table-content">
        
          <el-table-column prop="shopID" label="商铺编号"/>
          <el-table-column prop="floor" label="楼层" />
          <el-table-column prop="owner" label="业主/租方" />
          <el-table-column prop="phone" label="联系电话" />
          <el-table-column prop="buildingArea" label="建筑面积" />
          <el-table-column prop="indoorArea" label="室内面积" />
          <el-table-column prop="beginTime" label="起租时间" />
          <el-table-column prop="endTime" label="截租时间" />
          <el-table-column prop="shopRent" label="租金" />
          <el-table-column prop="coefficient" label="算费系数" />
          <el-table-column prop="shopState" label="商铺状态" />
          <el-table-column fixed="right" label="Operations" width="120">
            <template #default >
              <el-button link type="primary" size="small" @click="showData()"
                >出租
              </el-button>
              <el-button link type="primary" size="small" @click="handleClick"
                >出售
              </el-button>
              <el-button link type="primary" size="small" @click="handleClick"
                >解绑
              </el-button>
              <el-button link type="primary" size="small" @click="handleClick"
                >修改
              </el-button>
              <el-button link type="primary" size="small">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
     

      <!-- 添加操作弹窗 -->
      <el-dialog
        v-model="showAddDialog"
        title="添加商铺"
        width="50%"
        :before-close="handleClose">
        <el-form :model="editValue" label-width="120px" >
          <el-form-item label="商铺编号">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写商铺编号"/>
          </el-form-item>
          <el-form-item label="商铺楼层">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写商铺楼层"/>
          </el-form-item>
          <el-form-item label="楼栋">
            <el-select v-model="editValue.roomId" placeholder="必填，请选择楼栋">
              <el-option label="C11栋" value="C11栋" />
              <el-option label="C11栋" value="C11栋" />
              <el-option label="C11栋" value="C11栋" />
            </el-select>
          </el-form-item>
          <el-form-item label="租金">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写租金"/>
          </el-form-item>
          <el-form-item label="建筑面积(平方)">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写建筑面积"/>
          </el-form-item>
          <el-form-item label="室内面积(平方)">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写室内面积"/>
          </el-form-item>
          <el-form-item label="算费系数">
            <el-input v-model="editValue.roomId" placeholder="1" type="number"/>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="editValue.roomId" placeholder="请填写备注信息" type="textarea"/>
          </el-form-item>
          <el-row>
            <el-col :span="19"></el-col>
            <el-col :span="5">
              <el-button @click="showAddDialog = false" type="info">取消</el-button>
              <el-button type="primary" @click="onSubmit"><el-icon :size="20" color="#fff"><Check /></el-icon>保存</el-button>
            </el-col>
          </el-row>

        </el-form>
      </el-dialog>
      <!-- 修改操作弹窗 -->
      <el-dialog
        v-model="showEditDialog"
        title="修改商铺"
        width="50%"
        :before-close="handleClose">
        <el-form :model="editValue" label-width="120px" >
          <el-form-item label="商铺ID">
            <el-input v-model="editValue.roomId" placeholder="" readonly/>
          </el-form-item>
          <el-form-item label="商铺编号">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写商铺编号" value=""/>
          </el-form-item>
          <el-form-item label="商铺楼层">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写商铺楼层" value=""/>
          </el-form-item>
          <el-form-item label="租金">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写租金"/>
          </el-form-item>
          <el-form-item label="建筑面积(平方)">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写建筑面积"/>
          </el-form-item>
          <el-form-item label="室内面积(平方)">
            <el-input v-model="editValue.roomId" placeholder="必填，请填写室内面积"/>
          </el-form-item>
          <el-form-item label="算费系数">
            <el-input v-model="editValue.roomId" placeholder="1" type="number"/>
          </el-form-item>
          <el-form-item label="精装修">
            <el-select v-model="editValue.roomId" placeholder="是否精装修">
              <el-option label="是否精装修" value="none" />
              <el-option label="否" value="否" />
              <el-option label="是" value="是" />
            </el-select>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="editValue.roomId" placeholder="请填写备注信息" type="textarea"/>
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
      <!-- 解绑确认框 -->
      <el-dialog
        v-model="showUnbindDialog"
        title="请确认您的操作!"
        width="30%"
        :before-close="handleClose"
      >
        <span>确认是否解绑!</span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="showUnbindDialog = false" type="info">点错了</el-button>
            <el-button type="primary"  @click="unbind">
              确认解绑
            </el-button>
          </span>
        </template>
      </el-dialog>

      

    </template>
  </PageLayout>
</template>

<style >

.data-table{
  margin-top: 5px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgb(215, 218, 224);
}
.data-table-header{
  border-bottom: 1px solid rgb(231, 234, 236);
  padding: 15px 15px 8px 15px;
}

.data-table-content{
  padding: 22px;

}

</style>
