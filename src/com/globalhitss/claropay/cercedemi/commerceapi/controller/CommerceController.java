package com.globalhitss.claropay.cercedemi.commerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhitss.claropay.cercademi.commerceapi.service.CommerceService;
import com.globalhitss.claropay.cercedemi.commerceapi.model.StoreLocation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/commerce")
public class CommerceController {

  @Autowired
  public CommerceService commerceService;
  
  
  @GetMapping("/id/{id}/")
  public StoreLocation getCommerceByID(@PathVariable int id)
  {
    return commerceService.getCommerceById(id);
  }
  
  @GetMapping("/lat/{lat}/lng/{lng}/")
	public List<StoreLocation> getCommerceByGeolocation(
	  @PathVariable double lat,
	  @PathVariable double lng
	) {
    return commerceService.getCommerceByLatAndLng(lat, lng);
	}
	
	@GetMapping("/operation/{operation-token}/")
	public List<StoreLocation> getCommerceByOperations(
	  @PathVariable String operationToken
	) {
	  return commerceService.getCommerceByOperation(operationToken);
	}
	 
	@GetMapping("/brand/{brandToken}/")
	public List<StoreLocation> getCommerceByBrand(@PathVariable String brandToken)
	{
	  return commerceService.getCommerceByBrand(brandToken);
	}
}
