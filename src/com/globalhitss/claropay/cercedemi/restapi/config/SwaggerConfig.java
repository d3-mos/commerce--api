package com.globalhitss.claropay.cercedemi.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.PathProvider;
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
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .pathProvider(new PathProvider() {
              
              public String getOperationPath(String operationPath) {
                return null;
              }
              
              public String getResourceListingPath(String groupName, String apiDeclaration) {
                return null;
              }

              public String getApplicationBasePath() {
                return "/";
              }
            })
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/.*"))

            .build()
            .pathMapping("/")
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
          .title("Cerca de mi REST API")
          .description(
            "Query methods that are required by \"Cerca de mi\" module."
           )
          .version("v1.0")
          .termsOfServiceUrl("https://www.citi.com.mx/")
          .license("CITI license")
          .licenseUrl("http://url-to-license.com")
          .build();
    }

}