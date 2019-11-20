package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.commerceapi.dao.CommerceDao;
import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreLocation;

@Service
public class CommerceService {

  @Autowired
  @Qualifier("commerceSQLDAO")
  private CommerceDao commerceSQLDao;
  
  @Transactional(readOnly = true)
  public StoreLocation getCommerceById(int id)
  {
    return commerceSQLDao.selectById(id);
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getCommerceByLatAndLng(double lat, double lng)
  {
    return commerceSQLDao.selectByLatAndLng(lat, lng); 
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getCommerceByOperation(String operation)
  {
    return commerceSQLDao.selectByClass(operation); 
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getCommerceByBrand(String brandToken)
  {
    return commerceSQLDao.selectByBrand(brandToken);
  }
}
