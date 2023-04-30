package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.repositories.AstronomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AstronomerService {
   private final AstronomerRepository astronomerRepository;
   private final PasswordEncoder passwordEncoder;

   public AstronomerService(AstronomerRepository astronomerRepository, PasswordEncoder passwordEncoder) {
      this.astronomerRepository = astronomerRepository;
      this.passwordEncoder = passwordEncoder;
   }
}
