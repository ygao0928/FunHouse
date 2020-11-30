package wechat.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ScriptBackgroundLibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 剧本背景
     */
    private String scriptBackground;

    /**
     * 逻辑删除
     */
    private Integer deleteFlage;


}
