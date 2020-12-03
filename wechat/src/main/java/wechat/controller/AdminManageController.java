package wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wechat.mbg.entity.MemberInfo;
import wechat.mbg.service.*;
import wechat.utils.GlobalResult;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;

import java.util.List;

/**
 * <description>
 *
 * </description>
 *
 * @author YYang
 * @version 1.0
 * @date 2020/12/3 9:07
 */
@RestController
@CrossOrigin
@Api("管理后台-后台管理")
@RequestMapping("/admin/manage")
public class AdminManageController {
    @Autowired
    private UserService userService;

    @Autowired
    private ConsumptionSettlementService consumptionSettlementService;

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private DramaLibraryService dramaLibraryService;

    @PostMapping("/showWeChatUsers")
    @ApiOperation("列表微信用户展示")
    public GlobalResult showWeChatUsers(@RequestBody PageRequest pageRequest){
        PageResult pageResult =userService.showWeChatUsers(pageRequest);
        return GlobalResult.ok(pageResult);
    }

    @PostMapping("/showIntegralAndConsumptionInfo")
    @ApiOperation("列表根据用户openid显示积分记录和消费记录")
    public GlobalResult showIntegralAndConsumptionById(@RequestBody PageRequest pageRequest,@RequestParam("openId")String openId){
        PageResult pageResult =consumptionSettlementService.showIntegralAndConsumptionByIdInfo(pageRequest,openId);
        return GlobalResult.ok(pageResult);
    }

    @PostMapping("/showRechargeById")
    @ApiOperation("列表根据用户openid显示充值详情")
    public GlobalResult showRechargeById(@RequestBody PageRequest pageRequest,@RequestParam("openId")String openId){
        PageResult pageResult =rechargeRecordService.showRechargeByIdInfo(pageRequest,openId);
        return GlobalResult.ok(pageResult);
    }

    @PostMapping("/showCouponInfo")
    @ApiOperation("列表显示优惠券")
    public GlobalResult showCoupons(@RequestBody PageRequest pageRequest){
        PageResult pageResult =couponService.showCoupons(pageRequest);
        return GlobalResult.ok(pageResult);
    }

    @GetMapping("/showMemberInfoById")
    @ApiOperation("根据用户openid获得积分总额,余额,充值总额,充值会员级别,游戏次数会员级别等等")
    public GlobalResult showMemberInfoById(@RequestParam("openId")String openId){
        MemberInfo memberInfo =memberInfoService.showMemberInfoById(openId);
        return GlobalResult.ok(memberInfo);
    }

    @PostMapping("/showConsumptionInfo")
    @ApiOperation("列表显示消费记录")
    public GlobalResult showConsumptionInfo(@RequestBody PageRequest pageRequest){
        PageResult pageResult =consumptionSettlementService.showConsumptionInfo(pageRequest);
        return GlobalResult.ok(pageResult);
    }

    @PostMapping("/showRechargeInfo")
    @ApiOperation("列表显示充值记录")
    public GlobalResult showRechargeInfo(@RequestBody PageRequest pageRequest){
        PageResult pageResult =rechargeRecordService.showRechargeInfo(pageRequest);
        return GlobalResult.ok(pageResult);
    }

    @PostMapping("/showTopTenMemebers")
    @ApiOperation("获取前10充值排行玩家")
    public GlobalResult showTopTenMemebers(){
        List<MemberInfo> memberInfoList =memberInfoService.showTopTenMemebers();
        return GlobalResult.ok(memberInfoList);
    }

    @PostMapping("/showTopTenScripts")
    @ApiOperation("获取前10充值排行剧本")
    public GlobalResult showTopTenScripts(){
        List<MemberInfo> memberInfoList =dramaLibraryService.showTopTenScripts();
        return GlobalResult.ok(memberInfoList);
    }

}
