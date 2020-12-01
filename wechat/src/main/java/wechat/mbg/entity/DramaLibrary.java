package wechat.mbg.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kevin
 * @since 2020-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DramaLibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 剧本名字
     */
    private String dramaName;

    /**
     * 剧本形式:盒装、城市限定、城市独家
     */
    private Integer scriptForm;

    /**
     * 剧本难度:新手、进阶、烧脑
     */
    private Integer scriptDifficulty;

    /**
     * 剧本背景:古装、民国、现代、科幻、欧式、日式、架空
     */
    private Integer scriptBackground;

    /**
     * 剧本类型:还原、开放、封闭、半封闭、本格、变格
     */
    private Integer scriptType;

    /**
     * 剧本剧情:恐怖、欢乐、推理、校园、硬核、情感、机制
     */
    private Integer scriptTheme;

    /**
     * 剧本简介
     */
    @TableField("drama_Introduction")
    private String dramaIntroduction;

    /**
     * 剧本首页图片
     */
    private String dramaImage;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 人数要求
     */
    private Integer numberRequire;
    /**
     * 公众号链接地址
     */
    private  String publicLink;
    /**
     * 是否删除
     */
    @TableLogic(value = "0",delval = "1")
    private Integer deleteFlage;

    /**
     * 是否上架
     */
    private Integer onShelf;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 状态
     */
    private String statue;


}
