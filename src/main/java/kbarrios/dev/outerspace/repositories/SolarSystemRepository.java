package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {
   Optional<SolarSystem> findByName(String name);
//   SolarSystem findSolarSystemById(Long solarSystemId);

//   SolarSystem findSolarSystemByName(String solarSystemName);

//   List<SolarSystem> getAllSolarSystems();
}
