package wechat.mbg.service;

import wechat.mbg.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;

/**
 * <p>
 * 微信用户信息 服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
public interface UserService extends IService<User> {

    //微信用户列表展示
    PageResult showWeChatUsers(PageRequest pageRequest);

}
