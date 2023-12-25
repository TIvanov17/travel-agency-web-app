package pu.fmi.webserver.courseproject.travelagency.model.holiday;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import pu.fmi.webserver.courseproject.travelagency.model.audit.AuditDateTrack;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.Reservation;

@Entity
public class Holiday extends AuditDateTrack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  private String title;

  private LocalDate startDate;

  private Integer duration;

  private Integer freeSlots;

  private BigDecimal price;

  @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL)
  private List<Reservation> reservations;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
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

  public Integer getFreeSlots() {
    return freeSlots;
  }

  public void setFreeSlots(Integer freeSlots) {
    this.freeSlots = freeSlots;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
}
