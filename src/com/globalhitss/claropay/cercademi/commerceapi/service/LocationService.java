package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.getIPFromHTTPRequest;
import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.ip2num;


//@Service
public class LocationService 
{
  
  public List<String> getLocationByIP(HttpServletRequest rq)
  {
    return getLocationByIP(getIPFromHTTPRequest(rq));
  }
  
  public List<String> getLocationByIP(String ip)
  {
    long num = ip2num(ip);
    System.out.println(num);
    return new LinkedList<String>();
  }
}
