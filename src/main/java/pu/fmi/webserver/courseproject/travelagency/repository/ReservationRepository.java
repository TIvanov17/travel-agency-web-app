package pu.fmi.webserver.courseproject.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
