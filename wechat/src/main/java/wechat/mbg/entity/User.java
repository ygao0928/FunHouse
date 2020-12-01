package wechat.mbg.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信用户信息
 * </p>
 *
 * @author Kevin
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * open_id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String openId;

    /**
     * skey
     */
    private String skey;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date lastVisitTime;

    /**
     * session_key
     */
    private String sessionKey;

    /**
     * 市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 国
     */
    private String country;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 网名
     */
    private String nickName;
    /**
     * 电话号码
     */
    private String phoneNumber;


}
