package com.globalhitss.claropay.cercademi.restapi.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CorsInterceptor extends HandlerInterceptorAdapter {
  
  
  @Override
  /**
   * Tener en cuenta las siguientes excepciones:
   * 
   * java.lang.IllegalArgumentException: Illegal base64 character -f
     * java.lang.ArrayIndexOutOfBoundsException: 1 //cuando se envía peticion sin encabezado
     * javax.persistence.NoResultException: No entity found for query
     * cadena vacia (no genera excepción ).
   */
    public boolean preHandle(
      HttpServletRequest  solicitud,
      HttpServletResponse respuesta,
      Object handler
    ) throws Exception {
      respuesta.setHeader("Access-Control-Allow-Origin",  solicitud.getHeader("origin"));
      respuesta.setHeader("Access-Control-Allow-Methods", "PUT,GET,DELETE,POST,OPTIONS");
      respuesta.setHeader("Access-Control-Allow-Headers", "Content-Type,Accept,Authorization,*");
      return true;
    }
}