package kbarrios.dev.outerspace.security;

import kbarrios.dev.outerspace.models.Astronomer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AstronomerDetails implements UserDetails {
   private Astronomer astronomer;

   public AstronomerDetails(Astronomer astronomer) {
      this.astronomer = astronomer;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
   }

   @Override
   public String getPassword() {
      return null;
   }

   @Override
   public String getUsername() {
      return null;
   }

   @Override
   public boolean isAccountNonExpired() {
      return false;
   }

   @Override
   public boolean isAccountNonLocked() {
      return false;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return false;
   }

   @Override
   public boolean isEnabled() {
      return false;
   }

   public Astronomer getAstronomer() {
      return astronomer;
   }
}
