package pu.fmi.webserver.courseproject.travelagency.model.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pu.fmi.webserver.courseproject.travelagency.model.audit.AuditDateTrack;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;

@Entity
public class Reservation extends AuditDateTrack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String contactName;

  private String phoneNumber;

  @ManyToOne
  @JoinColumn(name = "holiday_id")
  private Holiday holiday;

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

  public Holiday getHoliday() {
    return holiday;
  }

  public void setHoliday(Holiday holiday) {
    this.holiday = holiday;
  }
}
