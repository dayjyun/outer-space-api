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
         throw new NotFoundException("No planets found");
      } else {
         return allPlanets;
      }
   }

   public Optional<Planet> getPlanetById(Long planetId) {
      Optional<Planet> planet = planetRepository.findById(planetId);
      if(planet.isPresent()) {
         return planet;
      } else {
         throw new NotFoundException("Planet with ID " + planetId + " is not found");
      }
   }

   public Optional<Planet> createPlanet(Planet planetBody) {
      Optional<Planet> planet = planetRepository.findPlanetByName(planetBody.getName());
      if(planet.isPresent()) {
         throw new AlreadyExistsException("Planet with the name " + planet.get().getName()  + " already exists");
      } else {
         if(planetBody.getName().isEmpty() || planetBody.getName() == null) {
            throw new NotFoundException("Planet enter a name for your planet");
         } else {
            return Optional.of(planetRepository.save(planetBody));
         }
      }
   }

   public Optional<Planet> updatePlanet(Long planetId, Planet planetBody) {
      Optional<Planet> planet = planetRepository.findById(planetId);
      if(planet.isPresent()) {
         if(planetBody.getName().equals(planet.get().getName())) {
            throw new AlreadyExistsException("Planet with the name " + planet.get().getName()  + " already exists");
         } else {
            Planet updatedPlanet = planetRepository.findById(planetId).get();
            updatedPlanet.setName(planetBody.getName());
            updatedPlanet.setDistanceFromSun(planetBody.getDistanceFromSun());
            updatedPlanet.setLengthOfYear(planetBody.getLengthOfYear());
            updatedPlanet.setSizeComparedToEarth(planetBody.getSizeComparedToEarth());
            updatedPlanet.setHabitable(planetBody.isHabitable());
            return Optional.of(planetRepository.save(updatedPlanet));
         }
      } else {
         throw new NotFoundException("Planet with ID " + planetId + " is not found");
      }
   }

   public Optional<Planet> deletePlanet(Long planetId) {
      Optional<Planet> planet = planetRepository.findById(planetId);
      if(planet.isPresent()) {
         planetRepository.deleteById(planetId);
         return planet;
      } else {
         throw new NotFoundException("Planet with ID " + planetId + " is not found");
      }
   }
}
