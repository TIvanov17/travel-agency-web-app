package pu.fmi.webserver.courseproject.travelagency;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Travel Agency", description = "A very simple APIs"))
@EnableJpaAuditing
public class TravelAgencyApplication {

  public static void main(String[] args) {
    SpringApplication.run(TravelAgencyApplication.class, args);
  }
}
