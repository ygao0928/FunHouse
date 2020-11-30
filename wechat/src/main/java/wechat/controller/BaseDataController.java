package wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wechat.mbg.entity.*;
import wechat.mbg.service.*;
import wechat.utils.GlobalResult;

import java.util.List;

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
