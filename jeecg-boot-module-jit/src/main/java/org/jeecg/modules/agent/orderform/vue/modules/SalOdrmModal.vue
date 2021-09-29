<template>
  <j-modal
    :title="title"
    :width="1200"
    :visible="visible"
    :maskClosable="false"
    switchFullscreen
    @ok="handleOk"
    :okButtonProps="{ class:{'jee-hidden': disableSubmit} }"
    @cancel="handleCancel">
    <sal-odrm-form ref="realForm" @ok="submitCallback" :disabled="disableSubmit"/>
  </j-modal>
</template>

<script>

  import SalOdrmForm from './SalOdrmForm'

  export default {
    name: 'SalOdrmModal',
    components: {
      SalOdrmForm
    },
    data() {
      return {
        title:'',
        width:800,
        visible: false,
        disableSubmit: false
      }
    },
    methods:{
      add () {
        this.visible=true
        this.$nextTick(()=>{
          this.$refs.realForm.add();
        })
      },
      edit (record) {
        this.visible=true
        this.$nextTick(()=>{
          this.$refs.realForm.edit(record);
        })
      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        this.$refs.realForm.handleOk();
      },
      submitCallback(){
        this.$emit('ok');
        this.visible = false;
      },
      handleCancel () {
        this.close()
      }
    }
  }
</script>

<style scoped>
</style>