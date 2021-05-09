package wechat.mbg.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 微信用户信息
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="微信用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "open_id")
      @TableId(value = "open_id", type =IdType.ASSIGN_ID)
    private String openId;

    @ApiModelProperty(value = "skey")
    private String skey;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastVisitTime;

    @ApiModelProperty(value = "session_key")
    private String sessionKey;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "国")
    private String country;

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "网名")
    private String nickName;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

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


}
