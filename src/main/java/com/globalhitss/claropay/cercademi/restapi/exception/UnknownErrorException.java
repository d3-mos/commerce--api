package com.globalhitss.claropay.cercademi.restapi.exception;

public class UnknownErrorException extends Exception
{
  /***/
  private static final long serialVersionUID = 1L;


  public UnknownErrorException()
  {
    super();
  }
  
  public UnknownErrorException(String error)
  {
    super(error);
  }
  
  public UnknownErrorException(String error, Exception cause)
  {
    super(error, cause);
  }
}
