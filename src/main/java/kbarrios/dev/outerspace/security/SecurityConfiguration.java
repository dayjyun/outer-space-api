package kbarrios.dev.outerspace.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
   private AstronomerDetailsService astronomerDetailsService;

   @Autowired
   public void setAstronomerDetailsService(AstronomerDetailsService astronomerDetailsService) {
      this.astronomerDetailsService = astronomerDetailsService;
   }

   @Bean
   public JwtRequestFilter authenticationJwtTokenFilter() {
      return new JwtRequestFilter();
   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers(
                  "/auth/users/register", "/auth/users/login"
          ).permitAll()
          .anyRequest().authenticated()
          .and().sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and().csrf().disable();
      http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
      return http.build();
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
      return authConfig.getAuthenticationManager();
   }

   @Bean
   public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(astronomerDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
      return authProvider;
   }

   @Bean
   @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
   public AstronomerDetails astronomerDetails() {
      return (AstronomerDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   }
}
