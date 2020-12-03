package wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.entity.MemberInfo;
import wechat.mbg.mapper.ConsumptionSettlementMapper;
import wechat.mbg.service.*;
import wechat.utils.GlobalResult;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;

import java.util.List;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName ScrptsManage.java
 * @date 2020/11/25 21:48
 * @Description
 * @Content:
 */
@RestController
@CrossOrigin
@Api("管理后台-剧本管理")
@RequestMapping("/admin/scripts")
public class AdminScriptsManage {
    @Autowired
    private DramaLibraryService dramaLibraryService;

    @PostMapping("/getList")
    @ApiOperation("获取剧本的列表")
    public GlobalResult getList(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "10") int pageSize,
                                 String key) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(dramaLibraryService.getAll(key));
        return GlobalResult.ok(pageInfo);
    }

    @PostMapping("/addDrama")
    @ApiOperation("新增剧本")
    public GlobalResult addDramaLibraries(@RequestBody DramaLibrary dramaLibrary) {
        Boolean flag = dramaLibraryService.addDrama(dramaLibrary);
        GlobalResult result = new GlobalResult();
        result.setMsg("操作成功");
        result.setStatus(200);
        return result;
    }

}
