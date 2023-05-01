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

   public List<SolarSystem> getAllSolarSystems() {
      List<SolarSystem> allSolarSystems = solarSystemRepository.findAll();
      if(allSolarSystems.isEmpty()) {
         throw new NotFoundException("No Solar Systems found. Is this a new universe?");
      }
      return solarSystemRepository.findAll();
   }

   public Optional<SolarSystem> getSolarSystemById(Long solarSystemId) {
      Optional<SolarSystem> solarSystem = solarSystemRepository.findById(solarSystemId);
      if (solarSystem.isPresent()) {
         return solarSystem;
      } else {
         throw new NotFoundException("I hate to say it, but it looks like the system you're searching for doesn't exist");
      }
   }

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
