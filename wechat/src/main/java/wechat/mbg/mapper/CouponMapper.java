package wechat.mbg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wechat.mbg.entity.Coupon;

import java.util.List;

@Repository
public interface CouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
    //列表显示优惠券
    List<Coupon> showCouponsByStatus();
    //批量新增优惠券
    int insertCouponInBulk(List<Coupon> couponList);
}