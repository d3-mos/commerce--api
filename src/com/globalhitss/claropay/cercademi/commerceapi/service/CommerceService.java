package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercedemi.commerceapi.model.CommerceModel;

@Service
public class CommerceService {

  @Transactional(readOnly = true)
  public CommerceModel commerceById(int id)
  {
    return new CommerceModel();
  }
  
  @Transactional(readOnly = true)
  public List<CommerceModel> commerceByLatAndLng(double lat, double lng)
  {
   return new ArrayList<CommerceModel>(); 
  }
  
  @Transactional(readOnly = true)
  public List<CommerceModel> commerceByClassName(String className)
  {
    return new ArrayList<CommerceModel>();
  }
  
  @Transactional(readOnly = true)
  public List<CommerceModel> commerceBySpecies(String speciesToken)
  {
    return new ArrayList<CommerceModel>();
  }
}
