package wechat.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MemberInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 网名
     */
    private String nickName;

    /**
     * openid
     */
    private Integer openId;

    /**
     * 手机号码
     */
    private String telephone;

    private String appsecret;

    private Integer appId;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 会员等级
     */
    private Integer memberLevel;

    /**
     * 是否是管理员	0:不是管理员	1:是管理员
     */
    private Integer isAdmin;


}
