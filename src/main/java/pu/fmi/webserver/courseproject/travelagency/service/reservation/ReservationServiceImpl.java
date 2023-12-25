package pu.fmi.webserver.courseproject.travelagency.service.reservation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.fmi.webserver.courseproject.travelagency.exception.NotFoundException;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.Reservation;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.CreateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.ResponseReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.UpdateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.repository.ReservationRepository;
import pu.fmi.webserver.courseproject.travelagency.service.holiday.HolidayService;

@Service
public class ReservationServiceImpl implements ReservationService {

  @Autowired private ReservationRepository reservationRepository;

  @Autowired private HolidayService holidayService;

  @Autowired private ReservationFactory reservationFactory;

  @Override
  public ResponseReservationDTO addReservation(CreateReservationDTO createReservationDTO) {

    Holiday holiday = holidayService.getHoliday(createReservationDTO.getHoliday());
    Reservation reservation =
        this.reservationFactory.mapFromCreateDTO(createReservationDTO, holiday);

    return this.reservationFactory.mapToResponseDTO(this.reservationRepository.save(reservation));
  }

  @Override
  public boolean deleteReservation(Long id) {

    Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
    if (optionalReservation.isPresent()) {
      this.reservationRepository.delete(optionalReservation.get());
      return true;
    }
    return false;
  }

  @Override
  public List<ResponseReservationDTO> getAllReservations() {
    return this.reservationRepository.findAll().stream()
        .map(r -> this.reservationFactory.mapToResponseDTO(r))
        .toList();
  }

  @Override
  public ResponseReservationDTO findReservationById(Long id) {
    Optional<Reservation> optionalOfReservation = this.reservationRepository.findById(id);

    if (optionalOfReservation.isPresent()) {
      return this.reservationFactory.mapToResponseDTO(optionalOfReservation.get());
    }

    throw new NotFoundException("Cannot Find Reservation With Id = " + id);
  }

  @Override
  public Reservation getReservation(Long id) {
    return this.reservationRepository.findById(id).orElse(null);
  }

  @Override
  public ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO) {

    Reservation reservation = this.getReservation(updateReservationDTO.getId());

    if (reservation == null) {
      throw new NotFoundException(
          "Cannot Find Reservation With Id = " + updateReservationDTO.getId());
    }

    reservation.setPhoneNumber(updateReservationDTO.getPhoneNumber());
    reservation.setContactName(updateReservationDTO.getContactName());

    if (updateReservationDTO.getHoliday() != null) {

      Holiday holiday = reservation.getHoliday();
      Holiday updateHoliday = this.holidayService.getHoliday(updateReservationDTO.getHoliday());

      holiday = this.updateHoliday(holiday, updateHoliday);
      reservation.setHoliday(holiday);
    }

    return this.reservationFactory.mapToResponseDTO(this.reservationRepository.save(reservation));
  }

  private Holiday updateHoliday(Holiday holiday, Holiday updateHoliday) {

    if (holiday == null) {
      holiday = new Holiday();
    }

    if (updateHoliday != null) {
      holiday.setPrice(updateHoliday.getPrice());
      holiday.setTitle(updateHoliday.getTitle());
      holiday.setStartDate(updateHoliday.getStartDate());
      holiday.setFreeSlots(updateHoliday.getFreeSlots());
      holiday.setDuration(updateHoliday.getDuration());
    }

    return holiday;
  }
}
