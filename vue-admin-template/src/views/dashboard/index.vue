<template>
  <div class="dashboard-container">
    <div class="dashboard-text">欢迎: {{ name }}</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  data(){
    return{
      name:'',
    }
  },
  computed: {
    ...mapGetters([
      /*'name'*/
    ])
  },
  created() {
    let userInfo = JSON.parse(localStorage.getItem("userInfo"));
    this.name=userInfo.userName
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
