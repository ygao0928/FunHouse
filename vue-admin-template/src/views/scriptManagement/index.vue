<template>
  <div class="app-container">
    <div>
      <el-input style="width: 20%" v-model="Pagination.key" placeholder="请输入剧本名称"></el-input>
      <el-button type="primary" icon="el-icon-search">搜索</el-button>
      <el-button @click="addScript">新增剧本</el-button>
    </div>

    <div style="margin-top: 20px">
      <el-table
        max-height="650"
        height="650"
        :data="tableData_script"
        style="width: 100%;">
        <el-table-column
          type="index"
          label="序号"
          width="180"
          align="center">
        </el-table-column>
        <el-table-column
          prop="dramaName"
          label="剧本名称" align="center"
          width="180">
        </el-table-column>
        <el-table-column
          prop="scriptType" align="center"
          label="剧本类型">
        </el-table-column>
        <el-table-column
          prop="price" align="center"
          label="价格(元)">
        </el-table-column>
        <el-table-column
          prop="creationDate" align="center"
          label="创建时间">
        </el-table-column>
        <el-table-column
          prop="address" align="center"
          label="热度">
        </el-table-column>
        <el-table-column
          prop="statue" align="center"
          label="状态">
        </el-table-column>
        <el-table-column
          prop="address" align="center"
          label="操作">
        </el-table-column>
      </el-table>
    </div>
    <div class="foot_pagination">
      <el-pagination
        background
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
    <el-dialog
      title="新增剧本"
      :visible.sync="dialogVisible_addScript"
      width="45%">
      <el-form :inline="true" :label-position="labelPosition" label-width="80px" :model="scriptForm">
        <el-form-item label="剧本名称">
          <el-input v-model.trim="scriptForm.dramaName"></el-input>
        </el-form-item>
        <el-form-item label="剧本形式">
          <el-select value-key="id" v-model="FormSec" placeholder="请选择" @change="handleChangeForm">
            <el-option
              v-for="item in options_FormLibrary"
              :key="item.id"
              :label="item.scriptForm"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="剧本难度">
          <el-select value-key="id" v-model="DifficultySec" placeholder="请选择"
                     @change="handleChangeDifficulty">
            <el-option
              v-for="item in options_DifficultyLibrary"
              :key="item.id"
              :label="item.degreeDifficulty"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="剧本背景">
          <el-select value-key="id" v-model="BackgroundSec" placeholder="请选择"
                     @change="handleChangeBackground">
            <el-option
              v-for="item in options_BackgroundLibrary"
              :key="item.id"
              :label="item.scriptBackground"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="剧本类型">
          <el-select value-key="id" v-model="TypeSec" placeholder="请选择" @change="handleChangeType">
            <el-option
              v-for="item in options_TypeLibrary"
              :key="item.id"
              :label="item.scriptType"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="剧本剧情">
          <el-select value-key="id" v-model="ThemeSec" placeholder="请选择" @change="handleChangeTheme">
            <el-option
              v-for="item in options_ThemeLibrary"
              :key="item.id"
              :label="item.scriptTheme"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model.number="scriptForm.price"></el-input>
        </el-form-item>
        <el-form-item label="人数要求">
          <el-input v-model="scriptForm.numberRequire"></el-input>
        </el-form-item>
        <el-form-item label="公众号Link">
          <el-input v-model="scriptForm.publicLink"></el-input>
        </el-form-item>
        <el-form-item label="剧本简介">
          <el-input v-model="scriptForm.dramaIntroduction"></el-input>
        </el-form-item>
        <br>
        <el-form-item label="剧本图片">
          <el-upload
            :action="fileUpload" list-type="picture-card" :limit="2"
            :show-file-list="false"
            :on-success="function (res, file) { return handleUpLoadSuccess(res, file)}"
            :before-upload="beforeImageUpload"
            :file-list="fileList"
          >
            <el-image v-if="imgPath" :src="'/api'+imgPath"></el-image>
            <i v-else class="el-icon-plus"></i>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible_addScript = false">取 消</el-button>
    <el-button type="primary" @click="addScriptConfirm">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>
<script>
import {
  getList,
  getScriptBackgroundLibrary,
  getScriptDifficultyLibrary,
  getScriptFormLibrary,
  getScriptThemeLibrary,
  getScriptTypeLibrary,
  addScriptFrom
} from '@/api/scripts'
import { mapGetters } from 'vuex'

export default {
  name: 'index',
  components: {},
  data() {
    return {

      ThemeSec: '',
      TypeSec: '',
      BackgroundSec: '',
      DifficultySec: '',
      FormSec: '',
      imgPath: '',
      fileList: [],
      options_TypeLibrary: [],
      options_ThemeLibrary: [],
      options_FormLibrary: [],
      options_DifficultyLibrary: [],
      options_BackgroundLibrary: [],
      labelPosition: 'right',
      Pagination: { key: '', },
      dialogVisible_addScript: false,
      scriptForm: {
        id: null,
        dramaName: '',
        scriptForm: '',
        scriptDifficulty: '',
        scriptBackground: '',
        scriptType: '',
        scriptTheme: '',
        dramaIntroduction: '',
        dramaImage: '',
        price: 0,
        numberRequire: 0,
        publicLink: ''
      },
      tableData_script: []
    }
  },
//监听属性 类似于data概念",
  computed: {
    ...mapGetters(['fileUpload'])
  },
//监控data中的数据变化",
  watch: {},
//方法集合",
  methods: {
    beforeImageUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2
      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    handleUpLoadSuccess(res, file) {
      this.fileList = []
      console.log(this.fileList)
      this.fileList.push({ name: res.data.name, url: res.data.url })
      this.imgPath = res.data.url
      console.log(this.fileList1)
    },
    addScriptConfirm() {
      this.scriptForm.dramaImage = JSON.stringify(this.fileList).toString()

      addScriptFrom(this.scriptForm).then(res => {
        console.log(res.data)
      })
      this.dialogVisible_addScript = false
    },
    handleChangeForm(e) {
      console.log(e)
      this.scriptForm.scriptForm = e.id
    },
    handleChangeDifficulty(e) {
      this.scriptForm.scriptDifficulty = e.id
    },
    handleChangeBackground(e) {
      this.scriptForm.scriptBackground = e.id
    },
    handleChangeType(e) {
      this.scriptForm.scriptType = e.id
    },
    handleChangeTheme(e) {
      this.scriptForm.scriptTheme = e.id
    },
    addScript() {
      this.getScriptBackgroundLibrary()
      this.getScriptDifficultyLibrary()
      this.getScriptFormLibrary()
      this.getScriptThemeLibrary()
      this.getScriptTypeLibrary()
      // this.$router.push({ path:"/scriptManagement/detail", query: { id: 1 }})
      this.dialogVisible_addScript = true
    },
    getScriptBackgroundLibrary() {
      getScriptBackgroundLibrary().then(res => {
        this.options_BackgroundLibrary = res.data
        console.log(res.data)
      })
    },
    getScriptDifficultyLibrary() {
      getScriptDifficultyLibrary().then(res => {
        this.options_DifficultyLibrary = res.data
        console.log(res.data)
      })
    },
    getScriptFormLibrary() {
      getScriptFormLibrary().then(res => {
        this.options_FormLibrary = res.data
        console.log(res.data)
      })
    },
    getScriptThemeLibrary() {
      getScriptThemeLibrary().then(res => {
        this.options_ThemeLibrary = res.data
        console.log(res.data)
      })
    },
    getScriptTypeLibrary() {
      getScriptTypeLibrary().then(res => {
        this.options_TypeLibrary = res.data
        console.log(res.data)
      })
    },
    onSubmit() {
    },
    getList() {
      getList().then(res => {
        const { data } = res
        console.log(data)
        this.tableData_script = data
      })
    }
  },
//生命周期 - 创建之前",数据模型未加载,方法未加载,html模板未加载
  beforeCreate() {
  },
//生命周期 - 创建完成（可以访问当前this实例）",数据模型已加载，方法已加载,html模板已加载,html模板未渲染
  created() {
    this.getList()
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
  }
}
</script>

<style scoped>
.container {

}
.foot_pagination{
  display: flex;
  justify-content:center;
}
</style>
