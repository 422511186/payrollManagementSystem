package org.project.curriculum.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.project.curriculum.Interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;

/**
 * @Auther: hzy
 * @Date: 2022/2/9 17:16
 * @Description:
 */
@Configuration
public class MyWebMvcConfigure implements WebMvcConfigurer {

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/**/login",
                        "/**/Register",
                        "/**/login.html",
                        "/**/Register.html"
                )
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/imgs/**")
                .excludePathPatterns("/pages/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui/**");
    }

    /**
     * @param builder
     * @return
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder){
        return builder.createXmlMapper(false).build();
    }

    /**
     * 时间格式化对象
     * @return
     */
    @Bean
    public SimpleDateFormat SimpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM");
    }

//    /**
//     * 跨域配置
//     */
//    @Bean
//    public CorsFilter corsFilter() {
//        //1.添加CORS配置信息
//        CorsConfiguration config = new CorsConfiguration();
//        //放行哪些原始域
//        config.addAllowedOrigin("*");
//        //是否发送Cookie信息
//        config.setAllowCredentials(true);
//        //放行哪些原始域(请求方式)
//        config.addAllowedMethod("*");
//        //放行哪些原始域(头部信息)
//        config.addAllowedHeader("*");
//        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
////        config.addExposedHeader("*");
//        config.addExposedHeader("Content-Type");
//        config.addExposedHeader( "X-Requested-With");
//        config.addExposedHeader("accept");
//        config.addExposedHeader("Origin");
//        config.addExposedHeader( "Access-Control-Request-Method");
//        config.addExposedHeader("Access-Control-Request-Headers");
//
//        //2.添加映射路径
//        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/**", config);
//
//        //3.返回新的CorsFilter.
//        return new CorsFilter(configSource);
//    }

    /**
     * 跨域配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
}
