package wechat.mbg.service;


import wechat.mbg.entity.RechargeRecord;
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
public interface RechargeRecordService {

    //根据用户id显示充值详情
    PageResult showRechargeByIdInfo(PageRequest pageRequest, String openId);

    //列表显示充值记录
    PageResult showRechargeInfo(PageRequest pageRequest);
    //新增充值
    Map<String,Object> addRecharge(RechargeRecord rechargeRecord);

}
