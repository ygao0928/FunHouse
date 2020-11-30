package wechat.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName WxLoginInfo.java
 * @date 2020/11/19 13:19
 * @Description
 * @Content:
 */
@Data
public class WxLoginInfo implements Serializable {
    private static final long serialVersionUID = -7722430332896313642L;

    private String code;
    private UserInfo userInfo;
    private Integer shareUserId;
}
