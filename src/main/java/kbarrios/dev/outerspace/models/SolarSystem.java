package kbarrios.dev.outerspace.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="solar_systems")
public class SolarSystem {
   @Column
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String name;

   @Column
   private Long ageInBillions;

   @Column
   private String type;

   @Column
   private Long sizeComparedToEarth;

   @Column
   @Temporal(TemporalType.TIMESTAMP)
   @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
   private LocalDateTime createdAt;

   @OneToMany(mappedBy = "solarSystem", orphanRemoval = true)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Planet> planetList;

   public SolarSystem() {}

   public SolarSystem(Long id, String name, Long ageInBillions, String type, Long sizeComparedToEarth, LocalDateTime createdAt) {
      this.id = id;
      this.name = name;
      this.ageInBillions = ageInBillions;
      this.type = type;
      this.sizeComparedToEarth = sizeComparedToEarth;
      this.createdAt = createdAt;
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

   public List<Planet> getPlanetList() {
      return planetList;
   }

   public void setPlanetList(List<Planet> planetList) {
      this.planetList = planetList;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }

   @Override
   public String toString() {
      return "SolarSystem{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", ageInBillions=" + ageInBillions +
              ", type='" + type + '\'' +
              ", sizeComparedToEarth=" + sizeComparedToEarth +
              '}';
   }
}
