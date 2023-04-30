package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.Astronomer;
import kbarrios.dev.outerspace.service.AstronomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth/astronomers")
public class AstronomerController {
   private AstronomerService astronomerService;

   @Autowired
   public void setAstronomerService(AstronomerService astronomerService) {
      this.astronomerService = astronomerService;
   }

   @PostMapping(path = "/register")
   public Astronomer createAstronomer(@RequestBody Astronomer astronomerBody) {
      return astronomerService.createAstronomer(astronomerBody);
   }
}
