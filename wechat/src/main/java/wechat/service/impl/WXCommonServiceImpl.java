package wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat.mbg.entity.ConsumptionLog;
import wechat.mbg.entity.User;
import wechat.mbg.mapper.ConsumptionLogMapper;
import wechat.mbg.mapper.UserMapper;
import wechat.service.WXCommonService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName WXCommonServiceImpl.java
 * @date 2020/12/13 16:36
 * @Description
 * @Content:
 */
@Service
public class WXCommonServiceImpl implements WXCommonService {
    @Autowired
    private ConsumptionLogMapper consumptionLogMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public String generatorConsumption(String phone, Integer money) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getPhoneNumber, phone);
        List<User> userList = userMapper.selectList(userQueryWrapper);
        if (userList.size() > 0) {
            User user = userList.get(0);
            String userOpenId = user.getOpenId();
            ConsumptionLog log = new ConsumptionLog();
            log.setCreateTime(new Date());
            log.setOpenId(userOpenId);
            log.setUserPhone(phone);
            log.setPayMoney(money);
            int i = consumptionLogMapper.insert(log);
            BigDecimal decimal = new BigDecimal(money);
            int compare = user.getBalance().compareTo(decimal);
            if (compare < 0) {
                return "余额不足,请吧台付款";
            }
            user.setBalance(user.getBalance().subtract(decimal));
            //消费添加积分
            user.setTotalPoints(user.getTotalPoints()==null?0:user.getTotalPoints() + money);
            int i1 = userMapper.update(user, new QueryWrapper<User>().eq("open_id", user.getOpenId()));
            if (i > 0 && i1 > 0) {
                return "买单成功";
            }
        }
        return "买单异常,请吧台付款";
    }

    @Override
    public List<ConsumptionLog> getAllConsumption(String openId) {
        QueryWrapper<ConsumptionLog> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConsumptionLog::getOpenId,openId);
        List<ConsumptionLog> logs = consumptionLogMapper.selectList(wrapper);
        return logs;
    }
}
