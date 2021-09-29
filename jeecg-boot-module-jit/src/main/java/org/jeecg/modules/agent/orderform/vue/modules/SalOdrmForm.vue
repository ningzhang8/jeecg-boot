<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <!-- 主表单区域 -->
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="24" >
            <a-form-model-item label="orderNumber" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="orderNumber">
              <a-input v-model="model.orderNumber" placeholder="请输入orderNumber" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="fkagentid" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="fkagentid">
              <a-input v-model="model.fkagentid" placeholder="请输入fkagentid" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="orderSource" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="orderSource">
              <a-input v-model="model.orderSource" placeholder="请输入orderSource" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="salesman" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="salesman">
              <a-input v-model="model.salesman" placeholder="请输入salesman" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="orderInfo" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="orderInfo">
              <a-input v-model="model.orderInfo" placeholder="请输入orderInfo" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="cnee" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="cnee">
              <a-input v-model="model.cnee" placeholder="请输入cnee" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="tel" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="tel">
              <a-input v-model="model.tel" placeholder="请输入tel" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="fullAddress" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="fullAddress">
              <a-input v-model="model.fullAddress" placeholder="请输入fullAddress" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="city" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="city">
              <a-input v-model="model.city" placeholder="请输入city" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="province" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="province">
              <a-input v-model="model.province" placeholder="请输入province" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="region" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="region">
              <a-input v-model="model.region" placeholder="请输入region" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="customerCode" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="customerCode">
              <a-input v-model="model.customerCode" placeholder="请输入customerCode" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="address" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="address">
              <a-input v-model="model.address" placeholder="请输入address" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="orderAmt" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="orderAmt">
              <a-input-number v-model="model.orderAmt" placeholder="请输入orderAmt" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="req" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="req">
              <a-input v-model="model.req" placeholder="请输入req" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="orderDate" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="orderDate">
              <j-date placeholder="请选择orderDate" v-model="model.orderDate" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="txType" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="txType">
              <a-input v-model="model.txType" placeholder="请输入txType" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="sellDate" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="sellDate">
              <j-date placeholder="请选择sellDate" v-model="model.sellDate" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="fcurrency" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="fcurrency">
              <a-input v-model="model.fcurrency" placeholder="请输入fcurrency" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="customerOrderNumber" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="customerOrderNumber">
              <a-input v-model="model.customerOrderNumber" placeholder="请输入customerOrderNumber" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="fkexpressid" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="fkexpressid">
              <a-input v-model="model.fkexpressid" placeholder="请输入fkexpressid" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="frecstat" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="frecstat">
              <a-input v-model="model.frecstat" placeholder="请输入frecstat" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="file1" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="file1">
              <a-input v-model="model.file1" placeholder="请输入file1" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="file2" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="file2">
              <a-input v-model="model.file2" placeholder="请输入file2" ></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </j-form-container>
      <!-- 子表单区域 -->
    <a-tabs v-model="activeKey" @change="handleChangeTabs">
      <a-tab-pane tab="sal_odrd" :key="refKeys[0]" :forceRender="true">
        <j-editable-table
          :ref="refKeys[0]"
          :loading="salOdrdTable.loading"
          :columns="salOdrdTable.columns"
          :dataSource="salOdrdTable.dataSource"
          :maxHeight="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :actionButton="true"/>
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script>

  import { getAction } from '@/api/manage'
  import { FormTypes,getRefPromise,VALIDATE_NO_PASSED } from '@/utils/JEditableTableUtil'
  import { JEditableTableModelMixin } from '@/mixins/JEditableTableModelMixin'
  import { validateDuplicateValue } from '@/utils/util'

  export default {
    name: 'SalOdrmForm',
    mixins: [JEditableTableModelMixin],
    components: {
    },
    data() {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 6 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        labelCol2: {
          xs: { span: 24 },
          sm: { span: 3 },
        },
        wrapperCol2: {
          xs: { span: 24 },
          sm: { span: 20 },
        },
        model:{
        },
        // 新增时子表默认添加几行空数据
        addDefaultRowNum: 1,
        validatorRules: {
           orderNumber: [
              { required: true, message: '请输入orderNumber!'},
           ],
           fkagentid: [
              { required: true, message: '请输入fkagentid!'},
           ],
           orderSource: [
              { required: true, message: '请输入orderSource!'},
           ],
           salesman: [
              { required: true, message: '请输入salesman!'},
           ],
           orderInfo: [
              { required: true, message: '请输入orderInfo!'},
           ],
           cnee: [
              { required: true, message: '请输入cnee!'},
           ],
           tel: [
              { required: true, message: '请输入tel!'},
           ],
           fullAddress: [
              { required: true, message: '请输入fullAddress!'},
           ],
           city: [
              { required: true, message: '请输入city!'},
           ],
           province: [
              { required: true, message: '请输入province!'},
           ],
           region: [
              { required: true, message: '请输入region!'},
           ],
           customerCode: [
              { required: true, message: '请输入customerCode!'},
           ],
           address: [
              { required: true, message: '请输入address!'},
           ],
           orderAmt: [
              { required: true, message: '请输入orderAmt!'},
           ],
           req: [
              { required: true, message: '请输入req!'},
           ],
           orderDate: [
              { required: true, message: '请输入orderDate!'},
           ],
           txType: [
              { required: true, message: '请输入txType!'},
           ],
           sellDate: [
              { required: true, message: '请输入sellDate!'},
           ],
           fcurrency: [
              { required: true, message: '请输入fcurrency!'},
           ],
           customerOrderNumber: [
              { required: true, message: '请输入customerOrderNumber!'},
           ],
           fkexpressid: [
              { required: true, message: '请输入fkexpressid!'},
           ],
           frecstat: [
              { required: true, message: '请输入frecstat!'},
           ],
           file1: [
              { required: true, message: '请输入file1!'},
           ],
           file2: [
              { required: true, message: '请输入file2!'},
           ],
        },
        refKeys: ['salOdrd', ],
        tableKeys:['salOdrd', ],
        activeKey: 'salOdrd',
        // sal_odrd
        salOdrdTable: {
          loading: false,
          dataSource: [],
          columns: [
            {
              title: 'fkid',
              key: 'fkid',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'fproductdesc',
              key: 'fproductdesc',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'len',
              key: 'len',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'width',
              key: 'width',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'quality',
              key: 'quality',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'area',
              key: 'area',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'price',
              key: 'price',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'total',
              key: 'total',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'color',
              key: 'color',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'logoColor',
              key: 'logoColor',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'borderMode',
              key: 'borderMode',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'otherReq',
              key: 'otherReq',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'fproductcode',
              key: 'fproductcode',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'fsubclacode',
              key: 'fsubclacode',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'unitPrice',
              key: 'unitPrice',
              type: FormTypes.inputNumber,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'fpriceid',
              key: 'fpriceid',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'fcategory',
              key: 'fcategory',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'fsubcategory',
              key: 'fsubcategory',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
            {
              title: 'imagePath',
              key: 'imagePath',
              type: FormTypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
              validateRules: [{ required: true, message: '${title}不能为空' }],
            },
          ]
        },
        url: {
          add: "/orderform/salOdrm/add",
          edit: "/orderform/salOdrm/edit",
          queryById: "/orderform/salOdrm/queryById",
          salOdrd: {
            list: '/orderform/salOdrm/querySalOdrdByMainId'
          },
        }
      }
    },
    props: {
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    computed: {
      formDisabled(){
        return this.disabled
      },
    },
    created () {
    },
    methods: {
      addBefore(){
        this.salOdrdTable.dataSource=[]
      },
      getAllTable() {
        let values = this.tableKeys.map(key => getRefPromise(this, key))
        return Promise.all(values)
      },
      /** 调用完edit()方法之后会自动调用此方法 */
      editAfter() {
        this.$nextTick(() => {
        })
        // 加载子表数据
        if (this.model.id) {
          let params = { id: this.model.id }
          this.requestSubTableData(this.url.salOdrd.list, params, this.salOdrdTable)
        }
      },
      //校验所有一对一子表表单
      validateSubForm(allValues){
          return new Promise((resolve,reject)=>{
            Promise.all([
            ]).then(() => {
              resolve(allValues)
            }).catch(e => {
              if (e.error === VALIDATE_NO_PASSED) {
                // 如果有未通过表单验证的子表，就自动跳转到它所在的tab
                this.activeKey = e.index == null ? this.activeKey : this.refKeys[e.index]
              } else {
                console.error(e)
              }
            })
          })
      },
      /** 整理成formData */
      classifyIntoFormData(allValues) {
        let main = Object.assign(this.model, allValues.formValue)
        return {
          ...main, // 展开
          salOdrdList: allValues.tablesValue[0].values,
        }
      },
      validateError(msg){
        this.$message.error(msg)
      },

    }
  }
</script>

<style scoped>
</style>