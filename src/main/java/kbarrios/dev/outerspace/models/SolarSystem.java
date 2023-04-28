package kbarrios.dev.outerspace.models;

public class SolarSystem {
   private Long id;
   private String name;
   private Long ageInBillions;
   private String type;
   private Long sizeComparedToEarth;

   public SolarSystem() {}

   public SolarSystem(Long id, String name, Long ageInBillions, String type, Long sizeComparedToEarth) {
      this.id = id;
      this.name = name;
      this.ageInBillions = ageInBillions;
      this.type = type;
      this.sizeComparedToEarth = sizeComparedToEarth;
   }
}
