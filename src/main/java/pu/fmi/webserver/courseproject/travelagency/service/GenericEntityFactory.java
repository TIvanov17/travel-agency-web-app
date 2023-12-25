package pu.fmi.webserver.courseproject.travelagency.service;

public interface GenericEntityFactory<Entity, CreateDTO, ResponseDTO> {

  Entity mapFromCreateDTO(CreateDTO createDTO);

  ResponseDTO mapToResponseDTO(Entity holiday);
}
