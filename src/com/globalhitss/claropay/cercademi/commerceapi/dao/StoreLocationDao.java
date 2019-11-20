package com.globalhitss.claropay.cercademi.commerceapi.dao;

import java.util.List;

import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreLocation;


public interface StoreLocationDao 
{
  public StoreLocation selectById(int id);
  
  public List<StoreLocation> selectByLatAndLng(double lat, double lng);
  
  public List<StoreLocation> selectByBrand(String species);
  
  public List<StoreLocation> selectByClass(String className);
}
