package pu.fmi.webserver.courseproject.travelagency.service.location;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.fmi.webserver.courseproject.travelagency.exception.NotFoundException;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.CreateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.ResponseLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.UpdateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired private LocationRepository locationRepository;
  @Autowired private LocationFactory locationFactory;

  @Override
  public ResponseLocationDTO addLocation(CreateLocationDTO createLocationDTO) {
    Location location = locationFactory.mapFromCreateDTO(createLocationDTO);
    return this.locationFactory.mapToResponseDTO(this.locationRepository.save(location));
  }

  @Override
  public boolean deleteLocationById(Long id) {

    Optional<Location> optionalOfLocation = this.locationRepository.findById(id);
    if (optionalOfLocation.isPresent()) {
      this.locationRepository.delete(optionalOfLocation.get());
      return true;
    }

    return false;
  }

  @Override
  public List<ResponseLocationDTO> getAllLocations() {
    return this.locationRepository.findAll().stream()
        .map(l -> locationFactory.mapToResponseDTO(l))
        .toList();
  }

  @Override
  public ResponseLocationDTO findLocationById(Long id) {

    Optional<Location> optionalOfHoliday = this.locationRepository.findById(id);

    if (optionalOfHoliday.isPresent()) {
      return this.locationFactory.mapToResponseDTO(optionalOfHoliday.get());
    }

    throw new NotFoundException("Cannot Find Location With Id = " + id);
  }

  @Override
  public Location getLocation(Long id) {
    return this.locationRepository.findById(id).orElse(null);
  }

  @Override
  public ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO) {

    Location location = this.getLocation(updateLocationDTO.getId());

    if (location == null) {
      throw new NotFoundException("Cannot Find Location With Id = " + updateLocationDTO.getId());
    }

    location.setCity(updateLocationDTO.getCity());
    location.setCountry(updateLocationDTO.getCountry());
    location.setStreet(updateLocationDTO.getStreet());
    location.setNumber(updateLocationDTO.getNumber());
    location.setImageUrl(updateLocationDTO.getImageUrl());

    return this.locationFactory.mapToResponseDTO(this.locationRepository.save(location));
  }
}
