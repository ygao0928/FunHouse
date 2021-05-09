package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.User;
import wechat.mbg.mapper.UserMapper;
import wechat.mbg.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 微信用户信息 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByPhone(String phone) {
        List<User> users = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getPhoneNumber, phone));
        return users;
    }

    @Override
    public List<User> getAllUserList(String key) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(User::getPhoneNumber,key);
        List<User> users = userMapper.selectList(wrapper);
        return users;
    }
}
