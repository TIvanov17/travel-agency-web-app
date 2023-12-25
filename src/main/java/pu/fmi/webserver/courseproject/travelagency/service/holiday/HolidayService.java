package pu.fmi.webserver.courseproject.travelagency.service.holiday;

import java.time.LocalDate;
import java.util.List;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.CreateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.ResponseHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.UpdateHolidayDTO;

public interface HolidayService {

  ResponseHolidayDTO addHoliday(CreateHolidayDTO createHolidayDTO);

  boolean deleteHolidayById(Long id);

  List<ResponseHolidayDTO> findHolidaysBy(String location, LocalDate startDate, Integer duration);

  Holiday getHoliday(Long id);

  ResponseHolidayDTO findHolidayById(Long id);

  ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);
}
