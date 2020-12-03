package wechat.mbg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wechat.mbg.entity.MemberInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wechat.mbg.entity.RechargeRecord;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
@Repository
public interface MemberInfoMapper extends BaseMapper<MemberInfo> {
    //根据用户openid获得积分总额,余额,充值总额,充值会员级别,游戏次数会员级别等等
    MemberInfo showMemberInfoById(@Param("openId")String openId);

    //获取前10充值排行玩家
    List<RechargeRecord> showTopTenMemebers();
    //修改或者新增会员信息
    Boolean insertOrUpdateMemberInfo(@Param("MemberInfo")MemberInfo memberInfo);

    Boolean insertSelective(MemberInfo record);

    Boolean updateByOpenIdSelective(MemberInfo record);
}
