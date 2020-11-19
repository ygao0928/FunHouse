<template>
  <div class="container">
    <div style="height: 38%">
      <Swiper :images="images"/>
      <div class="search">
        <van-search @search="onSearch" @change="handleSearchChange" :value="value_search" placeholder="请输入要搜索的剧本名称"/>
      </div>
    </div>

    <div class="main" style="border-top: 10rpx solid rgb(245, 246, 247)">
      <van-tree-select
        height="100%"
        :items="items"
        :active-id="activeId"
        :main-active-index="activeIndex"
        @click="onNavClick"
      >
        <template slot="content">
          <!--<van-image v-if="active === 0" src="https://kevingao-blog.oss-cn-shanghai.aliyuncs.com/20200709141008.jpg"
                     rel="external nofollow"/>
          <van-image v-if="active === 1"
                     src="https://img-oss.yunshanmeicai.com/goods/default/e83c8f0f-4acc-4729-bcbb-294f2b314977.jpg"
                     rel="external nofollow"/>-->
          <ul class="right-content">
            <li v-for="(item,index) in scriptList"
                :key="index"
                @click=""> {{item.name}} </li>
          </ul>
        </template>
      </van-tree-select>
    </div>
  </div>

</template>
<script>
import Swiper from "@/components/swiper"

export default {
  data() {
    return {
      scriptList:[{id:1,name:"test1"},{id:1,name:"test1"},{id:1,name:"test1"},{id:1,name:"test1"}],//剧本list
      /*===============树形选择========================*/
      activeId: 1,
      activeIndex: 0,
      items: [
        { text: '日结'},
        { text: '周结'}
        ],
      /*===================搜索==============================*/
      value_search: "",
      images: [
        {
          url:
            "https://kevingao-blog.oss-cn-shanghai.aliyuncs.com/20200709141008.jpg"
        },
        {
          url:
            "https://img-oss.yunshanmeicai.com/goods/default/e83c8f0f-4acc-4729-bcbb-294f2b314977.jpg"
        }
      ]
    }
  },

  components: {
    Swiper
  },

  methods: {
    handleSearchChange(event) {
    this.value_search=  event.mp.detail

    },
    onSearch(){
      console.log(this.value_search)
    },
    onItemClick(data){
      console.log(data)
      //this.$router.push({path:'/job'+data.id})
    },
    bindGetUserInfo(e) {
      console.log(e)
    },
    onNavClick(index){
      console.log(232323)
      for (let i=0;i<=3;i++){
        let aa={
          id:index,name:"test"+index
        }
        this.scriptList.push(aa)
      }

console.log(this.scriptList)
    }
  },

  created() {
    // let app = getApp()
  }
}
</script>
<style>
page {
  height: 100%
}
</style>
<style scoped>
.divider001 {
  height: 35 rpx;
}

.search {
  height: 100 rpx;
}

.main {
  height: 65%;
}

page {
  height: 100%;
}

.container {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
}
</style>
