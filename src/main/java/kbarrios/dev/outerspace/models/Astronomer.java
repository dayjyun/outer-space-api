package kbarrios.dev.outerspace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name="astronomers")
public class Astronomer {
   @Column
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;

   @Column(unique = true)
   private String username;

   @Column(unique = true, nullable = false)
   @Email(message = "Please provide a valid email")
   private String email;

   @Column
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private String password;

   // Astronomer belongs to many Planets
   @OneToMany(mappedBy = "astronomer")
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Planet> planetList;

   // Astronomer belongs to many Solar Systems
   @OneToMany(mappedBy = "astronomer")
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<SolarSystem> solarSystemsList;

   public Astronomer() {}

   public Astronomer(Long id, String name, String username, String email, String password) {
      this.id = id;
      this.name = name;
      this.username = username;
      this.email = email;
      this.password = password;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "Astronomer{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", username='" + username + '\'' +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
}
