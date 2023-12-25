package pu.fmi.webserver.courseproject.travelagency.repository.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import pu.fmi.webserver.courseproject.travelagency.model.holiday.Holiday;
import pu.fmi.webserver.courseproject.travelagency.model.location.Location;

public class HolidaySpecification {

  public static Specification<Holiday> searchHolidayFilterBy(
      String location, LocalDate startDate, Integer duration) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> searchPredicates = new ArrayList<>();

      if (location != null) {
        Join<Holiday, Location> holidayLocation = root.join("location");
        Predicate locationCityOrCountryPredicate =
            criteriaBuilder.or(
                criteriaBuilder.equal(holidayLocation.get("city"), location),
                criteriaBuilder.equal(holidayLocation.get("country"), location));
        searchPredicates.add(locationCityOrCountryPredicate);
      }

      if (startDate != null) {
        Predicate startDatePredicate = criteriaBuilder.equal(root.get("startDate"), startDate);
        searchPredicates.add(startDatePredicate);
      }

      if (duration != null) {
        Predicate durationPredicate =
            criteriaBuilder.equal(root.get("duration"), duration.intValue());
        searchPredicates.add(durationPredicate);
      }

      return criteriaBuilder.and(searchPredicates.toArray(new Predicate[0]));
    };
  }
}
