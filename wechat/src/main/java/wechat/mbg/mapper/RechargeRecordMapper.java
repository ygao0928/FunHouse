package wechat.mbg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wechat.mbg.entity.RechargeRecord;

import java.util.List;
@Repository
public interface RechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeRecord record);

    //新增充值
    Boolean insertSelective(RechargeRecord record);

    RechargeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeRecord record);

    int updateByPrimaryKey(RechargeRecord record);
    //根据用户id显示充值详情
    List<RechargeRecord> showRechargeByIdInfo(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("openId")String openId);
    //列表显示充值记录
    List<RechargeRecord> showRechargeInfo(@Param("startTime")String startTime,@Param("endTime")String endTime);

}