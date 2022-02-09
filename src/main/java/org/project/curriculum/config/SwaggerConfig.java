package org.project.curriculum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Auther: hzy
 * @Date: 2021/10/22 19:17
 * @Description:
 */


@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder()
                        .contact(new Contact("hzy", "https://www.baidu.com/", "422511186@qq.com"))
                        .title("工资管理系统")
                        .version("1.0")
                        .build()
        );
    }
}
