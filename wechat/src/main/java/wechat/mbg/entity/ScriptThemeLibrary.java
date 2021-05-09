package wechat.mbg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="ScriptThemeLibrary对象", description="")
public class ScriptThemeLibrary implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "剧本剧情")
    private String scriptTheme;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer deleteFlage;


}
