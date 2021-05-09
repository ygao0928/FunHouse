package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat.mbg.entity.Coupon;
import wechat.mbg.entity.User;
import wechat.mbg.entity.UserCouponRelation;
import wechat.mbg.mapper.CouponMapper;
import wechat.mbg.mapper.UserCouponRelationMapper;
import wechat.mbg.mapper.UserMapper;
import wechat.mbg.service.CouponService;
import wechat.vo.CouponParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCouponRelationMapper userCouponRelationMapper;

    @Override
    public Boolean insert(CouponParam couponParam) {
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponParam, coupon);
        coupon.setCreateTime(new Date());
        int i = couponMapper.insert(coupon);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean distribution(String phone, List<Integer> ids) {
        List<User> user = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getPhoneNumber, phone));
        if (user.size() > 0) {
            for (int i = 0; i < ids.size(); i++) {
                UserCouponRelation relation = new UserCouponRelation();
                relation.setCouponId(ids.get(i));
                relation.setOpenId(user.get(0).getOpenId());
                relation.setCreateTime(new Date());
                relation.setUserPhone(phone);
                relation.setUseFlag(0);
                int i1 = userCouponRelationMapper.insert(relation);
                if (i1 == 0) {
                    return false;
                }
            }
        }
        return true;

    }


    @Override
    public List<Coupon> getAllUser(String openId) {
        //TODO 一个人只能用一张相同的优惠券
        List<UserCouponRelation> couponRelations = userCouponRelationMapper.selectList(new QueryWrapper<UserCouponRelation>().eq("open_id", openId).eq("use_flag", 0));
        Set<Integer> ids = couponRelations.stream().map(UserCouponRelation::getCouponId).collect(Collectors.toSet());
        List<Coupon> coupons = new ArrayList<>();
        ids.forEach(i -> {
            Coupon coupon = couponMapper.selectById(i);
            if (coupon != null) {
                coupons.add(coupon);
            }
        });
        System.out.println(coupons);
        //过滤掉无效的优惠券
        List<Coupon> couponList = coupons.stream().filter(item -> item.getStatus().equals(0)).collect(Collectors.toList());
        return couponList;
    }

    @Override
    public List<Coupon> getAll() {
        List<Coupon> coupons = couponMapper.selectList(null);
        return coupons;
    }

    @Override
    public Boolean deleteById(Integer id) {
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Coupon::getId, id);
        int i = couponMapper.delete(wrapper);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
