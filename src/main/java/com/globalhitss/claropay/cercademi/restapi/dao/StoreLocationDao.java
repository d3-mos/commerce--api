package com.globalhitss.claropay.cercademi.restapi.dao;

import java.util.List;

import com.globalhitss.claropay.cercademi.restapi.model.StoreLocation;


public interface StoreLocationDao 
{
  public StoreLocation selectById(int id);
  
  public List<StoreLocation> selectByLatAndLng(double lat, double lng, double vRadius);
  
  public List<StoreLocation> selectByBrand(String species);
  
  public List<StoreLocation> selectByClass(String className);
}
