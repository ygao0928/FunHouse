package wechat.mbg.mapper;

import org.springframework.stereotype.Repository;
import wechat.mbg.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 微信用户信息 Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
