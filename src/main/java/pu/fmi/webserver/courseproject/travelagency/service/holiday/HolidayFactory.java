package pu.fmi.webserver.courseproject.travelagency.service.holiday;

import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.CreateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.ResponseHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.service.GenericEntityFactory;

public interface HolidayFactory
    extends GenericEntityFactory<Holiday, CreateHolidayDTO, ResponseHolidayDTO> {

  Holiday mapFromCreateDTO(CreateHolidayDTO createHolidayDTO, Location location);
}
