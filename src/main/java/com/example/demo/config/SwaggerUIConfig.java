package com.example.demo.config;

import com.example.demo.constant.SwaggerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: swagger配置类
 * @Version: [V1.0]
 */
@EnableSwagger2
@Configuration
public class SwaggerUIConfig {

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties().isEnable())
                .groupName("***服务系统").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(SwaggerUIConfig.PACKAGE)).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("***服务")
                .title("")
                .description("***服务系统")
                .version("v1.0").build();
    }

    private static final String PACKAGE = "com.example.demo.controller";
}
