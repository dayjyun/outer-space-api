package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {
   Optional<SolarSystem> findByName(String name);

   Optional<SolarSystem> findSolarSystemByNameAndAstronomerId(String solarSystemName, Long astronomerId);

   Optional<SolarSystem> findSolarSystemByIdAndAstronomerId(Long solarSystemId, Long astronomerId);
}
