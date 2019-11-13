package com.globalhitss.claropay.cercedemi.commerceapi.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.getIPFromRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ip-location")
public class IPLocationController 
{
  
  @GetMapping("/me/")
	public List<String> getGeoLocationByIP(HttpServletRequest rq)
	{
    System.out.println(getIPFromRequest(rq));
    
		return new LinkedList<String>();
	}
}
