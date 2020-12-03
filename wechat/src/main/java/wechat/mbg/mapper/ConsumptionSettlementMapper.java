package wechat.mbg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wechat.mbg.entity.ConsumptionSettlement;


import java.util.Date;
import java.util.List;

@Repository
public interface ConsumptionSettlementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumptionSettlement record);

    int insertSelective(ConsumptionSettlement record);

    ConsumptionSettlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumptionSettlement record);

    int updateByPrimaryKey(ConsumptionSettlement record);

    //根据用户openid查询积分和消费详情
    List<ConsumptionSettlement> showIntegralAndConsumptionById(@Param("openId") String openId);

    //列表显示消费记录
    List<ConsumptionSettlement> showConsumptionList(@Param("startTime")String startTime,@Param("endTime")String endTime);
}