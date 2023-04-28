package kbarrios.dev.outerspace.models;

import javax.persistence.*;

@Entity
@Table(name="solary_systems")
public class SolarSystem {
   @Column
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column
   private String name;

   @Column
   private Long ageInBillions;

   @Column
   private String type;

   @Column
   private Long sizeComparedToEarth;

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
