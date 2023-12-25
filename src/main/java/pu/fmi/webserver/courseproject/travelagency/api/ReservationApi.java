package pu.fmi.webserver.courseproject.travelagency.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pu.fmi.webserver.courseproject.travelagency.exception.ErrorResponse;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.CreateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.ResponseReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.model.reservation.dto.UpdateReservationDTO;
import pu.fmi.webserver.courseproject.travelagency.service.reservation.ReservationService;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationApi {

  @Autowired private ReservationService reservationService;

  @Operation(summary = "Create a reservation from the provided fields")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully created the reservation",
      content = {@Content(schema = @Schema(implementation = ResponseReservationDTO.class))})
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<ResponseReservationDTO> createReservation(
      @RequestBody CreateReservationDTO createReservationDTO) {
    return ResponseEntity.ok(this.reservationService.addReservation(createReservationDTO));
  }

  @Operation(summary = "Delete a reservation by ID")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully deleted the reservation",
      content = {@Content(mediaType = "application/json")})
  @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> deleteReservation(@PathVariable Long reservationId) {
    return ResponseEntity.ok(this.reservationService.deleteReservation(reservationId));
  }

  @Operation(summary = "Get all reservations")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully get all reservation",
      content = {
        @Content(
            array = @ArraySchema(schema = @Schema(implementation = ResponseReservationDTO.class)))
      })
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ResponseReservationDTO>> getAllReservations() {
    return ResponseEntity.ok(this.reservationService.getAllReservations());
  }

  @Operation(summary = "Get a reservation by ID")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully get the reservation",
      content = {@Content(schema = @Schema(implementation = ResponseReservationDTO.class))})
  @ApiResponse(
      responseCode = "404",
      description = "Reservation not found",
      content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
  @RequestMapping(path = "/{reservationId}", method = RequestMethod.GET)
  public ResponseEntity<ResponseReservationDTO> getReservationById(
      @PathVariable Long reservationId) {
    return ResponseEntity.ok(this.reservationService.findReservationById(reservationId));
  }

  @Operation(summary = "Update a reservation by with provided fields")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully update the reservation",
      content = {@Content(schema = @Schema(implementation = ResponseReservationDTO.class))})
  @ApiResponse(
      responseCode = "404",
      description = "Reservation not found",
      content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
  public ResponseEntity<ResponseReservationDTO> updateReservation(
      @RequestBody UpdateReservationDTO updateReservationDTO) {
    return ResponseEntity.ok(this.reservationService.updateReservation(updateReservationDTO));
  }
}
