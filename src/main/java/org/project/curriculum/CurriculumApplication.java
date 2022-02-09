package org.project.curriculum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@MapperScan("org.project.curriculum.mapper")
@SpringBootApplication(scanBasePackages = "org.project.curriculum")
@EnableOpenApi
public class CurriculumApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurriculumApplication.class, args);
    }

}
