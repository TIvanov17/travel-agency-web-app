package pu.fmi.webserver.courseproject.travelagency.model.reservation.dto;

import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.ResponseHolidayDTO;

public class ResponseReservationDTO {

  private Long id;

  private String contactName;

  private String phoneNumber;

  private ResponseHolidayDTO holiday;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public ResponseHolidayDTO getHoliday() {
    return holiday;
  }

  public void setHoliday(ResponseHolidayDTO holiday) {
    this.holiday = holiday;
  }
}
