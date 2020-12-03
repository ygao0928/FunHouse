package wechat.mbg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wechat.mbg.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

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
    //查询所有用户或者根据手机号模糊查询
    List<User> selectAll(@Param("key")String key);
    //查询所有用户信息
    List<User> selectAllUsers();
}
