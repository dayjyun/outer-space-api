package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.Planet;
import kbarrios.dev.outerspace.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   // GET /api/planets/{planetId}
//   @GetMapping(path="/{planetId}")
//   public Optional<Planet> getPlanet

   // POST /api/planets
   @PostMapping(path = "")
   public Optional<Planet> createPlanet(@RequestBody Planet planetBody) {
      return planetService.createPlanet(planetBody);
   }

   // PUT /api/planets/{planetId}

   // DELETE /api/planets/{planetId}
}
