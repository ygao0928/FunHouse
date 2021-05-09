package wechat.mbg.service;

import wechat.mbg.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 微信用户信息 服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
public interface UserService extends IService<User> {

    List<User> getUserByPhone(String phone);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> getAllUserList(String key);

}
