package wechat.mbg.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.MemberInfo;
import wechat.mbg.mapper.MemberInfoMapper;
import wechat.mbg.service.MemberInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberInfo> implements MemberInfoService {

    @Autowired
    private MemberInfoMapper memberInfoMapper;
    //根据用户openid获得积分总额,余额,充值总额,充值会员级别,游戏次数会员级别等等
    @Override
    public MemberInfo showMemberInfoById(String openId) {
        MemberInfo memberInfo = memberInfoMapper.showMemberInfoById(openId);
        return memberInfo;
    }
    //获取前10充值排行玩家
    @Override
    public List<MemberInfo> showTopTenMemebers() {

        return null;
    }
}
