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
 *
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ConsumptionSettlement对象", description="")
public class ConsumptionSettlement implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "open_id")
    private String openId;

    @ApiModelProperty(value = "剧本id")
    private Integer dramaId;

    @ApiModelProperty(value = "消费时间")
    private Date createTime;

    @ApiModelProperty(value = "优惠券id")
    private String couponId;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "消费总额")
    private BigDecimal totalCost;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @ApiModelProperty(value = "消费剧本次数统计")
    private Integer consumptionNum;

    @ApiModelProperty(value = "剧本名称")
    private String dramaName;

    @ApiModelProperty(value = "积分总额")
    private Integer totalIntegral;

    @ApiModelProperty(value = "剧本价格")
    private BigDecimal dramaPrice;
}
