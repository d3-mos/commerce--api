package com.globalhitss.claropay.cercademi.restapi.config;

import com.globalhitss.claropay.cercademi.restapi.interceptors.CorsInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class InterceptorsConfig implements WebMvcConfigurer
{
    @Bean
    public CorsInterceptor corsInterceptor(){ return new CorsInterceptor(); }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(corsInterceptor());
    }
}