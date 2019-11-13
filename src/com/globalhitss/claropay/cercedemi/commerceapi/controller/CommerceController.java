package com.globalhitss.claropay.cercedemi.commerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhitss.claropay.cercademi.commerceapi.service.CommerceService;
import com.globalhitss.claropay.cercedemi.commerceapi.model.CommerceModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/commerce")
public class CommerceController {

  @Autowired
  public CommerceService commerceService;
  
  
  @GetMapping("/id/{id}/")
  public CommerceModel getCommerceByID(@PathVariable int id)
  {
    return commerceService.commerceById(id);
  }
  
  @GetMapping("/lat/{lat}/lng/{lng}/")
	public List<CommerceModel> getCommerceByGeolocation(
	  @PathVariable double lat,
	  @PathVariable double lng
	) {
    return commerceService.commerceByLatAndLng(lat, lng);
	}
	
	@GetMapping("/class-name/{className}/")
	public List<CommerceModel> getCommerceByClassName(@PathVariable String className)
	{
	  return commerceService.commerceByClassName(className);
	}
	 
	@GetMapping("/species/{species}/")
	public List<CommerceModel> getCommerceBySpecies(@PathVariable String species)
	{
	  return commerceService.commerceBySpecies(species);
	}
}