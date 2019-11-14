package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.commerceapi.dao.CommerceDao;
import com.globalhitss.claropay.cercedemi.commerceapi.model.Commerce;

@Service
public class CommerceService {

  @Autowired
  private CommerceDao commerceSQLDao;
  
  @Transactional(readOnly = true)
  public Commerce commerceById(int id)
  {
    return commerceSQLDao.selectById(id);
  }
  
  @Transactional(readOnly = true)
  public List<Commerce> commerceByLatAndLng(double lat, double lng)
  {
    return commerceSQLDao.selectByLatAndLng(lat, lng); 
  }
  
  @Transactional(readOnly = true)
  public List<Commerce> commerceByClassName(String className)
  {
    return commerceSQLDao.selectByClass(className); 
  }
  
  @Transactional(readOnly = true)
  public List<Commerce> commerceBySpecies(String speciesToken)
  {
    return commerceSQLDao.selectBySpecies(speciesToken);
  }
}
