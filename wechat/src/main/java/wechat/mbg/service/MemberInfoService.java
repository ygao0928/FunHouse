package wechat.mbg.service;

import wechat.mbg.entity.MemberInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
public interface MemberInfoService extends IService<MemberInfo> {

    //根据用户openid获得会员充值和游戏次数级别
    MemberInfo showMemberInfoById(String openId);
    //获取前10充值排行玩家
    List<MemberInfo> showTopTenMemebers();

}
