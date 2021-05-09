package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.AdminUser;
import wechat.mbg.mapper.AdminUserMapper;
import wechat.mbg.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Override
    public AdminUser checkLogin(String userName, String pass) {
        return adminUserMapper.selectOne(new QueryWrapper<AdminUser>().eq("user_name",userName).eq("passWord",pass));
    }
}
