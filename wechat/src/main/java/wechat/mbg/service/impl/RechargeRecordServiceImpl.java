package wechat.mbg.service.impl;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat.mbg.entity.MemberInfo;
import wechat.mbg.entity.RechargeRecord;
import wechat.mbg.entity.User;
import wechat.mbg.mapper.MemberInfoMapper;
import wechat.mbg.mapper.RechargeRecordMapper;
import wechat.mbg.mapper.UserMapper;
import wechat.mbg.service.RechargeRecordService;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;
import wechat.utils.PageUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MemberInfoMapper memberInfoMapper;

    static final String formatStr="yyyy-MM-dd";

    static final SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
    //根据用户id显示充值详情
    @Override
    public PageResult showRechargeByIdInfo(PageRequest pageRequest, String openId) {
        PageUtils.getPage(pageRequest);
        String beginTime = sdf.format(pageRequest.getBeginTime());
        String endTime = sdf.format(pageRequest.getEndTime());
        List<RechargeRecord> rechargeRecordList = rechargeRecordMapper.showRechargeByIdInfo(beginTime,endTime,openId);
        return PageUtils.getPageResult(new PageInfo<>(rechargeRecordList));
    }

    //列表显示充值记录
    @Override
    public PageResult showRechargeInfo(PageRequest pageRequest) {
        PageUtils.getPage(pageRequest);
        String beginTime = sdf.format(pageRequest.getBeginTime());
        String endTime = sdf.format(pageRequest.getEndTime());
        List<RechargeRecord> rechargeRecords = rechargeRecordMapper.showRechargeInfo(beginTime, endTime);
        return PageUtils.getPageResult(new PageInfo<>(rechargeRecords));
    }
    //新增充值
    @Override
    public Map<String,Object> addRecharge(RechargeRecord rechargeRecord) {
        String openId = rechargeRecord.getOpenId();
        Map<String,Object> map = new HashMap<>();
        map.put("msg","查无此人,请先去创建会员");
        //判断openId是否存在,有没有这个用户
        List<User> users = userMapper.selectAllUsers();
        for (User user : users) {
            if(openId.equals(user.getOpenId())){
                //新增充值记录的时间
                rechargeRecord.setCreateTime(new Date());
                //新增充值记录
                rechargeRecordMapper.insertSelective(rechargeRecord);
                //根据openId查询会员信息
                MemberInfo memberInfo = memberInfoMapper.showMemberInfoById(openId);
                //获取当前会员余额
                BigDecimal balance = memberInfo.getBalance();
                //充值金额
                BigDecimal rechargeMoney = rechargeRecord.getRechargeMoney();
                //修改余额
                memberInfo.setBalance(balance.add(rechargeMoney));
                //修改充值总金额
                BigDecimal newTotalRecharge = balance.add(memberInfo.getTotalRecharge());
                //修改充值会员lv
                int rechargeLv=0;
                if(newTotalRecharge.compareTo(BigDecimal.valueOf(8000))>-1){
                    rechargeLv = 5;
                }else if(newTotalRecharge.compareTo(BigDecimal.valueOf(4000))>-1){
                    rechargeLv = 4;
                }else if(newTotalRecharge.compareTo(BigDecimal.valueOf(2000))>-1){
                    rechargeLv = 3;
                }else if(newTotalRecharge.compareTo(BigDecimal.valueOf(1000))>-1){
                    rechargeLv = 2;
                }else if(newTotalRecharge.compareTo(BigDecimal.valueOf(500))>-1){
                    rechargeLv = 1;
                }
                memberInfo.setMemberRechargeLevel("V"+(rechargeLv+""));
                memberInfo.setTotalRecharge(newTotalRecharge);
                //修改会员信息
                memberInfoMapper.updateByOpenIdSelective(memberInfo);
                map.put("msg","充值成功");
                return map;
            }
        }
        return map;
    }

}
