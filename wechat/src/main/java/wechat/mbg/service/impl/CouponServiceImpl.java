package wechat.mbg.service.impl;

import com.github.pagehelper.PageInfo;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.Coupon;
import wechat.mbg.mapper.CouponMapper;
import wechat.mbg.service.CouponService;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;
import wechat.utils.PageUtils;
import wechat.utils.RandomCode;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;
    //列表显示优惠券
    @Override
    public PageResult showCoupons(PageRequest pageRequest) {
        PageUtils.getPage(pageRequest);
        List<Coupon> coupons = couponMapper.showCouponsByStatus();
        return PageUtils.getPageResult(new PageInfo<>(coupons));
    }

    //批量新增优惠券
    @Override
    @Transactional
    public Map<String, Object> addCoupon(Coupon coupon,Integer num) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg","批量插入失败");
        List<Coupon> couponList = new ArrayList<>();
        Date date = new Date();
        //随机生成序列号
        for (int i = 0; i < num; i++) {
            String s = new RandomCode().generateRandomStr(16);
            coupon.setSerialNumber(s);
            coupon.setCreateTime(date);
            couponList.add(coupon);
        }
        int i = couponMapper.insertCouponInBulk(couponList);
        if(i>0){
            map.put("msg","批量插入成功");
        }
        return map;
    }
}
