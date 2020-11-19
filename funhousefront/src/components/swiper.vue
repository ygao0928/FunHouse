<template>
  <swiper class="swiper" :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
    <block  v-for="(item, index) in images" :key="index">
      <swiper-item style="height: 100px">
        <image :src="item.url" class="slide-image"/>
      </swiper-item>
    </block >
  </swiper>
</template>

<script>
export default {
  name: "carrousel",
  components: {},
  props: {
    images: {
      type: Array
    }
  },
  data() {
    return {
      indicatorDots: true,
      autoplay: true,
      interval: 3000,
      duration: 500
    };
  },
//监听属性 类似于data概念",
  computed: {},
//监控data中的数据变化",
  watch: {},
//方法集合",
  methods: {},
//生命周期 - 创建之前",数据模型未加载,方法未加载,html模板未加载
  beforeCreate() {
  },
//生命周期 - 创建完成（可以访问当前this实例）",数据模型已加载，方法已加载,html模板已加载,html模板未渲染
  created() {
  },
//生命周期 - 挂载之前",html模板未渲染
  beforeMount() {
  },
//生命周期 - 挂载完成（可以访问DOM元素）",html模板已渲染
  mounted() {
  },
//生命周期 - 更新之前",数据模型已更新,html模板未更新
  beforeUpdate() {
  },
//生命周期 - 更新之后",数据模型已更新,html模板已更新
  updated() {
  },
//生命周期 - 销毁之前",
  beforeDestroy() {
  },
//生命周期 - 销毁完成",
  destroyed() {
  },
//如果页面有keep-alive缓存功能，这个函数会触发",
  activated() {
  },
}
</script>

<style scoped>
.swiper {
  height: 376rpx !important;
}

image {
  height: 100%;
  width: 100%;
}
.slide-image {
  width: 100%;
  height: 100%;
}
</style>
