package pu.fmi.webserver.courseproject.travelagency.service.reservation;

import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.Reservation;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.CreateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.ResponseReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.service.GenericEntityFactory;

public interface ReservationFactory
    extends GenericEntityFactory<Reservation, CreateReservationDTO, ResponseReservationDTO> {

  Reservation mapFromCreateDTO(CreateReservationDTO createReservationDTO, Holiday holiday);
}
