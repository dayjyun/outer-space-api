package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.Planet;
import kbarrios.dev.outerspace.repositories.PlanetRepository;
import kbarrios.dev.outerspace.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
