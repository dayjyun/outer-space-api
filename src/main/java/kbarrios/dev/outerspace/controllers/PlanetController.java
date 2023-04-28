package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/planets")
public class PlanetController {
   private PlanetRepository planetRepository;

   @Autowired
   public void setPlanetRepository(PlanetRepository planetRepository) {
      this.planetRepository = planetRepository;
   }
}
