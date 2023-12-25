package pu.fmi.webserver.courseproject.travelagency.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({NotFoundException.class})
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResponse> resourceNotFoundException(
      NotFoundException ex, WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
    errorResponse.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
    errorResponse.setDate(LocalDateTime.now());
    errorResponse.setErrorMessage(ex.getMessage());
    errorResponse.setTrace(Arrays.toString(ex.getStackTrace()));

    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({GenericException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> resourceNotFoundException(
      GenericException ex, WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
    errorResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
    errorResponse.setDate(LocalDateTime.now());
    errorResponse.setErrorMessage(ex.getMessage());
    errorResponse.setTrace(Arrays.toString(ex.getStackTrace()));

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
