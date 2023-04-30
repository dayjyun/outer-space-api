package kbarrios.dev.outerspace.service;

import kbarrios.dev.outerspace.exceptions.AlreadyExistsException;
import kbarrios.dev.outerspace.models.Astronomer;
import kbarrios.dev.outerspace.models.login.LoginRequest;
import kbarrios.dev.outerspace.models.login.LoginResponse;
import kbarrios.dev.outerspace.repositories.AstronomerRepository;
import kbarrios.dev.outerspace.security.AstronomerDetails;
import kbarrios.dev.outerspace.security.AstronomerDetailsService;
import kbarrios.dev.outerspace.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AstronomerService {
   private final AstronomerRepository astronomerRepository;
   private final PasswordEncoder passwordEncoder;
   private final JWTUtils jwtUtils;
   private final AuthenticationManager authenticationManager;
   private AstronomerDetailsService astronomerDetailsService;

   @Autowired
   public AstronomerService(AstronomerRepository astronomerRepository,
                            @Lazy PasswordEncoder passwordEncoder,
                            JWTUtils jwtUtils,
                            @Lazy AuthenticationManager authenticationManager,
                            @Lazy AstronomerDetailsService astronomerDetailsService) {
      this.astronomerRepository = astronomerRepository;
      this.passwordEncoder = passwordEncoder;
      this.jwtUtils = jwtUtils;
      this.authenticationManager = authenticationManager;
      this.astronomerDetailsService = astronomerDetailsService;
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

   public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
      try {
         Authentication authentication = authenticationManager
                 .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
         SecurityContextHolder.getContext().setAuthentication(authentication);
          astronomerDetails = (AstronomerDetails) authentication.getPrincipal();
         final String JWT = jwtUtils.generateJwtToken(astronomerDetails);
         return ResponseEntity.ok(new LoginResponse(JWT));
      } catch (Exception e) {
         return ResponseEntity.ok(new LoginResponse("Error : user name or password is incorrect"));
      }UsernamePasswordAuthenticationToken
   }
}
