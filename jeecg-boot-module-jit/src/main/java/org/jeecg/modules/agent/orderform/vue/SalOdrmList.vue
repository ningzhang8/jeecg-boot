<template>
  <a-card :bordered="false">
    <!-- 查询区域 -->
    <div class="table-page-search-wrapper">
      <a-form layout="inline" @keyup.enter.native="searchQuery">
        <a-row :gutter="24">
        </a-row>
      </a-form>
    </div>
    <!-- 查询区域-END -->
    
    <!-- 操作按钮区域 -->
    <div class="table-operator">
      <a-button @click="handleAdd" type="primary" icon="plus">新增</a-button>
      <a-button type="primary" icon="download" @click="handleExportXls('订单表')">导出</a-button>
      <a-upload name="file" :showUploadList="false" :multiple="false" :headers="tokenHeader" :action="importExcelUrl" @change="handleImportExcel">
        <a-button type="primary" icon="import">导入</a-button>
      </a-upload>
      <!-- 高级查询区域 -->
      <j-super-query :fieldList="superFieldList" ref="superQueryModal" @handleSuperQuery="handleSuperQuery"></j-super-query>
      <a-dropdown v-if="selectedRowKeys.length > 0">
        <a-menu slot="overlay">
          <a-menu-item key="1" @click="batchDel"><a-icon type="delete"/>删除</a-menu-item>
        </a-menu>
        <a-button style="margin-left: 8px"> 批量操作 <a-icon type="down" /></a-button>
      </a-dropdown>
    </div>

    <!-- table区域-begin -->
    <div>
      <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;">
        <i class="anticon anticon-info-circle ant-alert-icon"></i> 已选择 <a style="font-weight: 600">{{ selectedRowKeys.length }}</a>项
        <a style="margin-left: 24px" @click="onClearSelected">清空</a>
      </div>

      <a-table
        ref="table"
        size="middle"
        bordered
        rowKey="id"
        class="j-table-force-nowrap"
        :scroll="{x:true}"
        :columns="columns"
        :dataSource="dataSource"
        :pagination="ipagination"
        :loading="loading"
        :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
        @change="handleTableChange">

        <template slot="htmlSlot" slot-scope="text">
          <div v-html="text"></div>
        </template>
        <template slot="imgSlot" slot-scope="text">
          <span v-if="!text" style="font-size: 12px;font-style: italic;">无图片</span>
          <img v-else :src="getImgView(text)" height="25px" alt="" style="max-width:80px;font-size: 12px;font-style: italic;"/>
        </template>
        <template slot="fileSlot" slot-scope="text">
          <span v-if="!text" style="font-size: 12px;font-style: italic;">无文件</span>
          <a-button
            v-else
            :ghost="true"
            type="primary"
            icon="download"
            size="small"
            @click="downloadFile(text)">
            下载
          </a-button>
        </template>

        <span slot="action" slot-scope="text, record">
          <a @click="handleEdit(record)">编辑</a>

          <a-divider type="vertical" />
          <a-dropdown>
            <a class="ant-dropdown-link">更多 <a-icon type="down" /></a>
            <a-menu slot="overlay">
              <a-menu-item>
                <a @click="handleDetail(record)">详情</a>
              </a-menu-item>
              <a-menu-item>
                <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
                  <a>删除</a>
                </a-popconfirm>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </span>

      </a-table>
    </div>

    <sal-odrm-modal ref="modalForm" @ok="modalFormOk"/>
  </a-card>
</template>

<script>

  import { JeecgListMixin } from '@/mixins/JeecgListMixin'
  import SalOdrmModal from './modules/SalOdrmModal'
  import '@/assets/less/TableExpand.less'

  export default {
    name: "SalOdrmList",
    mixins:[JeecgListMixin],
    components: {
      SalOdrmModal
    },
    data () {
      return {
        description: '订单表管理页面',
        // 表头
        columns: [
          {
            title: '#',
            dataIndex: '',
            key:'rowIndex',
            width:60,
            align:"center",
            customRender:function (t,r,index) {
              return parseInt(index)+1;
            }
          },
          {
            title:'orderNumber',
            align:"center",
            dataIndex: 'orderNumber'
          },
          {
            title:'fkagentid',
            align:"center",
            dataIndex: 'fkagentid'
          },
          {
            title:'orderSource',
            align:"center",
            dataIndex: 'orderSource'
          },
          {
            title:'salesman',
            align:"center",
            dataIndex: 'salesman'
          },
          {
            title:'orderInfo',
            align:"center",
            dataIndex: 'orderInfo'
          },
          {
            title:'cnee',
            align:"center",
            dataIndex: 'cnee'
          },
          {
            title:'tel',
            align:"center",
            dataIndex: 'tel'
          },
          {
            title:'fullAddress',
            align:"center",
            dataIndex: 'fullAddress'
          },
          {
            title:'city',
            align:"center",
            dataIndex: 'city'
          },
          {
            title:'province',
            align:"center",
            dataIndex: 'province'
          },
          {
            title:'region',
            align:"center",
            dataIndex: 'region'
          },
          {
            title:'customerCode',
            align:"center",
            dataIndex: 'customerCode'
          },
          {
            title:'address',
            align:"center",
            dataIndex: 'address'
          },
          {
            title:'orderAmt',
            align:"center",
            dataIndex: 'orderAmt'
          },
          {
            title:'req',
            align:"center",
            dataIndex: 'req'
          },
          {
            title:'orderDate',
            align:"center",
            dataIndex: 'orderDate',
            customRender:function (text) {
              return !text?"":(text.length>10?text.substr(0,10):text)
            }
          },
          {
            title:'txType',
            align:"center",
            dataIndex: 'txType'
          },
          {
            title:'sellDate',
            align:"center",
            dataIndex: 'sellDate',
            customRender:function (text) {
              return !text?"":(text.length>10?text.substr(0,10):text)
            }
          },
          {
            title:'fcurrency',
            align:"center",
            dataIndex: 'fcurrency'
          },
          {
            title:'customerOrderNumber',
            align:"center",
            dataIndex: 'customerOrderNumber'
          },
          {
            title:'fkexpressid',
            align:"center",
            dataIndex: 'fkexpressid'
          },
          {
            title:'frecstat',
            align:"center",
            dataIndex: 'frecstat'
          },
          {
            title:'file1',
            align:"center",
            dataIndex: 'file1'
          },
          {
            title:'file2',
            align:"center",
            dataIndex: 'file2'
          },
          {
            title: '操作',
            dataIndex: 'action',
            align:"center",
            fixed:"right",
            width:147,
            scopedSlots: { customRender: 'action' },
          }
        ],
        url: {
          list: "/orderform/salOdrm/list",
          delete: "/orderform/salOdrm/delete",
          deleteBatch: "/orderform/salOdrm/deleteBatch",
          exportXlsUrl: "/orderform/salOdrm/exportXls",
          importExcelUrl: "orderform/salOdrm/importExcel",
          
        },
        dictOptions:{},
        superFieldList:[],
      }
    },
    created() {
      this.getSuperFieldList();
    },
    computed: {
      importExcelUrl: function(){
        return `${window._CONFIG['domianURL']}/${this.url.importExcelUrl}`;
      }
    },
    methods: {
      initDictConfig(){
      },
      getSuperFieldList(){
        let fieldList=[];
         fieldList.push({type:'string',value:'orderNumber',text:'orderNumber',dictCode:''})
         fieldList.push({type:'string',value:'fkagentid',text:'fkagentid',dictCode:''})
         fieldList.push({type:'string',value:'orderSource',text:'orderSource',dictCode:''})
         fieldList.push({type:'string',value:'salesman',text:'salesman',dictCode:''})
         fieldList.push({type:'string',value:'orderInfo',text:'orderInfo',dictCode:''})
         fieldList.push({type:'string',value:'cnee',text:'cnee',dictCode:''})
         fieldList.push({type:'string',value:'tel',text:'tel',dictCode:''})
         fieldList.push({type:'string',value:'fullAddress',text:'fullAddress',dictCode:''})
         fieldList.push({type:'string',value:'city',text:'city',dictCode:''})
         fieldList.push({type:'string',value:'province',text:'province',dictCode:''})
         fieldList.push({type:'string',value:'region',text:'region',dictCode:''})
         fieldList.push({type:'string',value:'customerCode',text:'customerCode',dictCode:''})
         fieldList.push({type:'string',value:'address',text:'address',dictCode:''})
         fieldList.push({type:'BigDecimal',value:'orderAmt',text:'orderAmt',dictCode:''})
         fieldList.push({type:'string',value:'req',text:'req',dictCode:''})
         fieldList.push({type:'date',value:'orderDate',text:'orderDate'})
         fieldList.push({type:'string',value:'txType',text:'txType',dictCode:''})
         fieldList.push({type:'date',value:'sellDate',text:'sellDate'})
         fieldList.push({type:'string',value:'fcurrency',text:'fcurrency',dictCode:''})
         fieldList.push({type:'string',value:'customerOrderNumber',text:'customerOrderNumber',dictCode:''})
         fieldList.push({type:'string',value:'fkexpressid',text:'fkexpressid',dictCode:''})
         fieldList.push({type:'string',value:'frecstat',text:'frecstat',dictCode:''})
         fieldList.push({type:'string',value:'file1',text:'file1',dictCode:''})
         fieldList.push({type:'string',value:'file2',text:'file2',dictCode:''})
        this.superFieldList = fieldList
      }
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less';
</style>