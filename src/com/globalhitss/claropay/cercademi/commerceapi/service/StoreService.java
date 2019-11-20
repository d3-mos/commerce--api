package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.commerceapi.dao.StoreBrandDao;
import com.globalhitss.claropay.cercademi.commerceapi.dao.StoreLocationDao;
import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreBrand;
import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreLocation;


@Service
public class StoreService
{
  @Autowired
  @Qualifier("StoreLocationDaoSQL")
  private StoreLocationDao storeLocationDao;
  
  @Autowired
  @Qualifier("StoreBrandDaoSQL")
  private StoreBrandDao storeBrandDao;
  
  @Transactional(readOnly = true)
  public StoreLocation getStoreLocationById(int id)
  {
    return storeLocationDao.selectById(id);
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getStoreLocationsByLatAndLng(double lat, double lng)
  {
    return storeLocationDao.selectByLatAndLng(lat, lng); 
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getStoreLocationsByOperationType(String operation)
  {
    return storeLocationDao.selectByClass(operation);
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getStoreLocationsByBrandType(String brandToken)
  {
    return storeLocationDao.selectByBrand(brandToken);
  }
  
  @Transactional(readOnly = true)
  public List<StoreBrand> getStoreBrands()
  {
    return storeBrandDao.getAll();
  }
}

