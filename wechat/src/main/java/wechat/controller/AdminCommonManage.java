package wechat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wechat.mbg.entity.Coupon;
import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.entity.User;
import wechat.mbg.entity.UserCouponRelation;
import wechat.mbg.service.*;
import wechat.utils.GlobalResult;
import wechat.vo.CouponParam;
import wechat.vo.SearchConditionParam;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/admin")
public class AdminCommonManage {
    @Autowired
    private DramaLibraryService dramaLibraryService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private RechargeRecordService recordService;
    @Autowired
    private DramaPlayedLogService playedLogService;
    @Autowired
    private UserService userService;

    @PostMapping("/scripts/getList")
    @ApiOperation("获取剧本的列表")
    public GlobalResult getList(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "10") int pageSize,
                                String key,
                                @RequestBody SearchConditionParam conditionParam) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(dramaLibraryService.getAll(key, conditionParam.getFromId(), conditionParam.getDiffId(), conditionParam.getNumberRe(), conditionParam.getBackId(), conditionParam.getTypeId()));
        return GlobalResult.ok(pageInfo);
    }

    @GetMapping("/scripts/getByName")
    public GlobalResult getByName(@RequestParam("name") String name) {
        List<DramaLibrary> dramaLibrary = dramaLibraryService.getByName(name);
        return GlobalResult.ok(dramaLibrary);
    }

    @PostMapping("/scripts/addDrama")
    @ApiOperation("新增剧本")
    public GlobalResult addDramaLibraries(@RequestBody DramaLibrary dramaLibrary) {
        Boolean flag = dramaLibraryService.addDrama(dramaLibrary);
        GlobalResult result = new GlobalResult();
        result.setMsg("操作成功");
        result.setStatus(200);
        return result;
    }

    @GetMapping("/scripts/getDramaDetail")
    @ApiOperation("获取剧本详情")
    public GlobalResult getDramaDetail(@RequestParam("id") Integer id) {
        DramaLibrary detail = dramaLibraryService.getDramaDetailById(id);
        return GlobalResult.ok(detail);
    }

    @PostMapping("/scripts/updateDrama")
    @ApiOperation("更新剧本")
    public GlobalResult updateDrama(@RequestBody DramaLibrary dramaLibrary) {
        String res = dramaLibraryService.updateDrama(dramaLibrary);
        return GlobalResult.ok(res);
    }

    @GetMapping("/scripts/delete")
    @ApiOperation("删除剧本")
    public GlobalResult deleteDrama(@RequestParam("id") Integer id) {
        String res = dramaLibraryService.deleteDrama(id);
        return GlobalResult.ok(res);
    }

    @PostMapping("/coupon/add")
    @ApiOperation("新增优惠券")
    public GlobalResult addCoupon(@RequestBody CouponParam couponParam) {
        Boolean result = couponService.insert(couponParam);
        return GlobalResult.ok(result);
    }

    @PostMapping("/coupon/distribution")
    @ApiOperation("分配优惠券")
    public GlobalResult distribution(@RequestBody Map map) {
        String phone = (String) map.get("phone");
        List<Integer> ids = (List<Integer>) map.get("ids");
        Boolean res = couponService.distribution(phone, ids);
        return GlobalResult.ok(res);
    }

    @GetMapping("/coupon/getAllUser")
    @ApiOperation("获取用户名下所有可用的优惠券")
    public GlobalResult getAllUser(@RequestParam("openId") String openId) {
        List<Coupon> couponList = couponService.getAllUser(openId);
        return GlobalResult.ok(couponList);
    }

    @GetMapping("/coupon/getAll")
    @ApiOperation("获取所有的优惠券模板")
    public GlobalResult getAll() {
        return GlobalResult.ok(couponService.getAll());
    }

    @GetMapping("/coupon/deleteById")
    @ApiOperation("删除优惠券")
    public GlobalResult deleteById(@RequestParam("id") Integer id) {
        Boolean res = couponService.deleteById(id);
        return GlobalResult.ok(res);
    }

    @GetMapping("/user/userRecharge")
    @ApiOperation("后台充值接口")
    public GlobalResult userRecharge(@RequestParam("phone") String phone, @RequestParam("money") Integer money) {
        if (money == null || money == 0) {
            return GlobalResult.errorMsg("充值金额不能为0");
        }
        Boolean res = recordService.insert(phone, money);
        return GlobalResult.ok(res);
    }

    @GetMapping("/consumption/generatorConsumption")
    @ApiOperation("后台生成消费记录")
    public GlobalResult generatorConsumption(@RequestParam("phone") String phone,
                                             @RequestParam("money") Integer money,
                                             @ApiParam("1 ：线上支付 2 ：线下支付")
                                             @RequestParam("payMethod") Integer payMethod,
                                             @RequestParam("ids") List<Integer> ids) {
        String res = recordService.generatorConsumption(phone, money, payMethod, ids);
        return GlobalResult.ok(res);
    }

    @PostMapping("/scripts/addOwnPlayed")
    @ApiOperation("新增用户玩的剧本")
    public GlobalResult addOwnPlayed(@RequestBody Map<String,Object> map) {
        String openId = (String) map.get("openId");
        List<Integer>dramaIds= (List<Integer>) map.get("dramaIds");
        Boolean res = playedLogService.addOwnPlayed(openId, dramaIds);
        return GlobalResult.ok(res);
    }

    @GetMapping("/user/getUserByPhone")
    @ApiOperation("根据电话获取用户信息")
    public GlobalResult getUserByPhone(@RequestParam("phone") String phone) {
        List<User> users = userService.getUserByPhone(phone);
        if (users.size() > 0) {
            return GlobalResult.ok(users.get(0));
        }
        return GlobalResult.ok("查无此人,请让客户重新手机号码验证");
    }

    @GetMapping("/user/getAllUserList")
    @ApiOperation("用户列表")
    public GlobalResult getAllUserList(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "10") int pageSize,String key) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(userService.getAllUserList(key));
        return GlobalResult.ok(pageInfo);
    }

}
