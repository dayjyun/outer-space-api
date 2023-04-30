package kbarrios.dev.outerspace.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name="planets")
public class Planet {
   @Column
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   @NotNull(message = "Planet needs a name")
   private String name;

   @Column
   private Long distanceFromSun;

   @Column
   private Long lengthOfYear;

   @Column
   private Long sizeComparedToEarth;

   @Column
   private boolean habitable;

   @Column
   @CreationTimestamp
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH-mm-ss")
   private Timestamp createdAt;

   // Many Planets belong to one Solar System
   @ManyToOne
   @JoinColumn(name = "solary_system_id", referencedColumnName = "id")
   @JsonIgnore
   private SolarSystem solarSystem;

   // Many Planets belong to one Astronomer
   @ManyToOne
   @JoinColumn(name = "astronomer_id")
   @JsonIgnore
   private Astronomer astronomer;

   public Planet() {}

   public Planet(Long id, String name, Long distanceFromSun, Long lengthOfYear, Long sizeComparedToEarth, boolean habitable,
                 SolarSystem solarSystem) {
      this.id = id;
      this.name = name;
      this.distanceFromSun = distanceFromSun;
      this.lengthOfYear = lengthOfYear;
      this.sizeComparedToEarth = sizeComparedToEarth;
      this.habitable = habitable;
      this.solarSystem = solarSystem;
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

   public Long getDistanceFromSun() {
      return distanceFromSun;
   }

   public void setDistanceFromSun(Long distanceFromSun) {
      this.distanceFromSun = distanceFromSun;
   }

   public Long getLengthOfYear() {
      return lengthOfYear;
   }

   public void setLengthOfYear(Long lengthOfYear) {
      this.lengthOfYear = lengthOfYear;
   }

   public Long getSizeComparedToEarth() {
      return sizeComparedToEarth;
   }

   public void setSizeComparedToEarth(Long sizeComparedToEarth) {
      this.sizeComparedToEarth = sizeComparedToEarth;
   }

   public boolean isHabitable() {
      return habitable;
   }

   public void setHabitable(boolean habitable) {
      this.habitable = habitable;
   }

   public SolarSystem getSolarSystem() {
      return solarSystem;
   }

   public void setSolarSystem(SolarSystem solarSystem) {
      this.solarSystem = solarSystem;
   }

   public Timestamp getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
      this.createdAt = createdAt;
   }

   public Astronomer getAstronomer() {
      return astronomer;
   }

   public void setAstronomer(Astronomer astronomer) {
      this.astronomer = astronomer;
   }

   @Override
   public String toString() {
      return "Planet{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", distanceFromSun=" + distanceFromSun +
              ", lengthOfYear=" + lengthOfYear +
              ", sizeComparedToEarth=" + sizeComparedToEarth +
              ", habitable=" + habitable +
              ", createdAt=" + createdAt +
              ", solar_systemId=" + solarSystem +
              '}';
   }
}
