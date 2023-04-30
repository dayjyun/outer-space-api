package kbarrios.dev.outerspace.security;

import kbarrios.dev.outerspace.models.Astronomer;
import kbarrios.dev.outerspace.service.AstronomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AstronomerDetailsService implements UserDetailsService {
   private AstronomerService astronomerService;

   @Autowired
   public void setAstronomerService(AstronomerService astronomerService) {
      this.astronomerService = astronomerService;
   }

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Astronomer astronomer = astronomerService.findAstronomerByEmail(email);
      return new AstronomerDetails(astronomer);
   }
}
