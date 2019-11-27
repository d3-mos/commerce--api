package com.globalhitss.claropay.cercademi.restapi.util;

public class Geolocation 
{
  public final static double MX_MAX_LAT = 32.718333333;
  public final static double MX_MIN_LAT = 14.540833333;
  public final static double MX_MAX_LNG = -86.71;
  public final static double MX_MIN_LNG = -118.45111111;
  
  public static boolean latIsInMxLatRange(double lat)
  {
    return lat>=MX_MIN_LAT && lat<=MX_MAX_LAT;
  }
  
  public static boolean lngIsInMxLngRange(double lng)
  {
    return lng>=MX_MIN_LNG && lng<=MX_MAX_LNG;
  }
  
  public static boolean areMxCoordinates(double lat, double lng)
  {
    return latIsInMxLatRange(lat) && lngIsInMxLngRange(lng);
  }
}
