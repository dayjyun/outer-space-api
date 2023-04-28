package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {
//   SolarSystem findSolarSystemById(Long solarSystemId);

   SolarSystem findSolarSystemByName(String solarSystemName);

//   List<SolarSystem> getAllSolarSystems();
}
