package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        Chameleon chameleon = new Chameleon("Benjamin", 2, 59, Chameleon.Color.GREEN);
        Chameleon chameleon2 = new Chameleon("Dmitriy", 6, 78,Chameleon.Color.RED);
        Chameleon chameleon3 = new Chameleon("Hector", 5, 321,Chameleon.Color.BLUE);
        Annotation.createTable(chameleon);
        Annotation.insertIntoTable(chameleon);
        Annotation.insertIntoTable(chameleon2);
        Annotation.insertIntoTable(chameleon3);
    }
}