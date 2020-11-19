package wechat.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName MybatisConfig.java
 * @date 2020/10/26 20:13
 * @Description
 * @Content:
 */
@Configuration
@MapperScan({"wechat.mbg.mapper","wechat.mapper"})
public class MybatisConfig {
}
