package org.example.animals;

public class Frog extends Amphibians {
    private String uniqueness;

    public static int count;
    public Frog(String name, int age, int maxRunDistance, int maxSwimDistance, String uniqueness){
        super(name, age, maxRunDistance, maxSwimDistance, uniqueness );
        count++;
    }
}
