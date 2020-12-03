package wechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wechat.mbg.entity.Coupon;
import wechat.mbg.entity.RechargeRecord;
import wechat.mbg.service.CouponService;
import wechat.utils.GlobalResult;

import java.util.Map;

/**
 * <description>
 *
 * </description>
 *
 * @author YYang
 * @version 1.0
 * @date 2020/12/3 9:07
 */
@Api("后台管理优惠券")
@RestController
@CrossOrigin
@RequestMapping("/admin/Coupon")
public class AdminCouponController {
    @Autowired
    private CouponService couponService;
    @PostMapping("/addCoupon")
    @ApiOperation("批量新增优惠券")
    public GlobalResult addCoupon(@RequestBody Coupon coupon,@RequestParam("num")Integer num) {
        Map<String,Object> map =couponService.addCoupon(coupon,num);
        GlobalResult result = new GlobalResult();
        result.setData(map);
        result.setMsg("操作成功");
        result.setStatus(200);
        return result;
    }
}
