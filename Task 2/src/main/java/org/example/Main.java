package org.example;

public class Main {

    public static void main(String[] args) {
       Member[] members = {
               new Human("Dmitriy", 2, 350),
               new Robot("Alex", 7, 900),
               new Cat("Murzik", 4,100),
               new Cat("Kevin", 3, 100),
               new Cat("Felix", 2, 100),
       };
      Challenge[] challenges = {
              new Wall(WallHeight.LOW),
              new Wall(WallHeight.HIGH),
              new RunningRoad(RoadLenght.LOW),
              new Wall(WallHeight.MEDIUM),
              new RunningRoad(RoadLenght.MEDIUM),
             // new Wall(WallHeight.HIGH),
              new RunningRoad(RoadLenght.HIGH),
      };
      for(Member m: members) {
          for (Challenge c: challenges) {
              if (!c.challenge(m)) break;
          }
      }
    }
}