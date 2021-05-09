package wechat.mbg.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="DramaLibrary对象", description="")
public class DramaLibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "剧本名字")
    private String dramaName;

    @ApiModelProperty(value = "剧本形式:盒装、城市限定、城市独家")
    private Integer scriptForm;

    @ApiModelProperty(value = "剧本难度:新手、进阶、烧脑")
    private Integer scriptDifficulty;

    @ApiModelProperty(value = "剧本背景:古装、民国、现代、科幻、欧式、日式、架空")
    private Integer scriptBackground;

    @ApiModelProperty(value = "剧本类型:还原、开放、封闭、半封闭、本格、变格")
    private Integer scriptType;

    @ApiModelProperty(value = "剧本剧情:恐怖、欢乐、推理、校园、硬核、情感、机制")
    private Integer scriptTheme;

    @ApiModelProperty(value = "剧本简介")
    @TableField("drama_Introduction")
    private String dramaIntroduction;

    @ApiModelProperty(value = "剧本首页图片")
    private String dramaImage;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "人数要求")
    private Integer numberRequire;

    @ApiModelProperty(value = "公众号链接地址")
    private String publicLink;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer deleteFlage;

    @ApiModelProperty(value = "是否上架")
    private Integer onShelf;

    @ApiModelProperty(value = "创建时间")
    private Date creationDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "剧本使用次数")
    private Integer counts;


}
