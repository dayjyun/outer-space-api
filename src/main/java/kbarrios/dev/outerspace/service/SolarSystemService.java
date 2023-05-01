package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.exceptions.AlreadyExistsException;
import kbarrios.dev.outerspace.exceptions.NotFoundException;
import kbarrios.dev.outerspace.models.Planet;
import kbarrios.dev.outerspace.models.SolarSystem;
import kbarrios.dev.outerspace.repositories.PlanetRepository;
import kbarrios.dev.outerspace.repositories.SolarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarSystemService {
   private SolarSystemRepository solarSystemRepository;
   private PlanetRepository planetRepository;

   @Autowired
   public void setSolarSystemRepository(SolarSystemRepository solarSystemRepository) {
      this.solarSystemRepository = solarSystemRepository;
   }

   @Autowired
   public void setPlanetRepository(PlanetRepository planetRepository) {
      this.planetRepository = planetRepository;
   }

   /**
    * Returns a list of all Solar System records found in the database
    * If no list is found, a NotFoundException is thrown
    * @return Solar System list
    * throws NotFoundException: No Solar System found. Is this a new universe?
    */
   public List<SolarSystem> getAllSolarSystems() {
      List<SolarSystem> allSolarSystems = solarSystemRepository.findAll();
      if(allSolarSystems.isEmpty()) {
         throw new NotFoundException("No Solar Systems found. Is this a new universe?");
      }
      return solarSystemRepository.findAll();
   }

   /**
    * Returns an Optional for a Solar System record searched by its ID
    * If no Solar System is found by its ID, a NotFoundException is thrown
    * @param solarSystemId
    * @return Solar System Optional containing details of the Solar System record
    * throws NotFoundException: "I hate to say it, but it looks like the system you're searching for doesn't exist
    */

   public Optional<SolarSystem> getSolarSystemById(Long solarSystemId) {
      Optional<SolarSystem> solarSystem = solarSystemRepository.findById(solarSystemId);
      if (solarSystem.isPresent()) {
         return solarSystem;
      } else {
         throw new NotFoundException("I hate to say it, but it looks like the system you're searching for doesn't exist");
      }
   }

   /**
    * Creates a new Solar System record with the Solar System's data saved into the database
    * An Optional is used to check for the logged-in user
    * Then it checks if the name of the Solar System exists in the universe. If it does, it will throw an AlreadyExistsException
    * If the check for the Solar System's name passes, it will complete another check to make sure the Astronomer enters a name for the
    * Solar System as the name field cannot be empty
    * @param solarSystemBody
    * @return Newly Created Solar System object
    * throws AlreadyExistsException: Solar System with the name solarSystem.getName already exists
    * throws NotFoundException: Solar System needs a name
    */


   public SolarSystem createSolarSystem(SolarSystem solarSystemBody) {
      Optional<SolarSystem> solarSystem = solarSystemRepository.findSolarSystemByNameAndAstronomerId(solarSystemBody.getName(),
              AstronomerService.getLoggedInAstronomer().getId());
      if (solarSystem.isPresent()) {
         throw new AlreadyExistsException("Solar System with the name " + solarSystem.get().getName() + " already exists");
      } else {
         if (solarSystemBody.getName().isEmpty() || solarSystemBody.getName() == null) {
             throw new NotFoundException("Solar System needs a name");
         } else {
            solarSystemBody.setAstronomer(AstronomerService.getLoggedInAstronomer());
            return solarSystemRepository.save(solarSystemBody);
         }
      }
   }

   /**
    * Creates a new Planet record for the given Solar System record by using the Solar System's ID and is saved withn the Solar System's
    * list of Planets into the database
    * An Optional is used to check for the logged-in user
    * Then it checks if the name of the Planet exists within the Solar System. If it does, it will throw an AlreadyExistsException
    * If the check for the Planet's name passes, it will save the record of the newly created Planet
    * @param solarSystemId
    * @param planetBody
    * @return Newly created Planet Object
    * throws NotFoundException: Solar System with ID solarSystemId does not exist
    * throws AlreadyExistsException: Planet with that name already exists in the Solar System
    */

   public Planet createPlanetForSolarSystem(Long solarSystemId, Planet planetBody) {
      Optional<SolarSystem> solarSystem = solarSystemRepository.findById(solarSystemId);
      if(solarSystem.isPresent()) {
         Optional<Planet> planet = planetRepository.findPlanetByNameAndSolarSystemId(planetBody.getName(), solarSystemId);
         if (planet.isPresent()) {
            throw new AlreadyExistsException("Planet with that name already exists in the Solar System");
         } else {
            planetBody.setAstronomer(AstronomerService.getLoggedInAstronomer());
            planetBody.setSolarSystem(solarSystem.get());
            return planetRepository.save(planetBody);
         }
      } else {
         throw new NotFoundException("Solar System with ID " + solarSystemId + " does not exist");
      }
   }

   /**
    * Updates an existing Solar System record by searching the given Solar System ID.
    * Throws a NotFoundException if the ID given is not found within the database
    * If the check for the Solar System's name passes, it will complete another check to make sure the Astronomer enters a name for the
    * Solar System as the name field canonot be empty
    * @param solarSystemId
    * @param solarSystemBody
    * @return Updated Solar System object
    * throws NotFoundException: I hate to say it, but it looks like the system you're searching for doesn't exist
    * throws AlreadyExistsException: Solar System with the name solarSystem.getName already exists
    */

   public SolarSystem updateSolarSystem(Long solarSystemId, SolarSystem solarSystemBody){
      Optional<SolarSystem> solarSystem = solarSystemRepository.findSolarSystemByIdAndAstronomerId(solarSystemId, AstronomerService.getLoggedInAstronomer().getId());
      if(solarSystem.isPresent()) {
         if(solarSystem.get().getName().equals(solarSystemBody.getName())) {
            throw new AlreadyExistsException("Solar system with the name " +  solarSystem.get().getName() + " already exists");
         } else {
            SolarSystem updatedSolarSystem = solarSystemRepository.findById(solarSystemId).get();
//            updatedSolarSystem.setName(solarSystemBody.getName());
            updatedSolarSystem.setAgeInBillions(solarSystemBody.getAgeInBillions());
            updatedSolarSystem.setType(solarSystemBody.getType());
            updatedSolarSystem.setSizeComparedToEarth(solarSystemBody.getSizeComparedToEarth());
            return solarSystemRepository.save(updatedSolarSystem);
         }
      } else {
         throw new NotFoundException("I hate to say it, but it looks like the system you're searching for doesn't exist");
      }
   }

   /**
    * Removes a Solar System from the database by searching through the given Solar System ID
    * If the Solar System is not found with the given ID, a NotFoundException is thrown
    * @param solarSystemId
    * @return Details of deleted Solar System
    * throws NotFoundException: I hate to say it, but it looks like the system you're searching for doesn't exist
    */

   public Optional<SolarSystem> deleteSolarSystem(Long solarSystemId) {
      Optional<SolarSystem> solarSystem = solarSystemRepository.findSolarSystemByIdAndAstronomerId(solarSystemId, AstronomerService.getLoggedInAstronomer().getId());
      if(solarSystem.isPresent()) {
            solarSystemRepository.deleteById(solarSystemId);
            return solarSystem;
      } else {
         throw new NotFoundException("I hate to say it, but it looks like the system you're searching for doesn't exist");
      }
   }
}
