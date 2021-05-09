package wechat.mbg.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kevin
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MemberInfo对象", description="")
public class MemberInfo implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "网名")
    private String nickName;

    @ApiModelProperty(value = "openid")
    private String openId;

    @ApiModelProperty(value = "手机号码")
    private String telephone;

    private String appsecret;

    private Integer appId;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "会员充值等级")
    private String memberRechargeLevel;

    @ApiModelProperty(value = "是否是管理员	0:不是管理员	1:是管理员")
    private Integer isAdmin;

    @ApiModelProperty(value = "会员玩本次数级别")
    private String memberPlayedLevel;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "消费总额")
    private BigDecimal totalCost;

    @ApiModelProperty(value = "充值总额")
    private BigDecimal totalRecharge;

    @ApiModelProperty(value = "剩余积分")
    private Integer remainingPoints;

    @ApiModelProperty(value = "积分总额")
    private Integer totalPoints;

    @ApiModelProperty(value = "玩游戏次数")
    private Integer playedCounts;

    @ApiModelProperty(value = "会员折扣")
    private Integer memberDiscount;


}
