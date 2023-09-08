package org.example.animals;

public class Chameleon extends Amphibians{
    public static int count;
    public Chameleon(String name, int age, int maxRunDistance, int maxSwimDistance, String uniqueness){
        super(name, age, maxRunDistance, maxSwimDistance, uniqueness);
        count++;
    }
}
