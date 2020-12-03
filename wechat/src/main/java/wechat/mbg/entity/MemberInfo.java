package wechat.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

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
     * 会员充值等级
     */
    private String memberRechargeLevel;

    /**
     * 是否是管理员	0:不是管理员	1:是管理员
     */
    private Integer isAdmin;

    /**
     * 会员玩本次数等级
     */
    private Integer memberPlayedLevel;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 消费总额
     */
    private BigDecimal totalCost;

    /**
     * 充值总额
     */
    private BigDecimal totalRecharge;

    /**
     * 剩余积分
     */
    private Integer remainingPoints;

    /**
     * 积分总额
     */
    private Integer totalPoints;

    /**
     * 玩游戏次数
     */
    private Integer playedCounts;
    /**
     * 会员折扣
     */
    private Integer memberDiscount;
}
