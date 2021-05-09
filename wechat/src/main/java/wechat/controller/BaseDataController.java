package wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wechat.mbg.entity.*;
import wechat.mbg.service.*;
import wechat.utils.FileUploadUtils;
import wechat.utils.GlobalResult;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName BaseDataController.java
 * @date 2020/11/28 21:06
 * @Description
 * @Content:
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/baseData")
@Api(tags = "获取基础数据")
public class BaseDataController {
    @Value("${file.uploadurl}")
    private String uploadPath;
    @Autowired
    private ScriptBackgroundLibraryService scriptBackgroundLibraryService;
    @Autowired
    private ScriptDifficultyLibraryService scriptDifficultyLibraryService;
    @Autowired
    private ScriptFormLibraryService scriptFormLibraryService;
    @Autowired
    private ScriptThemeLibraryService scriptThemeLibraryService;
    @Autowired
    private ScriptTypeLibraryService scriptTypeLibraryService;
    @PostMapping("/fileUpLoad")
    @ApiOperation("上传文件接口")
    public GlobalResult fileUpLoad(MultipartFile file) {
        //上传后获取上传存放的物理物理路径给前端
        Map<String, Object> upload = FileUploadUtils.upload(file);
        return GlobalResult.ok(upload);
    }
    @PostMapping("/fileUploadNew")
    @ApiOperation(value = "新上传下载图片")
    public GlobalResult filesUpload(MultipartFile file) throws IOException {

        GlobalResult result = new GlobalResult();
        //如果文件夹不存在，创建
        File fileP = new File(uploadPath);

        if (!fileP.isDirectory()) {
            //递归生成文件夹
            fileP.mkdirs();
        }
        String fileName = "";
        if(file.getOriginalFilename().endsWith(".jpg")){
            fileName =String.format("%s.jpg",System.currentTimeMillis());
        }else if(file.getOriginalFilename().endsWith(".png")){
            fileName =String.format("%s.jpg",System.currentTimeMillis());
        }else if(file.getOriginalFilename().endsWith(".jpeg")){
            fileName =String.format("%s.jpeg",System.currentTimeMillis());
        }else if(file.getOriginalFilename().endsWith(".bmp")){
            fileName =String.format("%s.bmp",System.currentTimeMillis());
        }else{
            result.setMsg("图片格式不正确！，使用.jpg/.png/.bpm/.jpeg后缀的图片");
            return result;
        }
        file.transferTo(new File(fileP,fileName));
        //数据库存入地址
        HashMap<String, Object> map = new HashMap<>();
        map.put("url",uploadPath+fileName);
        map.put("fileName",fileName);
        result.setData(map);
        return result;
    }
    @GetMapping("/getScriptBackgroundLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptBackgroundLibrary() {
        List<ScriptBackgroundLibrary> scriptBackgroundLibraryServiceAll = scriptBackgroundLibraryService.list();
        return GlobalResult.ok(scriptBackgroundLibraryServiceAll);
    }

    @GetMapping("/getScriptDifficultyLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptDifficultyLibrary() {
        List<ScriptDifficultyLibrary> scriptDifficultyLibraryList = scriptDifficultyLibraryService.list();
        return GlobalResult.ok(scriptDifficultyLibraryList);
    }

    @GetMapping("/getScriptFormLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptFormLibrary() {
        List<ScriptFormLibrary> scriptFormLibraryList = scriptFormLibraryService.list();
        return GlobalResult.ok(scriptFormLibraryList);
    }

    @GetMapping("/getScriptThemeLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptThemeLibrary() {
        List<ScriptThemeLibrary> scriptThemeLibraryList = scriptThemeLibraryService.list();
        return GlobalResult.ok(scriptThemeLibraryList);
    }

    @GetMapping("/getScriptTypeLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptTypeLibrary() {
        List<ScriptTypeLibrary> scriptTypeLibraryList = scriptTypeLibraryService.list();
        return GlobalResult.ok(scriptTypeLibraryList);
    }
}
