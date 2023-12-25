package pu.fmi.webserver.courseproject.travelagency.service.location;

import java.util.List;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.CreateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.ResponseLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.UpdateLocationDTO;

public interface LocationService {

  ResponseLocationDTO addLocation(CreateLocationDTO createLocationDTO);

  boolean deleteLocationById(Long id);

  List<ResponseLocationDTO> getAllLocations();

  ResponseLocationDTO findLocationById(Long id);

  Location getLocation(Long id);

  ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);
}
