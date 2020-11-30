package wechat.dao;

import lombok.Data;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName UserInfo.java
 * @date 2020/11/19 13:20
 * @Description
 * @Content:
 */
@Data
public class UserInfo {
    private Integer userId;
    private String nickName;
    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private String language;
    private Byte gender;
    private String phone;
    private Byte userLevel;// 用户层级 0 普通用户，1 VIP用户，2 区域代理用户
    private Byte status;//状态
    private String registerDate;//注册日期
}
