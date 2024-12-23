package pu.fmi.webserver.courseproject.travelagency.model.holiday.dto;

import java.time.LocalDate;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.ResponseLocationDTO;

public class ResponseHolidayDTO {

  private Long id;

  private ResponseLocationDTO location;

  private String title;

  private LocalDate startDate;

  private Integer duration;

  private Double price;

  private Integer freeSlots;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ResponseLocationDTO getLocation() {
    return location;
  }

  public void setLocation(ResponseLocationDTO location) {
    this.location = location;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getFreeSlots() {
    return freeSlots;
  }

  public void setFreeSlots(Integer freeSlots) {
    this.freeSlots = freeSlots;
  }
}
