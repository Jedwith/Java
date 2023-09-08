package org.example.animals;

public abstract class Animal {
    private String name;
    private int age;
    private int maxRunDistance;
    private int maxSwimDistance;
    private static int count;
    public static int getCount() {
        return count;
    }

    public Animal(String name, int age, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        count++;
    }

    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(this.name + " пробежал " + dist);
        }
        else
        {
            System.out.println(this.name + " не смог пробежать " + dist);
        }
    }
    public void swim(int swimDist) {
        if (maxSwimDistance == 0) {
            System.out.println(this.name + " не умеет плавать");
        }
        else if (maxSwimDistance <= swimDist) {
            System.out.println(this.name + " проплыл " + swimDist);
        }
        else
        {
            System.out.println(this.name + " не смог проплыть " + swimDist);
        }
    }
}
