package com.globalhitss.claropay.cercedemi.commerceapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
//import controllers.ControladorArchivos;
//import interceptores.InterceptorDeSesion;
import com.globalhitss.claropay.cercedemi.commerceapi.controller.TestController;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{

	@Bean
	public TestController testController(){ return new TestController(); }
	
//	@Bean
//	public InterceptorDeSesion interceptorDeSesion(){ return new InterceptorDeSesion(); }
	
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
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor( interceptorDeSesion() );
//	}
	
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//    	System.out.println("Entra \n");
//        registry.addMapping("/api/**");
//    }
}