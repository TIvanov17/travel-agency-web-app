package pu.fmi.webserver.courseproject.travelagency.service.holiday;

import java.math.BigDecimal;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pu.fmi.webserver.courseproject.travelagency.exception.GenericException;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.CreateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.ResponseHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.service.location.LocationFactory;

@Component
public class HolidayFactoryImpl implements HolidayFactory {

  @Autowired private LocationFactory locationFactory;

  @Override
  public Holiday mapFromCreateDTO(CreateHolidayDTO createHolidayDTO, Location location) {

    Holiday holiday = this.mapFromCreateDTO(createHolidayDTO);
    holiday.setLocation(location);
    return holiday;
  }

  @Override
  public Holiday mapFromCreateDTO(CreateHolidayDTO createHolidayDTO) {

    Holiday holiday = new Holiday();
    holiday.setTitle(createHolidayDTO.getTitle());
    holiday.setStartDate(createHolidayDTO.getStartDate());
    holiday.setDuration(createHolidayDTO.getDuration());
    holiday.setFreeSlots(createHolidayDTO.getFreeSlots());

    if (createHolidayDTO.getPrice() == null || createHolidayDTO.getPrice().isBlank()) {
      return holiday;
    }

    if (!NumberUtils.isCreatable(createHolidayDTO.getPrice())) {
      throw new GenericException(GenericException.INVALID_PRICE_FORMAT_MESSAGE);
    }

    holiday.setPrice(new BigDecimal(createHolidayDTO.getPrice()));
    return holiday;
  }

  @Override
  public ResponseHolidayDTO mapToResponseDTO(Holiday holiday) {

    ResponseHolidayDTO responseHolidayDTO = new ResponseHolidayDTO();
    responseHolidayDTO.setId(holiday.getId());
    responseHolidayDTO.setTitle(holiday.getTitle());
    responseHolidayDTO.setStartDate(holiday.getStartDate());
    responseHolidayDTO.setDuration(holiday.getDuration());
    if (holiday.getPrice() != null) {
      responseHolidayDTO.setPrice(holiday.getPrice().doubleValue());
    }
    responseHolidayDTO.setFreeSlots(holiday.getFreeSlots());

    Location location = holiday.getLocation();

    if (location != null) {
      responseHolidayDTO.setLocation(locationFactory.mapToResponseDTO(location));
    }

    return responseHolidayDTO;
  }
}
