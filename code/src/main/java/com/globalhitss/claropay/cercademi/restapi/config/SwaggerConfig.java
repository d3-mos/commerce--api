package com.globalhitss.claropay.cercademi.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig { 

    @Bean
    public ApiInfo apiInfo()
    {
      return new ApiInfoBuilder()
        .title("Cerca de mi REST API")
        .description(
          "This REST API is required by \"Cerca de mi\" microapp to get all"
        + " data about of Claropay parners store geolocations, promotions,"
        + "brands, etc." 
         )
        .version("1.0")
        .termsOfServiceUrl("https://www.citi.com.mx/")
        .license("CITI license")
        .licenseUrl("http://url-to-license.com")
        .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
          // Quit the base error controller
          //https://stackoverflow.com/questions/32941917/remove-basic-error-controller-in-springfox-swaggerui
          .apis(RequestHandlerSelectors.basePackage("com.globalhitss.claropay.cercademi.restapi.controller"))
          .paths(PathSelectors.regex(".*"))
          .build()
          .apiInfo(apiInfo());
    }

}
