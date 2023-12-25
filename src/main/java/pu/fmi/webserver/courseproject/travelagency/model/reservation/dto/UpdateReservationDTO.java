package pu.fmi.webserver.courseproject.travelagency.model.reservation.dto;

public class UpdateReservationDTO {

  private Long id;

  private String contactName;

  private String phoneNumber;

  private Long holiday;

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

  public Long getHoliday() {
    return holiday;
  }

  public void setHoliday(Long holiday) {
    this.holiday = holiday;
  }
}
