package org.example;

import org.example.animals.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Murzik", 8, 200, 0),
                new Dog("Muhtar", 5, 10),
                new Dog("Rex", 5, 10),
                new Tiger("Zuba", 8, 150, 50),
                new Frog("Ben", 3, 0, 75, "Когда лягушки спят они не закрывают глаза"),
                new Newt("Felix", 2, 100, 150, "Гребенчатый тритон может свистеть, скрипеть и пищать"),
                new Chameleon("Benjamin", 1, 50, 85, "Лапки хамелеона работают как щипцы для салата")
        };
        for (Animal a : animals) {
            a.run(100);
            a.swim(200);
        }

        System.out.println("Количество котов " + Cat.count);
        System.out.println("Количество собак " + Dog.count);
        System.out.println("Количество тигров " + Tiger.count);
        System.out.println("Количество лягушек " + Frog.count);
        System.out.println("Количество тритонов " + Newt.count);
        System.out.println("Количество хамелеонов " + Chameleon.count);
        System.out.println(((Amphibians) animals[4]).getUniqueness());
        System.out.println(((Amphibians) animals[5]) .getUniqueness());
        System.out.println(((Amphibians) animals[6]) .getUniqueness());
        System.out.println("Общее количество животных " + Animal.getCount());
        System.out.println("Количество амфибий " + Amphibians.getAmphibiancount());
    }
}