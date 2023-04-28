package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.repositories.SolarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolarSystemService {
   private SolarSystemRepository solarSystemRepository;

   @Autowired
   public void setSolarSystemRepository(SolarSystemRepository solarSystemRepository) {
      this.solarSystemRepository = solarSystemRepository;
   }
}
