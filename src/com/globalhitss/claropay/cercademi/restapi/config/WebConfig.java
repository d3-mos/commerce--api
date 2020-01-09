package com.globalhitss.claropay.cercademi.restapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.globalhitss.claropay.cercademi.restapi.exception.GlobalErrorsHandler;
import com.globalhitss.claropay.cercademi.restapi.interceptors.CorsInterceptor;
import com.globalhitss.claropay.cercademi.restapi.controller.NetworkGeolocationController;
import com.globalhitss.claropay.cercademi.restapi.controller.StoreController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(
  basePackages = {
    "com.globalhitss.claropay.cercademi.restapi.controller",
    "springfox.documentation.swagger.web"
  }
)
public class WebConfig implements WebMvcConfigurer
{
	
	@Bean
  public StoreController storeController()
	{ return new StoreController(); }
	
	@Bean 
	public NetworkGeolocationController networkGeolocationController()
	{ return new NetworkGeolocationController(); }
	
  @Bean
  public GlobalErrorsHandler globalErrorsHandler()
  { return new GlobalErrorsHandler(); }
  
  @Bean
  public CorsInterceptor corsInterceptor(){ return new CorsInterceptor(); }
	
	 
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
	{
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JodaModule());
	
    objectMapper.setDateFormat(
      new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );
    
    converters.add(
      new MappingJackson2HttpMessageConverter(objectMapper)
    );
	}
  
	
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
    registry
    .addResourceHandler("swagger-ui.html")
    .addResourceLocations("classpath:/META-INF/resources/");
    
    registry
    .addResourceHandler("/webjars/**")
    .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(corsInterceptor());
  }
  
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/*");
  }
  
  @Bean
  public Docket api()
  {
    return new Docket(DocumentationType.SWAGGER_2)
      .useDefaultResponseMessages(false)
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.regex(".*"))
      .build()
      .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo()
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
}