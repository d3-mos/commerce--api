package com.globalhitss.claropay.cercedemi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import com.globalhitss.claropay.cercademi.restapi.exception.ApiError;
import com.globalhitss.claropay.cercademi.restapi.exception.DataNotFoundException;
import com.globalhitss.claropay.cercademi.restapi.exception.DataOutOfRangeException;
import com.globalhitss.claropay.cercademi.restapi.service.StoreService;
import com.globalhitss.claropay.cercedemi.restapi.model.NetworkGeolocation;
import com.globalhitss.claropay.cercedemi.restapi.model.StoreBrand;
import com.globalhitss.claropay.cercedemi.restapi.model.StoreLocation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/store")
@Produces("application/json")
@Consumes("application/json")
@Api(
  value="Store API",
  tags="Store API",
  description = ""
   + "The above methods are available to retrieve all data about of "
   + "Claropay store partners, promotions, brands, locations, etc."
)
public class StoreController
{
  @Autowired
  public StoreService storeService; 
  
  /***/
  @ApiOperation(
    value=""
      + "Returns the store location object asociated with the ID used as "
      + "argument.",
    consumes="application/json",
    produces="application/json"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code=200,
        message="Returns the StoreLocation object.",
        response=StoreLocation.class
      ),
      @ApiResponse(
        code=400,
        message="Type error at request param.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=404,
        message=""
          + "Not exists a store location with the ID used to make the "
          + "query.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=500,
        message="Any server error.",
        response=ApiError.class
      )
    }
  )
  @GetMapping("/location/id/{id}/")
  public StoreLocation getStoreLocationById(
    @ApiParam(
      value="ID of Store location",
      example="1",
      required=true
    ) @PathVariable int id
  )
    throws DataNotFoundException
  {
    return storeService.getStoreLocationById(id);
  }

  /***/
  @ApiOperation(
    value=""
      + "Returns the store location objects with at most 3 km of "
      + "distance from a point(coordinates) used like argument.",
    consumes="application/json",
    produces="application/json"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code=200,
        message="Returns an array of StoreLocation objects.",
        response=StoreLocation.class,
        responseContainer = "List"
      ),
      @ApiResponse(
        code=400,
        message="Type error at request param. | Your coordinates aren't from Mexico.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=404,
        message="No stores nearby from the location passed as argument.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=500,
        message="Any server error.",
        response=ApiError.class
      )
    }
  )
  @GetMapping("/location/lat/{lat}/lng/{lng}/")
	public List<StoreLocation> getStoreLocationsByLatAndLng(
	  @ApiParam(
	    value="Latitude of point",
	    example="19.4407",
	    required=true
	  ) @PathVariable double lat,
	  @ApiParam(
	    value="Longitude of point",
	    example="-99.1964",
	    required=true
	  ) @PathVariable double lng
	)
	  throws DataNotFoundException, DataOutOfRangeException
  {
    return storeService.getStoreLocationsByLatAndLng(lat, lng);
	}
	
  /***/
  @ApiOperation(
    value=""
      + "Returns all store locations that belongs to an brand of "
      + "Claropay partners.",
    consumes="application/json",
    produces="application/json"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code=200,
        message="Returns an array of StoreLocation objects.",
        response=StoreLocation.class,
        responseContainer = "List"
      ),
      @ApiResponse(
        code=404,
        message="No stores associated with current brand.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=500,
        message="Any server error.",
        response=ApiError.class
      )
    }
  )
	@GetMapping("/location/brand/{brandToken}/")
	public List<StoreLocation> getStoreLocationsByBrandType(
	  @ApiParam(
	    value="Brand token",
	    example="Sears",
	    allowableValues="Sears,Telcel,Inbursa,OXXO,Sanborns",
	    required=true
	  ) @PathVariable String brandToken
	)
	  throws DataNotFoundException
	{
	    return storeService.getStoreLocationsByBrandType(brandToken);
	}
	
  /***/
  @ApiOperation(
    value=""
      + "Returns all brands with promotions and operations "
      + "available to each of them.",
    consumes="application/json",
    produces="application/json"
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        code=200,
        message="Return an array of StoreBrand objects.",
        response=StoreBrand.class,
        responseContainer="List"
      ),
      @ApiResponse(
        code=404,
        message="There aren't store brands allocated into database.",
        response=ApiError.class
      ),
      @ApiResponse(
        code=500,
        message="Any server error.",
        response=ApiError.class
      )
    }
  )
	@GetMapping("/brand/all")
  public List<StoreBrand> getStoreBrands()
    throws DataNotFoundException
  {
    return storeService.getStoreBrands();
  }
}