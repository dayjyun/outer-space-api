package kbarrios.dev.outerspace.repositories;

import kbarrios.dev.outerspace.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
   Planet findPlanetByName(String name);

   Planet findPlanetById(Long planetId);
}
