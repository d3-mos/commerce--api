package com.globalhitss.claropay.cercademi.commerceapi.dao;

import java.util.List;

import com.globalhitss.claropay.cercedemi.commerceapi.model.Commerce;


public interface CommerceDao 
{
  public Commerce selectById(int id);
  
  public List<Commerce> selectByLatAndLng(double lat, double lng);
  
  public List<Commerce> selectBySpecies(String species);
  
  public List<Commerce> selectByClass(String className);
}
