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
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Api;

import com.globalhitss.claropay.cercademi.restapi.exception.ApiError;
import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.service.NetworkGeolocationService;
import com.globalhitss.claropay.cercedemi.restapi.model.NetworkGeolocation;



@RestController
@RequestMapping("/network-geolocation")
@Api(
  value="Network Geolocation API",
  tags="Network Geolocation API",
  description = ""
   + "The above methods return a list of location objects associated with an "
   + "IP. Items of the result list are sorted by accuracy (Ascendant - The"
   + " first item is the most accuracy). On the other hand, There are only "
   + "IP's from México ."
)
@Consumes("application/json")
@Produces("application/json")
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
        message="At least, there is a location associated with your public IP.",
        response=NetworkGeolocation.class,
        responseContainer = "List"
      ),
      @ApiResponse(
        code=404,
        message="There aren't geolocations associated with your public IP.",
        response=ApiError.class
      )
      //500
    }
  )
  @GetMapping("/my-ip/")
  public List<NetworkGeolocation> getLocationByIP(HttpServletRequest rq)
    throws DataNotFoundException
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
        + "Returns an array of geolocations associated with the IP passed"
        + " as argument.",
        response = NetworkGeolocation.class,
        responseContainer = "List"
      ),
      @ApiResponse(
        code=404,
        message="There aren't geolocations associated with your public IP.",
        response=ApiError.class,
        examples=@Example(value = @ExampleProperty(
            value = "{" + 
                "  \"message\": \"Resource searched wasn't found.\"," + 
                "  \"debugMessage\": \"There aren't geolocations with your IP: (${ipArgument})\"," + 
                "  \"timestamp\": \"2019-11-26 01:34:22\"" + 
            "}",
            mediaType = "Example JSON"
          )
        )
      )
      // 400 - bad format
      // 400 - range out of components
      // 500 - server error
    }
  )
  @GetMapping("/ip/{ip}/")
  public List<NetworkGeolocation> getLocationByIP(
    @ApiParam(
      value = ""
       + "The IP string, it must match with \"^([0-9]{1,3}\\\\.){3}[0-9]{1,3}$\" regular"
       + " expresion. The max value of each component (dot separated values) is 255, "
       + "the min value is 0.",
      example="201.168.165.2",
      required=true
    ) @PathVariable String ip
  )
    throws DataNotFoundException
  {
    return networkGeolocationService.getLocationByIP(ip);
  }
}