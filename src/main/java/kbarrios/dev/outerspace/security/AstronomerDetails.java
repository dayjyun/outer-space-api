package kbarrios.dev.outerspace.security;

import kbarrios.dev.outerspace.models.Astronomer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class AstronomerDetails implements UserDetails {
   private final Astronomer astronomer;

   public AstronomerDetails(Astronomer astronomer) {
      this.astronomer = astronomer;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return new HashSet<>();
   }

   @Override
   public String getPassword() {
      return astronomer.getPassword();
   }

   @Override
   public String getUsername() {
      return astronomer.getEmail();
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   public Astronomer getAstronomer() {
      return astronomer;
   }
}
