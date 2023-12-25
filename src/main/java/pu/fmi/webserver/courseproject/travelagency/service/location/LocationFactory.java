package pu.fmi.webserver.courseproject.travelagency.service.location;

import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.CreateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.ResponseLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.service.GenericEntityFactory;

public interface LocationFactory
    extends GenericEntityFactory<Location, CreateLocationDTO, ResponseLocationDTO> {}
