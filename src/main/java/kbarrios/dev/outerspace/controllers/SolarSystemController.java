package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.SolarSystem;
import kbarrios.dev.outerspace.repositories.SolarSystemRepository;
import kbarrios.dev.outerspace.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/solar-systems")
public class SolarSystemController {
   private SolarSystemService solarSystemService;

   @Autowired
   public void setSolarSystemService(SolarSystemService solarSystemService) {
      this.solarSystemService = solarSystemService;
   }

   @GetMapping(path = "")
   public List<SolarSystem> getAllSolarSystems() {
      return solarSystemService.getAllSolarSystems();
   }

   @GetMapping(path = "/{solarSystemId}")
   public Optional<SolarSystem> getSolarSystemById(@PathVariable Long solarSystemId) {
      return solarSystemService.getSolarSystemById(solarSystemId);
   }
}
