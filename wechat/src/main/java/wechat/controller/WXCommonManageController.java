package wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wechat.mbg.entity.ConsumptionLog;
import wechat.mbg.entity.DramaPlayedLog;
import wechat.mbg.service.DramaPlayedLogService;
import wechat.service.WXCommonService;
import wechat.utils.GlobalResult;

import java.util.List;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName WXCommonManageController.java
 * @date 2020/12/13 16:25
 * @Description 微信用户的
 * @Content:
 */
@RestController
@RequestMapping("/wx/user")
@Api(tags = "微信用户的所有的操作/除登录")
public class WXCommonManageController {
    @Autowired
    private WXCommonService wxCommonService;
    @Autowired
    private DramaPlayedLogService playedLogService;

    @GetMapping("/generatorConsumption")
    @ApiOperation("微信-用户买单")
    public GlobalResult generatorConsumption(@RequestParam("phone") String phone, @RequestParam("money") Integer money) {
        if (ObjectUtils.isEmpty(phone)) {
            return GlobalResult.errorMsg("请重新设置手机号码");
        }
        if (money==0) {
            return GlobalResult.ok("重新输入");
        }
        String res = wxCommonService.generatorConsumption(phone, money);
        return GlobalResult.ok(res);
    }

    @ApiOperation("获取所有的消费记录")
    @GetMapping("/getAllConsumption")
    public GlobalResult getAllConsumption(@RequestParam("openId") String openId) {
      List<ConsumptionLog> consumptionLogs= wxCommonService.getAllConsumption(openId);
      return GlobalResult.ok(consumptionLogs);
    }
    @ApiOperation("获取所有玩本记录")
    @GetMapping("/getOwnPlayed")
    public GlobalResult getOwnPlayed(@RequestParam("openId") String openId) {
        List<DramaPlayedLog> played = playedLogService.getOwnPlayed(openId);
        return GlobalResult.ok(played);
    }
}
