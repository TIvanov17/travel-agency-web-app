package pu.fmi.webserver.courseproject.travelagency.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pu.fmi.webserver.courseproject.travelagency.exception.ErrorResponse;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.CreateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.ResponseHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.dto.UpdateHolidayDTO;
import pu.fmi.webserver.courseproject.travelagency.service.holiday.HolidayService;

@RestController
@RequestMapping(path = "/holidays")
public class HolidayApi {

  @Autowired private HolidayService holidayService;

  @Operation(summary = "Create a holiday from the provided fields")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully create the holiday",
      content = {@Content(schema = @Schema(implementation = ResponseHolidayDTO.class))})
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<ResponseHolidayDTO> createHoliday(
      @Valid @RequestBody CreateHolidayDTO createHolidayDTO) {
    return ResponseEntity.ok(this.holidayService.addHoliday(createHolidayDTO));
  }

  @Operation(summary = "Delete a holiday by ID")
  @ApiResponse(responseCode = "200", description = "Successfully deleted the holiday")
  @RequestMapping(path = "/{holidayId}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> deleteHoliday(@PathVariable Long holidayId) {
    return ResponseEntity.ok(this.holidayService.deleteHolidayById(holidayId));
  }

  @Operation(summary = "Get all holidays")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully get all holidays",
      content = {
        @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseHolidayDTO.class)))
      })
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ResponseHolidayDTO>> getHolidays(
      @RequestParam(required = false) String location,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) Integer duration) {
    return ResponseEntity.ok(this.holidayService.findHolidaysBy(location, startDate, duration));
  }

  @Operation(summary = "Get a holiday by ID")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully get the holiday",
      content = {@Content(schema = @Schema(implementation = ResponseHolidayDTO.class))})
  @ApiResponse(
      responseCode = "404",
      description = "Holiday not found",
      content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
  @RequestMapping(path = "/{holidayId}", method = RequestMethod.GET)
  public ResponseEntity<ResponseHolidayDTO> getHolidayBy(@PathVariable Long holidayId) {
    return ResponseEntity.ok(this.holidayService.findHolidayById(holidayId));
  }

  @Operation(summary = "Update a holiday by with provided fields")
  @ApiResponse(
      responseCode = "200",
      description = "Successfully update the holiday",
      content = {@Content(schema = @Schema(implementation = ResponseHolidayDTO.class))})
  @ApiResponse(
      responseCode = "404",
      description = "Holiday not found",
      content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
  public ResponseEntity<ResponseHolidayDTO> updateHoliday(
      @Valid @RequestBody UpdateHolidayDTO updateHolidayDTO) {
    return ResponseEntity.ok(this.holidayService.updateHoliday(updateHolidayDTO));
  }
}
