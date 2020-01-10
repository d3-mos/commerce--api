package com.globalhitss.claropay.cercademi.restapi.exception;

public class DataOutOfRangeException extends Exception
{
  /***/
  private static final long serialVersionUID = 1L;

  /***/
  public DataOutOfRangeException()
  {
    super();
  }
  
  /***/
  public DataOutOfRangeException(String error)
  {
    super(error);
  }
  
  /***/
  public DataOutOfRangeException(String error, Exception cause)
  {
    super(error, cause);
  }
}
