package com.globalhitss.claropay.cercedemi.restapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.service.NetworkGeolocationService;
import com.globalhitss.claropay.cercedemi.restapi.model.NetworkGeolocation;


@RestController
@RequestMapping("/network-geolocation")
public class NetworkGeolocationController 
{
  @Autowired
  public NetworkGeolocationService networkGeolocationService;
  
  @GetMapping("/my-ip/")
  public List<NetworkGeolocation> getLocationByIP(HttpServletRequest rq)
    throws DataNotFoundException
  {
    return networkGeolocationService.getLocationByIP(rq);    
  }
  
  @GetMapping("/ip/{ip}/")
  public List<NetworkGeolocation> getLocationByIP(@PathVariable String ip)
    throws DataNotFoundException
  {
    return networkGeolocationService.getLocationByIP(ip);
  }
}
