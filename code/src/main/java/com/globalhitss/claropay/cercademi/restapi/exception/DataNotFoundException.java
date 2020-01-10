package com.globalhitss.claropay.cercademi.restapi.exception;

public class DataNotFoundException extends Exception
{  
  /***/
  private static final long serialVersionUID = 1L;


  public DataNotFoundException() {
    super();
  }
  
  public DataNotFoundException(String error)
  {
    super(error);
  }
  
  public DataNotFoundException(String error, Exception cause)
  {
    super(error, cause);
  }
}
