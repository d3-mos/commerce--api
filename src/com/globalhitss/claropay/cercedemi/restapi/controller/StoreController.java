package com.globalhitss.claropay.cercedemi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.service.StoreService;
import com.globalhitss.claropay.cercedemi.restapi.model.StoreBrand;
import com.globalhitss.claropay.cercedemi.restapi.model.StoreLocation;


@RestController
@RequestMapping("/store")
@Produces("application/json")
@Consumes("application/json")
public class StoreController
{
  @Autowired
  public StoreService storeService; 
  
  @GetMapping("/location/id/{id}/")
  public StoreLocation getStoreLocationById(@PathVariable int id)
    throws DataNotFoundException
  {
      return storeService.getStoreLocationById(id);
  }
  
  @GetMapping("/location/lat/{lat}/lng/{lng}/")
	public List<StoreLocation> getStoreLocationsByLatAndLng(
	  @PathVariable double lat,
	  @PathVariable double lng
	)
	  throws DataNotFoundException
  {
      return storeService.getStoreLocationsByLatAndLng(lat, lng);
	}
	 
	@GetMapping("/location/brand/{brandToken}/")
	public List<StoreLocation> getStoreLocationsByBrandType(
	  @PathVariable String brandToken
	) 
	  throws DataNotFoundException
	{
	    return storeService.getStoreLocationsByBrandType(brandToken);
	}
	
	@GetMapping("/brand/all")
  public List<StoreBrand> getStoreBrands()
    throws DataNotFoundException
  {
      return storeService.getStoreBrands();
  }
}