package wechat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author Sean.Wang
 * @Date 2020/5/25 16:18
 * @Version 1.0
 **/
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //指向外部目录
        registry.addResourceHandler("file//**").addResourceLocations("file:D:/fileupload/file/");
        super.addResourceHandlers(registry);
    }
}
