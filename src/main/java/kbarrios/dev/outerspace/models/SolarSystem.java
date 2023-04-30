package kbarrios.dev.outerspace.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kbarrios.dev.outerspace.service.AstronomerService;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="solar_systems")
public class SolarSystem {
   @Column
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   @NotNull(message = "Solar System needs a name")
   private String name;

   @Column
   private Long ageInBillions;

   @Column
   private String type;

   @Column
   private Long sizeComparedToEarth;

   @Column
   @CreationTimestamp
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH-mm-ss")
   private Timestamp createdAt;

   // Solar System belongs to many Planets
   @OneToMany(mappedBy = "solarSystem", orphanRemoval = true)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Planet> planetList;

   // Many Solar Systems belong to one Astronomer
   @ManyToOne
   @JoinColumn(name = "astronomer_id")
//   @JsonIgnore
   private Astronomer astronomer;

   public SolarSystem() {}

   public SolarSystem(Long id, String name, Long ageInBillions, String type, Long sizeComparedToEarth) {
      this.id = id;
      this.name = name;
      this.ageInBillions = ageInBillions;
      this.type = type;
      this.sizeComparedToEarth = sizeComparedToEarth;
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

   public Long getAgeInBillions() {
      return ageInBillions;
   }

   public void setAgeInBillions(Long ageInBillions) {
      this.ageInBillions = ageInBillions;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public Long getSizeComparedToEarth() {
      return sizeComparedToEarth;
   }

   public void setSizeComparedToEarth(Long sizeComparedToEarth) {
      this.sizeComparedToEarth = sizeComparedToEarth;
   }

   public Timestamp getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
      this.createdAt = createdAt;
   }

   public List<Planet> getPlanetList() {
      return planetList;
   }

   public void setPlanetList(List<Planet> planetList) {
      this.planetList = planetList;
   }

   public Astronomer getAstronomer() {
      return astronomer;
   }

   public void setAstronomer(Astronomer astronomer) {
      this.astronomer = astronomer;
   }

//   @Override
//   public String toString() {
//      return "SolarSystem{" +
//              "id=" + id +
//              ", name='" + name + '\'' +
//              ", ageInBillions=" + ageInBillions +
//              ", type='" + type + '\'' +
//              ", sizeComparedToEarth=" + sizeComparedToEarth +
//              ", createdAt=" + createdAt +
//              ", planetList=" + planetList +
//              '}';
//   }

   @Override
   public String toString() {
      return "SolarSystem{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", ageInBillions=" + ageInBillions +
              ", type='" + type + '\'' +
              ", sizeComparedToEarth=" + sizeComparedToEarth +
              ", createdAt=" + createdAt +
              ", astronomer=" + this.astronomer +
              '}';
   }
}
