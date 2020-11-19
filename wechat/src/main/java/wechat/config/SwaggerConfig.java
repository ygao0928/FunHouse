package wechat.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName SwaggerConfig.java
 * @date 2020/10/24 15:29
 * @Description
 * @Content:
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "mconfig", name = "swagger-ui-open", havingValue = "true")
public class SwaggerConfig {
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("wechat.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FunHouse数据平台开放接口")
                .description("Rest API接口")
                .version("1.0")
                .build();
    }
}