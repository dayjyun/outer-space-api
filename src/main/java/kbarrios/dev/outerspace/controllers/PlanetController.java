package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.Planet;
import kbarrios.dev.outerspace.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/planets")
public class PlanetController {
   private PlanetService planetService;

   @Autowired
   public void setPlanetService(PlanetService planetService) {
      this.planetService = planetService;
   }

   @GetMapping(path = "")
   public List<Planet> getAllPlanets() {
      return planetService.getAllPlanets();
   }

   @GetMapping(path="/{planetId}")
   public Optional<Planet> getPlanetById(@PathVariable @Valid Long planetId) {
      return planetService.getPlanetById(planetId);
   }

   @PostMapping(path = "")
   public Optional<Planet> createPlanet(@RequestBody @Valid Planet planetBody) {
      return planetService.createPlanet(planetBody);
   }

   @PutMapping(path = "/{planetId}")
   public Optional<Planet> updatePlanet(@PathVariable Long planetId, @RequestBody Planet planetBody) {
      return planetService.updatePlanet(planetId, planetBody);
   }

   @DeleteMapping(path = "/{planetId}")
   public Optional<Planet> deletePlanet(@PathVariable Long planetId) {
      return planetService.deletePlanet(planetId);
   }
}
