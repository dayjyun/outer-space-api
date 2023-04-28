package kbarrios.dev.outerspace.models;

public class Astronomer {
   private Long id;
   private String username;
   private String email;
   private String password;

   public Astronomer() {}

   public Astronomer(Long id, String username, String email, String password) {
      this.id = id;
      this.username = username;
      this.email = email;
      this.password = password;
   }
}
