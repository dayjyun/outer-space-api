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

   /**
    * Returns a list of all planet records in the database.
    * If the list is empty, a NotFoundException is thrown.
    * @return a list of all planets
    * throws NotFoundException: No planets found
    */
   public List<Planet> getAllPlanets() {
      List<Planet> allPlanets = planetRepository.findAll();
      if(allPlanets.isEmpty()) {
         throw new NotFoundException("No planets found");
      }
      return allPlanets;
   }

   /**
    * Searches through the database and returns an Optional of the planet record with the specified ID
    * If the planet is not found with the specified ID, a NotFoundException is thrown.
    * @param planetId
    * @return Planet Optional containing details about the planet record
    * throws NotFoundException: Planet with ID planetId is not found
    */

   public Optional<Planet> getPlanetById(Long planetId) {
      Optional<Planet> planet = planetRepository.findById(planetId);
      if(planet.isPresent()) {
         return planet;
      } else {
         throw new NotFoundException("Planet with ID " + planetId + " is not found");
      }
   }

   /**
    * Creates a new planet record with the Planet's data saved into the database
    * An Optional is used to check for a logged-in user
    * Then it checks if the name of the planet provided is used by a different planet. If it does, it will throw a AlreadyExistsException
    * If the check for the Planet's name passes, it will complete another check to make sure the Astronomer enters a name. If no name is
    * provided, it will throw a NotFoundException
    * @param planetBody
    * @return Newly created Planet object
    * throws AlreadyExistException: Your new Planet needs a name
    * throws NotFoundException: Your new Planet needs a name
    */

   public Planet createPlanet(Planet planetBody) {
      Optional<Planet> planet = planetRepository.findPlanetByNameAndAstronomerId(planetBody.getName(), AstronomerService.getLoggedInAstronomer().getId());
      if(planet.isPresent()) {
         throw new AlreadyExistsException("Planet with the name " + planet.get().getName()  + " already exists");
      } else {
         if(planetBody.getName().isEmpty() || planetBody.getName() == null) {
            throw new NotFoundException("Your new Planet needs a name");
         } else {
            planetBody.setAstronomer(AstronomerService.getLoggedInAstronomer());
            return planetRepository.save(planetBody);
         }
      }
   }

   /**
    * Updates an existing Planet record by searching the given Planet ID.
    * Throws a NotFoundException if the ID given is not found within the database
    * Then it checks if the name of the planet provided is used by a different planet. If it does, it will throw a AlreadyExistsException
    * If the check for the Planet's name passes, it will complete another check to make sure the Astronomer enters a name for the Planet as
    * the
    * name field cannot be empty
    * @param planetId
    * @param planetBody
    * @return Updated Planet object
    * throws NotFoundException: Planet with ID planetId is not found
    * throws AlreadyExistsException: Planet with the name planet.getName already exists
    */

   public Planet updatePlanet(Long planetId, Planet planetBody) {
      Optional<Planet> planet = planetRepository.findPlanetByIdAndAstronomerId(planetId, AstronomerService.getLoggedInAstronomer().getId());
      if(planet.isPresent()) {
         if(planet.get().getName().equals(planetBody.getName())) {
            throw new AlreadyExistsException("Planet with the name " + planet.get().getName()  + " already exists");
         } else {
            Planet updatedPlanet = planetRepository.findById(planetId).get();
            updatedPlanet.setDistanceFromSun(planetBody.getDistanceFromSun());
            updatedPlanet.setLengthOfYear(planetBody.getLengthOfYear());
            updatedPlanet.setSizeComparedToEarth(planetBody.getSizeComparedToEarth());
            updatedPlanet.setHabitable(planetBody.isHabitable());
            return planetRepository.save(updatedPlanet);
         }
      } else {
         throw new NotFoundException("Planet with ID " + planetId + " is not found");
      }
   }

   /**
    * Removes a planet from the database by searching through the given Planet ID
    * If the Planet is not found with the given ID, a NotFoundException is thrown
    * @param planetId
    * @return Details of deleted Planet
    * throws NotFoundException: Planet with ID planetID is not found
    */

   public Optional<Planet> deletePlanet(Long planetId) {
      Optional<Planet> planet = planetRepository.findPlanetByIdAndAstronomerId(planetId, AstronomerService.getLoggedInAstronomer().getId());
      if(planet.isPresent()) {
         planetRepository.deleteById(planetId);
         return planet;
      } else {
         throw new NotFoundException("Planet with ID " + planetId + " is not found");
      }
   }
}
