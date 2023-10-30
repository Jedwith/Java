package org.example;

public class Employee {
    private String name;
    private int age;
    private String post;
    private double salary;
    private boolean isMale;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getPost() {
        return post;
    }

    public boolean isMale() {
        return isMale;
    }

    public Employee(String name, int age, String post, double salary, boolean isMale) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.isMale = isMale;


    }
}