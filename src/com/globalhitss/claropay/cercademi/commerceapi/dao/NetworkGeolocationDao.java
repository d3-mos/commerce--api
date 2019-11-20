package com.globalhitss.claropay.cercademi.commerceapi.dao;

import java.util.List;

import com.globalhitss.claropay.cercedemi.commerceapi.model.NetworkGeolocation;


public interface NetworkGeolocationDao 
{
  
  public List<NetworkGeolocation> getLocationByIP(long ip);
}
