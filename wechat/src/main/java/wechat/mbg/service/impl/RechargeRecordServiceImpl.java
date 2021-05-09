package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.ConsumptionLog;
import wechat.mbg.entity.RechargeRecord;
import wechat.mbg.entity.User;
import wechat.mbg.entity.UserCouponRelation;
import wechat.mbg.mapper.ConsumptionLogMapper;
import wechat.mbg.mapper.RechargeRecordMapper;
import wechat.mbg.mapper.UserCouponRelationMapper;
import wechat.mbg.mapper.UserMapper;
import wechat.mbg.service.RechargeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Service
public class RechargeRecordServiceImpl extends ServiceImpl<RechargeRecordMapper, RechargeRecord> implements RechargeRecordService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ConsumptionLogMapper consumptionLogMapper;
    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;
    @Autowired
    private UserCouponRelationMapper userCouponRelationMapper;

    @Override
    public Boolean insert(String phone, Integer money) {
        List<User> users = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getPhoneNumber, phone));
        User user = users.get(0);
        RechargeRecord record = new RechargeRecord();
        record.setCreateTime(new Date());
        record.setRechargeMoney(new BigDecimal(money));
        record.setOpenId(user.getOpenId());
        int i1 = rechargeRecordMapper.insert(record);
        //更新用户的充值总额
        user.setTotalRecharge(user.getTotalRecharge().add(new BigDecimal(money)));
        //更新用户的余额
        user.setBalance(user.getBalance().add(new BigDecimal(money)));
        int i = userMapper.updateById(user);
        if (i1 > 0 && i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String generatorConsumption(String phone, Integer money, Integer payMethod, List<Integer> ids) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getPhoneNumber, phone);
        List<User> userList = userMapper.selectList(userQueryWrapper);
        if (userList.size() > 0) {
            User user = userList.get(0);
            String userOpenId = user.getOpenId();
            //生成消费记录
            ConsumptionLog log = new ConsumptionLog();
            log.setCreateTime(new Date());
            log.setOpenId(userOpenId);
            log.setUserPhone(phone);
            log.setPayMoney(money);
            int i = 0;
            //1 ：线上支付 2 ：线下支付
            if (payMethod == 1) {
                BigDecimal decimal = new BigDecimal(money);
                int compare = user.getBalance().compareTo(decimal);
                if (compare < 0) {
                    return "余额不足,请吧台付款";
                }
                //减余额
                user.setBalance(user.getBalance().subtract(decimal));
                //消费添加积分
                user.setTotalPoints(user.getTotalPoints() == null ? 0 : user.getTotalPoints() + money);
                int i1 = userMapper.update(user, new QueryWrapper<User>().eq("open_id", user.getOpenId()));
                i= consumptionLogMapper.insert(log);
                if (i > 0 && i1 > 0) {
                    /*更新优惠券的使用情况*/
                    for (int i2 = 0; i2 < ids.size(); i2++) {
                        List<UserCouponRelation> userCouponRelations = userCouponRelationMapper.selectList(new QueryWrapper<UserCouponRelation>().lambda().eq(UserCouponRelation::getCouponId, ids.get(i2)));
                        UserCouponRelation userCouponRelation = userCouponRelations.get(0);
                        userCouponRelation.setUseTime(new Date());
                        userCouponRelation.setUseFlag(1);
                        userCouponRelationMapper.updateById(userCouponRelation);
                    }
                    return "买单成功";
                } else {
                    return "买单失败";
                }
            }
            if (payMethod == 2) {
                i= consumptionLogMapper.insert(log);
                return "买单成功";
            }

        }
        return "买单异常,请吧台付款";
    }
}
