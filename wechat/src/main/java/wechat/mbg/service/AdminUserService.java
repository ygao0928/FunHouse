package wechat.mbg.service;

import wechat.mbg.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-25
 */
public interface AdminUserService extends IService<AdminUser> {

    AdminUser checkLogin(String userName, String pass);

}
