package wechat.mbg.service;

import wechat.utils.PageRequest;
import wechat.utils.PageResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
public interface ConsumptionSettlementService {

    //根据用户openid查询积分情况,消费记录
    PageResult showIntegralAndConsumptionByIdInfo(PageRequest pageRequest, String openId);

    //列表显示消费记录
    PageResult showConsumptionInfo(PageRequest pageRequest);

}
