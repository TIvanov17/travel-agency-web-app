package pu.fmi.webserver.courseproject.travelagency.service.location;

import org.springframework.stereotype.Component;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.CreateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.ResponseLocationDTO;

@Component
public class LocationFactoryImpl implements LocationFactory {

  @Override
  public Location mapFromCreateDTO(CreateLocationDTO createLocationDTO) {
    Location location = new Location();
    location.setCity(createLocationDTO.getCity());
    location.setCountry(createLocationDTO.getCountry());
    location.setStreet(createLocationDTO.getStreet());
    location.setNumber(createLocationDTO.getNumber());
    location.setImageUrl(createLocationDTO.getImageUrl());
    return location;
  }

  @Override
  public ResponseLocationDTO mapToResponseDTO(Location location) {
    ResponseLocationDTO responseLocationDTO = new ResponseLocationDTO();
    responseLocationDTO.setId(location.getId());
    responseLocationDTO.setCity(location.getCity());
    responseLocationDTO.setCountry(location.getCountry());
    responseLocationDTO.setStreet(location.getStreet());
    responseLocationDTO.setNumber(location.getNumber());
    responseLocationDTO.setImageUrl(location.getImageUrl());
    return responseLocationDTO;
  }
}
