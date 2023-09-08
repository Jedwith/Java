package org.example.animals;

public class Amphibians extends Animal{
    private static int Amphibiancount;
    private String uniqueness;

    public Amphibians(String name, int age, int maxRunDistance, int maxSwimDistance, String uniqueness){
        super(name, age, maxRunDistance, maxSwimDistance);
        this.uniqueness = uniqueness;
        Amphibiancount++;
    }
    public static int getAmphibiancount(){
        return Amphibiancount;
    }
    public String getUniqueness(){
        return uniqueness;
    }
}
