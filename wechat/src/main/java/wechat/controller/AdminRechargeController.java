package wechat.controller;

import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.entity.RechargeRecord;
import wechat.mbg.service.RechargeRecordService;
import wechat.utils.GlobalResult;

import java.util.Map;

/**
 * <description>
 *
 * </description>
 *
 * @author YYang
 * @version 1.0
 * @date 2020/12/3 11:14
 */
@RestController
@CrossOrigin
@Api("管理后台-后台管理充值")
@RequestMapping("/admin/recharge")
public class AdminRechargeController {
    @Autowired
    private RechargeRecordService rechargeRecordService;

    @PostMapping("/addRecharge")
    @ApiOperation("新增充值")
    public GlobalResult addRecharge(@RequestBody RechargeRecord rechargeRecord) {
        Map<String,Object> map = rechargeRecordService.addRecharge(rechargeRecord);
        GlobalResult result = new GlobalResult();
        result.setData(map);
        result.setMsg("操作成功");
        result.setStatus(200);
        return result;
    }

}
