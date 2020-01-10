package com.globalhitss.claropay.cercademi.restapi.exception;

public class DataInvalidFormatException extends Exception
{
  /***/
  private static final long serialVersionUID = 1L;


  public DataInvalidFormatException()
  {
    super();
  }
  
  public DataInvalidFormatException(String error)
  {
    super(error);
  }
  
  public DataInvalidFormatException(String error, Exception cause)
  {
    super(error, cause);
  }
}
