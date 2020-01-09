package com.globalhitss.claropay.cercademi.restapi.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@Configuration
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	@Nullable
	protected Class<?>[] getRootConfigClasses() {
	  return new Class<?>[] {
        AppConfig.class,
        HibernateConfig.class
	  };
	}

	@Override
	@Nullable
	protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {
        WebConfig.class
	  };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
	
  
  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    registration.setInitParameter("throwExceptionIfNoHandlerFound", "true"); // -> true
  }
  
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		super.onStartup(servletContext);
	}
}