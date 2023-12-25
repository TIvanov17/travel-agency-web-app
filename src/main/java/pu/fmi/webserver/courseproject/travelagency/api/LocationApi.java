package pu.fmi.webserver.courseproject.travelagency.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pu.fmi.webserver.courseproject.travelagency.exception.ErrorResponse;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.CreateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.ResponseLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.location.dto.UpdateLocationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.ResponseReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.service.location.LocationService;

@RestController
@RequestMapping(path = "/locations")
public class LocationApi {

  @Autowired private LocationService locationService;

  @Operation(summary = "Create a location from the provided fields")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully created the location",
      content = {@Content(schema = @Schema(implementation = ResponseLocationDTO.class))})
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<ResponseLocationDTO> createLocation(
      @RequestBody CreateLocationDTO createLocationDTO) {
    return ResponseEntity.ok(this.locationService.addLocation(createLocationDTO));
  }

  @Operation(summary = "Delete a location by ID")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted the location")
      })
  @RequestMapping(path = "/{locationId}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> deleteLocation(@PathVariable Long locationId) {
    return ResponseEntity.ok(this.locationService.deleteLocationById(locationId));
  }

  @Operation(summary = "Get all locations")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully get all locations",
      content = {
        @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseLocationDTO.class)))
      })
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ResponseLocationDTO>> getAllLocations() {
    return ResponseEntity.ok(this.locationService.getAllLocations());
  }

  @Operation(summary = "Get a location by ID")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully get the location",
      content = {@Content(schema = @Schema(implementation = ResponseReservationDTO.class))})
  @ApiResponse(
      responseCode = "404",
      description = "Location not found",
      content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
  @RequestMapping(path = "/{locationId}", method = RequestMethod.GET)
  public ResponseEntity<ResponseLocationDTO> getLocationBy(@PathVariable Long locationId) {
    return ResponseEntity.ok(this.locationService.findLocationById(locationId));
  }

  @Operation(summary = "Update a location by with provided fields")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully update the location",
      content = {@Content(schema = @Schema(implementation = ResponseReservationDTO.class))})
  @ApiResponse(
      responseCode = "404",
      description = "Location not found",
      content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
  public ResponseEntity<ResponseLocationDTO> updateLocation(
      @RequestBody UpdateLocationDTO updateLocationDTO) {
    return ResponseEntity.ok(this.locationService.updateLocation(updateLocationDTO));
  }
}
