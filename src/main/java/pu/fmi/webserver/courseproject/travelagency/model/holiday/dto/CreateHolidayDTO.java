package pu.fmi.webserver.courseproject.travelagency.model.holiday.dto;

import jakarta.validation.constraints.Min;
import java.time.LocalDate;

public class CreateHolidayDTO {

  private Long location;

  private String title;

  private LocalDate startDate;

  @Min(value = 1, message = "Value must be greater than or equal to 0")
  private Integer duration;

  private String price;

  @Min(value = 1, message = "Value must be greater than or equal to 1")
  private Integer freeSlots;

  public Long getLocation() {
    return location;
  }

  public void setLocation(Long location) {
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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public Integer getFreeSlots() {
    return freeSlots;
  }

  public void setFreeSlots(Integer freeSlots) {
    this.freeSlots = freeSlots;
  }
}
