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
import com.globalhitss.claropay.cercademi.restapi.exception.DataInvalidFormatException;
import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.exception.UnknownErrorException;
import com.globalhitss.claropay.cercademi.restapi.model.NetworkGeolocation;
import static com.globalhitss.claropay.cercademi.restapi.util.IPTools.regexIPAddress;

@Service
public class NetworkGeolocationService 
{
  @Autowired
  @Qualifier("NetworkGeolocationSQLDao")
  private NetworkGeolocationDao networkGeolocationDao;
  
  @Transactional(readOnly = true)
  public List<NetworkGeolocation> getLocationByIP(HttpServletRequest rq)
    throws DataNotFoundException, UnknownErrorException
  {
    try {
      return getLocationByIP(getIPFromHTTPRequest(rq));
    } catch(DataInvalidFormatException e) {
      throw new UnknownErrorException("The server can't get your public IP", e);
    }
  }
  
  @Transactional(readOnly = true)
  public List<NetworkGeolocation> getLocationByIP(String ip)
    throws DataNotFoundException, DataInvalidFormatException
  {
    if (!ip.matches(regexIPAddress)) {
      throw new DataInvalidFormatException("Your IP ("+ip+") doesn't match with the IP address regex."); 
    }
    
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
