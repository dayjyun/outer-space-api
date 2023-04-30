package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.exceptions.AlreadyExistsException;
import kbarrios.dev.outerspace.models.Astronomer;
import kbarrios.dev.outerspace.repositories.AstronomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AstronomerService {
   private final AstronomerRepository astronomerRepository;
   private final PasswordEncoder passwordEncoder;

   @Autowired
   public AstronomerService(AstronomerRepository astronomerRepository, PasswordEncoder passwordEncoder) {
      this.astronomerRepository = astronomerRepository;
      this.passwordEncoder = passwordEncoder;
   }

   public Astronomer createAstronomer(Astronomer astronomerObject) {
      if(!astronomerRepository.existsAstronomerByEmail(astronomerObject.getEmail())) {
         astronomerObject.setPassword(passwordEncoder.encode(astronomerObject.getPassword()));
         return astronomerRepository.save(astronomerObject);
      } else {
         throw new AlreadyExistsException("Email address " + astronomerObject.getEmail() + " already exists");
      }
   }

   public Astronomer findAstronomerByEmail(String email) {
      return astronomerRepository.findAstronomerByEmail(email);
   }
}
