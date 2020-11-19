package wechat.mbg.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kevin
 * @since 2020-10-26
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
     * 是否删除
     */
    private Integer isdeleted;

    /**
     * 是否上架
     */
    private Integer onShelf;

    /**
     * 创建时间
     */
    private LocalDateTime creationDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;


}
