package pu.fmi.webserver.courseproject.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {}
