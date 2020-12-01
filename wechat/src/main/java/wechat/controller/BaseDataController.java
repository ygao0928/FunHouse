package wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wechat.mbg.entity.*;
import wechat.mbg.service.*;
import wechat.utils.FileUploadUtils;
import wechat.utils.GlobalResult;

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
@Api("获取基础数据")
public class BaseDataController {
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
    @GetMapping("/getScriptBackgroundLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptBackgroundLibrary() {
        List<ScriptBackgroundLibrary> scriptBackgroundLibraryServiceAll = scriptBackgroundLibraryService.getAll();
        return GlobalResult.ok(scriptBackgroundLibraryServiceAll);
    }

    @GetMapping("/getScriptDifficultyLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptDifficultyLibrary() {
        List<ScriptDifficultyLibrary> scriptDifficultyLibraryList = scriptDifficultyLibraryService.getAll();
        return GlobalResult.ok(scriptDifficultyLibraryList);
    }

    @GetMapping("/getScriptFormLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptFormLibrary() {
        List<ScriptFormLibrary> scriptFormLibraryList = scriptFormLibraryService.getAll();
        return GlobalResult.ok(scriptFormLibraryList);
    }

    @GetMapping("/getScriptThemeLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptThemeLibrary() {
        List<ScriptThemeLibrary> scriptThemeLibraryList = scriptThemeLibraryService.getAll();
        return GlobalResult.ok(scriptThemeLibraryList);
    }

    @GetMapping("/getScriptTypeLibrary")
    @ApiOperation("获取剧本背景库数据")
    public GlobalResult getScriptTypeLibrary() {
        List<ScriptTypeLibrary> scriptTypeLibraryList = scriptTypeLibraryService.getAll();
        return GlobalResult.ok(scriptTypeLibraryList);
    }
}
