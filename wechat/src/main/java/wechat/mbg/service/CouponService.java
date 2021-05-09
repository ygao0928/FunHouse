package wechat.mbg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.Coupon;
import wechat.mbg.entity.UserCouponRelation;
import wechat.vo.CouponParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
public interface CouponService extends IService<Coupon> {
    /**
     * 新增优惠券模板
     * @param couponParam
     * @return
     */
    @Transactional
    Boolean insert(CouponParam couponParam);

    /**
     * 分配
     * @param phone
     * @param ids
     * @return
     */
    @Transactional
    Boolean distribution(String phone,List<Integer> ids);

    /**
     * 查询某个用户名下的所有 的优惠券
     * @param openId
     * @return
     */
    List<Coupon> getAllUser(String openId);

    /**
     * 查询所有的优惠券
     * @return
     */
    List<Coupon> getAll();

    /**
     * 删除优惠券
     * @param id
     * @return
     */
    Boolean deleteById(Integer id);
}
