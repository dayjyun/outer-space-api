package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.exceptions.AlreadyExistsException;
import kbarrios.dev.outerspace.exceptions.NotFoundException;
import kbarrios.dev.outerspace.models.SolarSystem;
import kbarrios.dev.outerspace.repositories.SolarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SolarSystemService {
   private SolarSystemRepository solarSystemRepository;

   @Autowired
   public void setSolarSystemRepository(SolarSystemRepository solarSystemRepository) {
      this.solarSystemRepository = solarSystemRepository;
   }

   public List<SolarSystem> getAllSolarSystems() {
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
      Optional<SolarSystem> solarSystem = solarSystemRepository.findByName(solarSystemBody.getName());
      if (solarSystem.isPresent()) {
         throw new AlreadyExistsException("Solar System already exists");
      } else {
         if (solarSystemBody.getName().isEmpty() || solarSystemBody.getName() == null) {
             throw new NotFoundException("Solar System needs a name");
         } else {
            return solarSystemRepository.save(solarSystemBody);
         }
      }
   }
}
