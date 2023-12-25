package pu.fmi.webserver.courseproject.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;

public interface HolidayRepository
    extends JpaRepository<Holiday, Long>, JpaSpecificationExecutor<Holiday> {}
