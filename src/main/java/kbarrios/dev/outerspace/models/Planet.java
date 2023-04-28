package kbarrios.dev.outerspace.models;

import javax.persistence.*;

@Entity
@Table(name="planets")
public class Planet {
   @Column
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;

   @Column
   private Long distanceFromSun;

   @Column
   private Long lengthOfYear;

   @Column
   private Long sizeComparedToEarth;

   @Column
   private boolean habitable;

   public Planet() {}

   public Planet(Long id, String name, Long distanceFromSun, Long lengthOfYear, Long sizeComparedToEarth, boolean habitable) {
      this.id = id;
      this.name = name;
      this.distanceFromSun = distanceFromSun;
      this.lengthOfYear = lengthOfYear;
      this.sizeComparedToEarth = sizeComparedToEarth;
      this.habitable = habitable;
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
}
