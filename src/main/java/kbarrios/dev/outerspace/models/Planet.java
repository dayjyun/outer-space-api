package kbarrios.dev.outerspace.models;

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

}
