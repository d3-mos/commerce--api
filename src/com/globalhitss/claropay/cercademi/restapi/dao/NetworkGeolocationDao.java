package com.globalhitss.claropay.cercademi.restapi.dao;

import java.util.List;

import com.globalhitss.claropay.cercedemi.restapi.model.NetworkGeolocation;


public interface NetworkGeolocationDao 
{
  
  public List<NetworkGeolocation> getLocationByIP(long ip);
}
