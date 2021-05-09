package wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Sean.Wang
 * @Date 2020/5/25 16:18
 * @Version 1.0
 **/
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Value("${file.uploadurl}")
    private String  fileUrl;

    public void addResourceHandlers(ResourceHandlerRegistry register){
        //指向外部目录
        register.addResourceHandler("/file/**").addResourceLocations("file:"+fileUrl);
    }
}
