package pu.fmi.webserver.courseproject.travelagency.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

  private int statusCode;
  private String message;
  private LocalDateTime date;
  private String errorMessage;
  private String trace;

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getTrace() {
    return trace;
  }

  public void setTrace(String trace) {
    this.trace = trace;
  }
}
