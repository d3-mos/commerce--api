package com.globalhitss.claropay.cercademi.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.restapi.dao.StoreBrandDao;
import com.globalhitss.claropay.cercademi.restapi.dao.StoreLocationDao;
import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.exception.DataOutOfRangeException;
import com.globalhitss.claropay.cercedemi.restapi.model.StoreBrand;
import com.globalhitss.claropay.cercedemi.restapi.model.StoreLocation;
import static com.globalhitss.claropay.cercademi.restapi.util.Geolocation.areMxCoordinates;


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
    throws DataNotFoundException 
  {
    StoreLocation storeLocation = storeLocationDao.selectById(id);
    
    if (storeLocation==null) {
      throw new DataNotFoundException(
        "Store location with ID '"+id+"' is not found."
      );
    }
    
    return storeLocation;
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getStoreLocationsByLatAndLng(double lat, double lng)
    throws DataNotFoundException, DataOutOfRangeException
  {
    List<StoreLocation> storeLocations = storeLocationDao.selectByLatAndLng(lat, lng);
    
    if (!areMxCoordinates(lat, lng) ) {
      throw new DataOutOfRangeException("Your coordinates ("+lat+","+lng+") aren't from Mexico.");
    }
    
    if (storeLocations.size()==0) {
      throw new DataNotFoundException(
        "There aren't locations associated with geolocation: ("+lat+","+lng+")"
      );
    }
    
    return storeLocations;
  }
  
  @Transactional(readOnly = true)
  public List<StoreLocation> getStoreLocationsByBrandType(String brandToken)
    throws DataNotFoundException
  {
    List<StoreLocation> storeLocations = storeLocationDao.selectByBrand(brandToken);
    
    if (storeLocations.size()==0) {
      throw new DataNotFoundException(
        "There aren't locations associated with brand: "+brandToken
      );
    }
    
    return storeLocations;
  }
  
  @Transactional(readOnly = true)
  public List<StoreBrand> getStoreBrands()
    throws DataNotFoundException
  {
    List<StoreBrand> storeBrands = storeBrandDao.getAll();
    
    if (storeBrands.size()==0) {
      throw new DataNotFoundException(
        "There aren't store brands allocated into database."
      );
    }
    
    return storeBrands;
  }
}

