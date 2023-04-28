package kbarrios.dev.outerspace.service;

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
      if(solarSystem.isPresent()) {
         return solarSystem;
      } else {
         throw new NotFoundException("Solar system not found");
      }
   }
}
