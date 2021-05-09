package wechat.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName CouponParam.java
 * @date 2020/12/16 9:58
 * @Description
 * @Content:
 */
@Data
public class CouponParam implements Serializable {
    @ApiModelProperty(value = "自增id")
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
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date useStartTime;

    @ApiModelProperty(value = "截止使用时间")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date useEndTime;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer deleteFlage;

    @ApiModelProperty(value = "更新日期")
    private Date updateTime;

    @ApiModelProperty(value = "使用要求：0：无门槛；1：有门槛")
    private Integer useDemandFlag;

    @ApiModelProperty(value = "具体的门槛要求")
    private String useDemandContent;
}
