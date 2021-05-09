package wechat.vo;

import lombok.Data;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName SearchConditionParam.java
 * @date 2020/12/15 11:10
 * @Description
 * @Content:
 */
@Data
public class SearchConditionParam {
    private Integer fromId;
    private Integer diffId;
    private Integer numberRe;
    private Integer backId;
    private Integer typeId;
}
