<script setup>
import { ref,reactive } from "vue"

const showChooseDialog = ref(false)

const tableHeader = reactive({
  title: ''
})

const tableLabel = reactive([
  {
    label: '名称',
    prop: 'name'
  },
  {
    label: '性别',
    prop: 'sex'
  },
  {
    label: '年龄',
    prop: 'age'
  },
  {
    label: '身份证',
    prop: 'idCard'
  },
  {
    label: '联系方式',
    prop: 'link'
  },
  {
    label: '创建员工',
    prop: 'userName'
  },
  {
    label: '操作',
    prop: 'operation',
    btn: [
      {
        name: '选择',
        type: 'primary',
        func(data) {
          console.log('choose',data.name)
        }
      }
    ]
  }
])

const tableData = reactive([
  {
    name: '李四',
    sex: '男',
    age: '13',
    idCard: '420000000000000000',
    link: '15666666666',
    userName: 'wuxw',
    portrait:''
  }
])

const chooseUser = ()=>{
    console.log('chooseUser')
    showChooseDialog.value = true
}

const props = defineProps({
    ownerInfo:{
        type:Object
    },
    chooseAble:{
        type:Boolean,
        defalut:true
    }
})

//获取业主列表
const getOwnerList = ()=>{

}

//回传选择的业主参数

</script>


<template>
    <div class="ibox">
        <div class="ibox-title">
            <h5><span>业主信息</span></h5>
            <div class="ibox-tools" v-if="chooseAble">
                <button @click="chooseUser">
                    <i class="fa fa-search"></i>
                    <span>选择业主</span>
                </button>
            </div>
        </div>
        <div class="ibox-content">
            <el-row :gutter="20" justify="start">
                <el-col :span="5"><div class="grid-content bg-purple">
                    <el-row :gutter="20"></el-row>
                </div></el-col>
                <el-col :span="6"><div class="grid-content bg-purple info-item">
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>业主</span>ID</label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.memberId}}</label>
                    </el-row>
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>年龄</span></label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.age}}</label>
                    </el-row>
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>创建员工</span></label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.userName}}</label>
                    </el-row>
                </div></el-col>
                <el-col :span="6"><div class="grid-content bg-purple info-item">
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>名称</span></label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.name}}</label>
                    </el-row>
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>身份证</span></label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.idCard}}</label>
                    </el-row>
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>备注</span></label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.remark}}</label>
                    </el-row>
                </div></el-col>
                <el-col :span="6"><div class="grid-content bg-purple info-item">
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>性别</span>ID</label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.sex}}</label>
                    </el-row>
                    <el-row :gutter="20">
                        <label class="col-form-label"><span>联系方式</span>ID</label>：
                                <label v-if="ownerInfo!=null">{{ownerInfo.link}}</label>
                    </el-row>
                </div></el-col>
            </el-row>

        </div>

    <!-- 选择业主弹窗 -->
        <el-dialog
        v-model="showChooseDialog"
        title="选择业主"
        width="50%"
        :before-close="handleClose">
        <el-form :model="editValue" label-width="120px" class="choose-search">
            <el-row gutter="10" justify="space-between">
                <el-col :span="10">
                    <el-input placeholder="输入房屋编号楼栋-单元-房屋"/>
                </el-col>
                <el-col :span="9">
                    <el-input placeholder="输入业主名称"/>
                </el-col>
                <el-col :span="3">
                    <el-button type="primary" @click="onSubmit">查询</el-button>
                </el-col>
            </el-row>
        </el-form>
            <Table
            :header="tableHeader"
            :tableLabel="tableLabel"
            :tableData="tableData"
            >
                
            </Table>
        </el-dialog>
    </div>

    
</template>




<style >

.col, .col-1, .col-10, .col-11, .col-12, .col-2, .col-3, .col-4, .col-5, .col-6, .col-7, .col-8, .col-9, .col-auto, .col-lg, .col-lg-1, .col-lg-10, .col-lg-11, .col-lg-12, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-auto, .col-md, .col-md-1, .col-md-10, .col-md-11, .col-md-12, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-auto, .col-sm, .col-sm-1, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-sm-auto, .col-xl, .col-xl-1, .col-xl-10, .col-xl-11, .col-xl-12, .col-xl-2, .col-xl-3, .col-xl-4, .col-xl-5, .col-xl-6, .col-xl-7, .col-xl-8, .col-xl-9, .col-xl-auto {
    position: relative;
    width: 100%;
    padding-right: 15px;
    padding-left: 15px;
}

.ibox{
    background-color: #ffffff;
    clear: both;
    margin-bottom: 5px;
    margin-top: 0;
    padding: 0;
    overflow: hidden;
    border-radius: 10px;
    border-radius: 10px;
    overflow: hidden;
    box-shadow:  0px 0px 12px rgba(0, 0, 0, 0.12);
}

/* 头部 */
.ibox-title{
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    background-color: #ffffff;
    border-color: #e7eaec;
    border-image: none;
    border-style: solid solid none;
    border-width: 2px 0 0;
    color: inherit;
    margin-bottom: 0;
    padding: 15px 15px 8px 15px;
    min-height: 48px;
    position: relative;
    clear: both;
    overflow: hidden;
    border-bottom:1px solid #e7eaec ;
}

.ibox-title h5 {
    display: inline-block;
    font-size: 14px;
    margin: 0 0 7px;
    padding: 0;
    text-overflow: ellipsis;
    float: none;
    font-weight: 600;
}

.ibox-tools {
    display: block;
    float: none;
    margin-top: 0;
    position: absolute;
    top: 15px;
    right: 15px;
    padding: 0;
    text-align: right;
    top: 10px;
    
}

.ibox-tools button{
    border-radius: 3px;
    font-size: inherit;
    padding: 0.25rem 0.5rem;
    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
}

.ibox-content{
    padding: 15px 20px 20px 20px;
}

.info-item .el-row{
    height: 49.5px;
    color: rgb(103, 106, 108);
    font-size: 13px;
}

.choose-search{
    margin-top: -25px;
    padding-bottom: 15px;
}


</style>