package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
   Optional<Planet> findPlanetByNameAndAstronomerId(String planetName, Long astronomerId);

   Optional<Planet> findPlanetByIdAndAstronomerId(Long planetId, Long astronomerId);

   Optional<Planet> findPlanetByNameAndSolarSystemId(String planetName, Long solarSystemId);
}
