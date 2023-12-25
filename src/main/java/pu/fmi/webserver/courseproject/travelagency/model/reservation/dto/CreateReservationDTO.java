package pu.fmi.webserver.courseproject.travelagency.model.reservation.dto;

public class CreateReservationDTO {

  private String contactName;

  private String phoneNumber;

  private Long holiday;

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

  public Long getHoliday() {
    return holiday;
  }

  public void setHoliday(Long holiday) {
    this.holiday = holiday;
  }
}
