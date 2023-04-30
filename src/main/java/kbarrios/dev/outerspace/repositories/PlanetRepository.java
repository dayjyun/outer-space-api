package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
   Planet findPlanetById(Long planetId);

   Optional<Planet> findPlanetByName(String planetName);
}
