package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.exceptions.AlreadyExistsException;
import kbarrios.dev.outerspace.exceptions.NotFoundException;
import kbarrios.dev.outerspace.models.Planet;
import kbarrios.dev.outerspace.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {
   private PlanetRepository planetRepository;

   @Autowired
   public void setPlanetRepository(PlanetRepository planetRepository) {
      this.planetRepository = planetRepository;
   }

   public List<Planet> getAllPlanets() {
      List<Planet> allPlanets = planetRepository.findAll();
      if(allPlanets.isEmpty()) {
         throw new NotFoundException("No planets found. Weird.");
      } else {
         return allPlanets;
      }
   }

   public Optional<Planet> createPlanet(Planet planetBody) {
      Optional<Planet> planet = planetRepository.findPlanetByName(planetBody.getName());
      if(planet.isPresent()) {
         throw new AlreadyExistsException("Planet with that name already exists");
      } else {
         if(planetBody.getName().isEmpty() || planetBody.getName() == null) {
            throw new NotFoundException("Planet needs a name");
         } else {
            return Optional.of(planetRepository.save(planetBody));
         }
      }
   }
}
