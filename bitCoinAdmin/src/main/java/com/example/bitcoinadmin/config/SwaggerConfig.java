package com.example.bitcoinadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerInfo())
                .groupName("Test")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.bitcoinadmin"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Test API Documentation")
                .description("Swagger UI 간단 예제입니다.")
                .license("라이센스소유자")
                .licenseUrl("라이센스URL")
                .version("1.0")
                .build();
    }
}

