package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.exceptions.NotFoundException;
import kbarrios.dev.outerspace.models.Planet;
import kbarrios.dev.outerspace.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
