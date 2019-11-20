package com.globalhitss.claropay.cercedemi.commerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhitss.claropay.cercademi.commerceapi.service.StoreService;
import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreBrand;
import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreLocation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/store")
public class StoreController
{
  @Autowired
  public StoreService storeService; 
  
  @GetMapping("/location/id/{id}/")
  public StoreLocation getStoreLocationById(@PathVariable int id)
  {
    return storeService.getStoreLocationById(id);
  }
  
  @GetMapping("/location/lat/{lat}/lng/{lng}/")
	public List<StoreLocation> getStoreLocationsByLatAndLng(
	  @PathVariable double lat,
	  @PathVariable double lng
	) {
    return storeService.getStoreLocationsByLatAndLng(lat, lng);
	}
	
	@GetMapping("/location/operation/{operationToken}/")
	public List<StoreLocation> getStoreLocationsByOperationType(
	  @PathVariable String operationToken
	) {
	  return storeService.getStoreLocationsByOperationType(operationToken);
	}
	 
	@GetMapping("/location/brand/{brandToken}/")
	public List<StoreLocation> getStoreLocationsByBrandType(
	  @PathVariable String brandToken
	) {
	  return storeService.getStoreLocationsByBrandType(brandToken);
	}
	
	@GetMapping("/brand/all")
  public List<StoreBrand> getStoreBrands()
  {
    return storeService.getStoreBrands();
  }
}
