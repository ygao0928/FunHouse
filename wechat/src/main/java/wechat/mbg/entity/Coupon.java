package wechat.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

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
 * @since 2020-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Coupon对象", description = "")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "优惠券名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "金额")
    private Integer amount;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "优惠券状态,0 生效；1不生效")
    private Integer status;

    @ApiModelProperty(value = "开始使用日期")
    private Date useStartTime;

    @ApiModelProperty(value = "截止使用时间")
    private Date useEndTime;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic(delval = "1",value = "0")
    private Integer deleteFlage;

    @ApiModelProperty(value = "更新日期")
    private Date updateTime;

    @ApiModelProperty(value = "使用要求：0：无门槛；1：有门槛")
    private Integer useDemandFlag;

    @ApiModelProperty(value = "具体的门槛要求")
    private String useDemandContent;


}
