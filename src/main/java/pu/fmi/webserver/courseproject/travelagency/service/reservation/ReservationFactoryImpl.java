package pu.fmi.webserver.courseproject.travelagency.service.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.Reservation;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.CreateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.ResponseReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.service.holiday.HolidayFactory;

@Component
public class ReservationFactoryImpl implements ReservationFactory {

  @Autowired private HolidayFactory holidayFactory;

  @Override
  public Reservation mapFromCreateDTO(CreateReservationDTO createReservationDTO, Holiday holiday) {
    Reservation reservation = this.mapFromCreateDTO(createReservationDTO);
    reservation.setHoliday(holiday);
    return reservation;
  }

  @Override
  public Reservation mapFromCreateDTO(CreateReservationDTO createReservationDTO) {
    Reservation reservation = new Reservation();
    reservation.setContactName(createReservationDTO.getContactName());
    reservation.setPhoneNumber(createReservationDTO.getPhoneNumber());
    return reservation;
  }

  @Override
  public ResponseReservationDTO mapToResponseDTO(Reservation reservation) {
    ResponseReservationDTO responseReservationDTO = new ResponseReservationDTO();
    responseReservationDTO.setId(reservation.getId());
    responseReservationDTO.setContactName(reservation.getContactName());
    responseReservationDTO.setPhoneNumber(reservation.getPhoneNumber());

    Holiday holiday = reservation.getHoliday();

    if (holiday != null) {
      responseReservationDTO.setHoliday(this.holidayFactory.mapToResponseDTO(holiday));
    }

    return responseReservationDTO;
  }
}
