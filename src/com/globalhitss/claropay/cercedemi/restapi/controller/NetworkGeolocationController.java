package com.globalhitss.claropay.cercedemi.restapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Api;

import com.globalhitss.claropay.cercademi.restapi.exception.ApiError;
import com.globalhitss.claropay.cercademi.restapi.exception.DataInvalidFormatException;
import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.exception.UnknownErrorException;
import com.globalhitss.claropay.cercademi.restapi.service.NetworkGeolocationService;
import com.globalhitss.claropay.cercedemi.restapi.model.NetworkGeolocation;
import static com.globalhitss.claropay.cercademi.restapi.util.IPTools.regexIPAddress;



@RestController
@RequestMapping("/network-geolocation")
@Consumes("application/json")
@Produces("application/json")
@Api(
  value="Network Geolocation API",
  tags="Network Geolocation API",
  description = ""
   + "The above methods return a list of location objects associated with an "
   + "IP. Items of the result list are sorted by accuracy (Ascendant - The"
   + " first item is the most accuracy). On the other hand, There are only "
   + "IP's from México."
)
public class NetworkGeolocationController
{
  @Autowired
  public NetworkGeolocationService networkGeolocationService;
  
  @ApiOperation(
    value="Find your geolocation using your public IP.",
    notes="This service gets your public IP address from your request headers.",
    consumes="application/json",
    produces="application/json"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code=200,
        message="Returns an array of NetworkGeolocation objects.",
        response=NetworkGeolocation.class,
        responseContainer = "List"
      ),
      @ApiResponse(
        code=404,
        message="There aren't geolocations associated with your public IP.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=500,
        message="The server can't get your public IP. | Any server error.",
        response=ApiError.class
      )
    }
  )
  @GetMapping("/my-ip/")
  public List<NetworkGeolocation> getLocationByIP(HttpServletRequest rq)
    throws DataNotFoundException, UnknownErrorException
  {
    return networkGeolocationService.getLocationByIP(rq);    
  }
  
  
  @ApiOperation(
    value="Find geolocation associated with an IP address passed as argument.",
    consumes="application/json",
    produces="application/json"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code=200,
        message=""
        + "Returns an array of NetworkGeolocation objects."
        + " as argument.",
        response = NetworkGeolocation.class,
        responseContainer = "List"
      ),
      @ApiResponse(
        code=404,
        message="There aren't geolocations with your IP: .*.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=400,
        message="Your IP (.*) doesn't match with the IP address regex.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=500,
        message="Any server error.",
        response=ApiError.class
      )
    }
  )
  @GetMapping("/ip/{ip}/")
  public List<NetworkGeolocation> getLocationByIP(
    @ApiParam(
      value = ""
       + "The IP string, it must match with IP address regular expression "
       + "("+regexIPAddress+"). You can test this regular expression in the "
       + "follow page https://regex101.com/",
      example="201.168.165.2",
      required=true
    )
    @PathVariable String ip
  )
    throws DataNotFoundException, DataInvalidFormatException
  {
    return networkGeolocationService.getLocationByIP(ip);
  }
}