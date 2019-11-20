package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.commerceapi.dao.NetworkGeolocationDao;
import com.globalhitss.claropay.cercedemi.commerceapi.model.NetworkGeolocation;

import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.getIPFromHTTPRequest;
import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.ip2num;


@Service
public class NetworkGeolocationService 
{
 
  @Autowired
  @Qualifier("NetworkGeolocationSQLDao")
  private NetworkGeolocationDao networkGeolocationDao;
  
  public List<NetworkGeolocation> getLocationByIP(HttpServletRequest rq)
  {
    return getLocationByIP(getIPFromHTTPRequest(rq));
  }
  
  @Transactional(readOnly = true)
  public List<NetworkGeolocation> getLocationByIP(String ip)
  {
    return networkGeolocationDao.getLocationByIP(ip2num(ip));
  }
}
