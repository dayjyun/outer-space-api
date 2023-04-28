package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.SolarSystem;
import kbarrios.dev.outerspace.repositories.SolarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/solar-systems")
public class SolarSystemController {
   private SolarSystemRepository solarSystemRepository;

   @Autowired
   public void setSolarSystemRepository(SolarSystemRepository solarSystemRepository) {
      this.solarSystemRepository = solarSystemRepository;
   }

   @GetMapping(path = "")
   public List<SolarSystem> getAllSolarSystems() {
      return solarSystemRepository.findAll();
   }
}
