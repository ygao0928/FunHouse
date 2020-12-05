package wechat.mbg.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.User;
import wechat.mbg.mapper.UserMapper;
import wechat.mbg.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;
import wechat.utils.PageUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 微信用户信息 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult showWeChatUsers(PageRequest pageRequest) {
        PageUtils.getPage(pageRequest);
        //查询微信用户列表
        List<User> users = userMapper.selectAll(null);
        return PageUtils.getPageResult(new PageInfo<>(users));
    }
}
