package pu.fmi.webserver.courseproject.travelagency.exception;

public class GenericException extends RuntimeException {

  public static final String INVALID_PRICE_FORMAT_MESSAGE = "Invalid price value!";

  public GenericException(String message) {
    super(message);
  }
}
