package com.globalhitss.claropay.cercademi.restapi.service;

import static com.globalhitss.claropay.cercademi.restapi.util.IPTools.getIPFromHTTPRequest;
import static com.globalhitss.claropay.cercademi.restapi.util.IPTools.ip2num;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.restapi.dao.NetworkGeolocationDao;
import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercedemi.restapi.model.NetworkGeolocation;


@Service
public class NetworkGeolocationService 
{
  @Autowired
  @Qualifier("NetworkGeolocationSQLDao")
  private NetworkGeolocationDao networkGeolocationDao;
  
  public List<NetworkGeolocation> getLocationByIP(HttpServletRequest rq)
    throws DataNotFoundException
  {
    return getLocationByIP(getIPFromHTTPRequest(rq));
  }
  
  @Transactional(readOnly = true)
  public List<NetworkGeolocation> getLocationByIP(String ip)
    throws DataNotFoundException
  {
    List<NetworkGeolocation> netGeoList = networkGeolocationDao
      .getLocationByIP(ip2num(ip));
    
    if (netGeoList.size()==0) {
      throw new DataNotFoundException(
        "There aren't geolocations with your IP: ("+ip+")"
      );
    }
    
    return netGeoList;
  }
}
