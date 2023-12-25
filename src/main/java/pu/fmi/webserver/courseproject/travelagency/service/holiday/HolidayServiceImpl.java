package pu.fmi.webserver.courseproject.travelagency.service.holiday;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pu.fmi.webserver.courseproject.travelagency.exception.GenericException;
import pu.fmi.webserver.courseproject.travelagency.exception.NotFoundException;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.CreateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.ResponseHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.UpdateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.repository.HolidayRepository;
import pu.fmi.webserver.courseproject.travelagency.repository.specification.HolidaySpecification;
import pu.fmi.webserver.courseproject.travelagency.service.location.LocationService;

@Service
public class HolidayServiceImpl implements HolidayService {

  @Autowired private LocationService locationService;

  @Autowired private HolidayFactory holidayFactory;

  @Autowired private HolidayRepository holidayRepository;

  @Override
  public ResponseHolidayDTO addHoliday(CreateHolidayDTO createHolidayDTO) {

    Location location = null;
    if (createHolidayDTO.getLocation() != null) {
      location = this.locationService.getLocation(createHolidayDTO.getLocation());
    }

    Holiday holiday = this.holidayFactory.mapFromCreateDTO(createHolidayDTO, location);
    return this.holidayFactory.mapToResponseDTO(this.holidayRepository.save(holiday));
  }

  @Override
  public boolean deleteHolidayById(Long id) {

    Optional<Holiday> optionalOfHoliday = this.holidayRepository.findById(id);

    if (optionalOfHoliday.isPresent()) {
      this.holidayRepository.delete(optionalOfHoliday.get());
      return true;
    }
    return false;
  }

  @Override
  public List<ResponseHolidayDTO> findHolidaysBy(
      String location, LocalDate startDate, Integer duration) {

    Specification<Holiday> searchSpecification =
        HolidaySpecification.searchHolidayFilterBy(location, startDate, duration);

    return this.holidayRepository.findAll(searchSpecification).stream()
        .map(h -> this.holidayFactory.mapToResponseDTO(h))
        .toList();
  }

  @Override
  public Holiday getHoliday(Long id) {
    return this.holidayRepository.findById(id).orElse(null);
  }

  @Override
  public ResponseHolidayDTO findHolidayById(Long id) {

    Optional<Holiday> optionalOfHoliday = this.holidayRepository.findById(id);

    if (optionalOfHoliday.isPresent()) {
      return this.holidayFactory.mapToResponseDTO(optionalOfHoliday.get());
    }

    throw new NotFoundException("Cannot Find Holiday With Id = " + id);
  }

  @Override
  public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO) {

    Holiday holiday = this.getHoliday(updateHolidayDTO.getId());

    if (holiday == null) {
      throw new NotFoundException("Cannot Find Holiday With Id = " + updateHolidayDTO.getId());
    }

    holiday.setTitle(updateHolidayDTO.getTitle());
    holiday.setFreeSlots(updateHolidayDTO.getFreeSlots());
    holiday.setStartDate(updateHolidayDTO.getStartDate());
    holiday.setDuration(updateHolidayDTO.getDuration());

    if (!StringUtils.isBlank(updateHolidayDTO.getPrice())
        && !NumberUtils.isCreatable(updateHolidayDTO.getPrice())) {
      throw new GenericException(GenericException.INVALID_PRICE_FORMAT_MESSAGE);
    }
    holiday.setPrice(new BigDecimal(updateHolidayDTO.getPrice()));

    Location location = this.locationService.getLocation(updateHolidayDTO.getLocation());

    if (location != null) {
      holiday.setLocation(location);
    }

    return this.holidayFactory.mapToResponseDTO(this.holidayRepository.save(holiday));
  }
}
