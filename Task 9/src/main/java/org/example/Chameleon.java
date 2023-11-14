package org.example;

@Table(title = "CHAMELEON1")
public class Chameleon {

    public enum Color {
        GREEN, RED, BLUE
    }

    public Chameleon(String name, int age, int runDistance, Color color) {
        this.name = name;
        this.age = age;
        this.runDistance = runDistance;
        this.color = color;
    }
    @Column
    private String name;

    @Column
    private int age;
   @Column
    private int runDistance;

    @Column
    private Color color;

}
