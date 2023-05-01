package kbarrios.dev.outerspace.controllers;

import kbarrios.dev.outerspace.models.Astronomer;
import kbarrios.dev.outerspace.models.login.LoginRequest;
import kbarrios.dev.outerspace.service.AstronomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping(path = "/login")
   public ResponseEntity<?> loginAstronomer(@RequestBody LoginRequest loginRequest) { return astronomerService.loginUser(loginRequest); }
}
