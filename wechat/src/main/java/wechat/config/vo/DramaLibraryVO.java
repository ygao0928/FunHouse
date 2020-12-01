package wechat.config.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName DramaLibraryVO.java
 * @date 2020/11/30 23:45
 * @Description
 * @Content:
 */
@Data
public class DramaLibraryVO {


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
    private String scriptForm;

    /**
     * 剧本难度:新手、进阶、烧脑
     */
    private String scriptDifficulty;

    /**
     * 剧本背景:古装、民国、现代、科幻、欧式、日式、架空
     */
    private String scriptBackground;

    /**
     * 剧本类型:还原、开放、封闭、半封闭、本格、变格
     */
    private String scriptType;

    /**
     * 剧本剧情:恐怖、欢乐、推理、校园、硬核、情感、机制
     */
    private String scriptTheme;

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
