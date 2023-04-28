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

}
