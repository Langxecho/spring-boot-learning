package top.langxecho.springboot.websocket.filter_interceptor.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.langxecho.springboot.websocket.filter_interceptor.interceptor.AuthInterceptor;
import top.langxecho.springboot.websocket.filter_interceptor.interceptor.CorsInterceptor;
import top.langxecho.springboot.websocket.filter_interceptor.interceptor.FileUpInterceptor;
import top.langxecho.springboot.websocket.filter_interceptor.interceptor.LoginInterceptor;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/11/4 14:54
 */
@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    private final AuthInterceptor authInterceptor;
    private final CorsInterceptor corsInterceptor;
    private final FileUpInterceptor fileUpInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(fileUpInterceptor).addPathPatterns("/minio");
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(rateLimitFilter).addPathPatterns("/**");


    }
}
