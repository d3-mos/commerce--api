package com.globalhitss.claropay.cercedemi.commerceapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhitss.claropay.cercademi.commerceapi.service.LocationService;
import com.globalhitss.claropay.cercedemi.commerceapi.model.IPCities;


@RestController
@RequestMapping("/location")
public class LocationController 
{
  @Autowired
  public LocationService locationService;
  
  @GetMapping("/my-ip/")
  public List<IPCities> getLocationByIP(HttpServletRequest rq)
  {
    return locationService.getLocationByIP(rq);
  }
  
  @GetMapping("/ip/{ip}/")
  public List<IPCities> getLocationByIP(@PathVariable String ip)
  {
    return locationService.getLocationByIP(ip);
  }
}
