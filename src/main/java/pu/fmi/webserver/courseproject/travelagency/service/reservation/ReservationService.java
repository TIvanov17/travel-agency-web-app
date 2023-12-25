package pu.fmi.webserver.courseproject.travelagency.service.reservation;

import java.util.List;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.Reservation;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.CreateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.ResponseReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.UpdateReservationDTO;

public interface ReservationService {

  ResponseReservationDTO addReservation(CreateReservationDTO createReservationDTO);

  boolean deleteReservation(Long id);

  List<ResponseReservationDTO> getAllReservations();

  ResponseReservationDTO findReservationById(Long id);

  Reservation getReservation(Long id);

  ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO);
}
