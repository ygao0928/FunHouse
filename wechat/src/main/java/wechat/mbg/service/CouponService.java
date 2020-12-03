package wechat.mbg.service;

import wechat.mbg.entity.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
public interface CouponService {

    //列表显示优惠券
    PageResult showCoupons(PageRequest pageRequest);

    //新增优惠券
    Map<String, Object> addCoupon(Coupon coupon,Integer num);
}
