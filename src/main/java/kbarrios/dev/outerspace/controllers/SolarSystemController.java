package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.SolarSystem;
import kbarrios.dev.outerspace.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

   @PostMapping(path="")
   public SolarSystem createSolarSystem(@RequestBody @Valid SolarSystem solarSystemBody) {
      return solarSystemService.createSolarSystem(solarSystemBody);
   }

//   @PostMapping(path="/{solarSystemId}/planets")

   @PutMapping(path = "/{solarSystemId}")
   public SolarSystem updateSolarSystem(@PathVariable Long solarSystemId, @RequestBody SolarSystem solarSystemBody) {
      return solarSystemService.updateSolarSystem(solarSystemId, solarSystemBody);
   }

   @DeleteMapping(path = "/{solarSystemId}")
   public Optional<SolarSystem> deleteSolarSystem(@PathVariable Long solarSystemId) {
      return solarSystemService.deleteSolarSystem(solarSystemId);
   }
}
