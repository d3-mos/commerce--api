package com.globalhitss.claropay.cercademi.restapi.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalErrorsHandler extends ResponseEntityExceptionHandler  
{
  /***/
  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
  
  /** 400 Bad body request */
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
    HttpMessageNotReadableException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
      String error = "Malformed JSON request.";
      return buildResponseEntity(
        new ApiError(HttpStatus.BAD_REQUEST, error, ex)
      );
  }
  
  /** 400 Bad request parameters. */
  protected ResponseEntity<Object> handleTypeMismatch(
    TypeMismatchException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
    String error = "Type error at request param.";
    return buildResponseEntity(
      new ApiError(HttpStatus.BAD_REQUEST, error, ex)
    );
  }

  /** 405 Method not allowed */
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
    HttpRequestMethodNotSupportedException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
      String error = "Method not allowed.";
      return buildResponseEntity(
        new ApiError(HttpStatus.METHOD_NOT_ALLOWED, error, ex)
      );
  }
  
  /** 404 Not found */
  protected ResponseEntity<Object> handleNoHandlerFoundException(
    NoHandlerFoundException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {

    String error = "Resource not found.";
    return buildResponseEntity(
      new ApiError(HttpStatus.NOT_FOUND, error, ex)
    );
  }

  /** 404 Not found data. */
  @ExceptionHandler({DataNotFoundException.class})
  protected ResponseEntity<Object> handleDataNotFoundException(
    Exception ex
  ) {
      String error = "Resource searched wasn't found.";
      return buildResponseEntity(
        new ApiError(HttpStatus.NOT_FOUND, error, ex)
      );
  }
  
  /** 400 Bad data */
  @ExceptionHandler({DataInvalidFormatException.class})
  protected ResponseEntity<Object> handleDataInvalidFormatException(
    Exception ex
  ) {
      String error = "Format error parameter.";
      return buildResponseEntity(
        new ApiError(HttpStatus.BAD_REQUEST, error, ex)
      );
  }
  
  /** 400 Data out of range. */
  @ExceptionHandler({DataOutOfRangeException.class})
  protected ResponseEntity<Object> handleDataOutOfRangeException(
    Exception ex
  ) {
      String error = "Data out of range.";
      return buildResponseEntity(
        new ApiError(HttpStatus.BAD_REQUEST, error, ex)
      );
  }  
  
  /** 500 unknown server error. */
  @ExceptionHandler({Exception.class, UnknownErrorException.class})
  protected ResponseEntity<Object> handleAnyException(
    Exception ex
  ) {
      String error = "Internal server error.";
      return buildResponseEntity(
        new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex)
      );
  }
}

