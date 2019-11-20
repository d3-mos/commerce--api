package com.globalhitss.claropay.cercedemi.commerceapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.globalhitss.claropay.cercedemi.commerceapi.controller.StoreController;
import com.globalhitss.claropay.cercedemi.commerceapi.controller.NetworkGeolocationController;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{
	
	@Bean
  public StoreController storeController() { return new StoreController(); }
	
	@Bean 
	public NetworkGeolocationController networkGeolocationController() { return new NetworkGeolocationController(); }
	
	
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