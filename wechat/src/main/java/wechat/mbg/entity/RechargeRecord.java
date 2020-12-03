package wechat.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.math.BigDecimal;
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
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RechargeRecord对象", description="")
public class RechargeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "open_id")
    private String openId;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "充值时间")
    private Date createTime;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @ApiModelProperty(value = "会员折扣")
    private Integer memberDiscount;

    @ApiModelProperty(value = "充值总额")
    private BigDecimal totalRecharge;

    @ApiModelProperty(value = "充值金额")
    private BigDecimal rechargeMoney;
}
