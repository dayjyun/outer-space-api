package kbarrios.dev.outerspace.models;

import javax.persistence.Entity;

@Entity
public class Planet {
   private Long id;
   private String name;
   private Long distanceFromSun;
   private Long lengthOfYear;
   private Long sizeToEarth;
   private boolean habitable;

   public Planet() {}

   public Planet(Long id, String name, Long distanceFromSun, Long lengthOfYear, boolean habitable) {
      this.id = id;
      this.name = name;
      this.distanceFromSun = distanceFromSun;
      this.lengthOfYear = lengthOfYear;
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

   public boolean isHabitable() {
      return habitable;
   }

   public void setHabitable(boolean habitable) {
      this.habitable = habitable;
   }

   @Override
   public String toString() {
      return "Planet{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", distanceFromSun=" + distanceFromSun +
              ", lengthOfYear=" + lengthOfYear +
              ", habitable=" + habitable +
              '}';
   }
}
