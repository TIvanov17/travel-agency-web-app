package pu.fmi.webserver.courseproject.travelagency.model.location;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import pu.fmi.webserver.courseproject.travelagency.model.audit.AuditDateTrack;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;

@Entity
public class Location extends AuditDateTrack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String street;

  private String number;

  private String city;

  private String country;

  private String imageUrl;

  @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
  private List<Holiday> holidays;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<Holiday> getHolidays() {
    return holidays;
  }

  public void setHolidays(List<Holiday> holidays) {
    this.holidays = holidays;
  }
}
