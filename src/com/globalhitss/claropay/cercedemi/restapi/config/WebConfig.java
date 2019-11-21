package com.globalhitss.claropay.cercedemi.restapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.globalhitss.claropay.cercademi.restapi.exception.GlobalErrorsHandler;
import com.globalhitss.claropay.cercedemi.restapi.controller.NetworkGeolocationController;
import com.globalhitss.claropay.cercedemi.restapi.controller.StoreController;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{
	
	@Bean
  public StoreController storeController() { return new StoreController(); }
	
	@Bean 
	public NetworkGeolocationController networkGeolocationController() { return new NetworkGeolocationController(); }
	
	@Bean
	public GlobalErrorsHandler globalErrorsHandler() { return new GlobalErrorsHandler(); }
	
	 
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
}