package org.example.animals;

public class Newt extends Amphibians{
    public static int count;
    public Newt(String name, int age, int maxRunDistance, int maxSwimDistance, String uniqueness){
        super(name, age, maxRunDistance, maxSwimDistance, uniqueness);
        count++;
    }
}
