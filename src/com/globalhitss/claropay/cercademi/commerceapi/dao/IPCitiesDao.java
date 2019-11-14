package com.globalhitss.claropay.cercademi.commerceapi.dao;

import java.util.List;

import com.globalhitss.claropay.cercedemi.commerceapi.model.IPCities;


public interface IPCitiesDao 
{
  
  public List<IPCities> getLocationByIP(long ip);
}
