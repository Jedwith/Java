package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- 1 задание --");
        List<String> list = new ArrayList<>(Arrays.asList("грейпфрут", "ананас","грейпфрут", "банан","aaaaa","aaaaa", "ананас321", "слива", "апельсин","слива"));

        var stringStream = list.stream()//Поток элементов из листа
                .collect(groupingBy(Function.identity(), counting()))//Группировка и подсчет элемента в каждой группе
                .entrySet().stream()
                //Группировка и сортировка по кол-ву
                .collect(groupingBy(stringLongEntry -> stringLongEntry.getValue(), mapping(Map.Entry::getKey, toCollection(TreeSet::new))))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())//Находится запись с макс кол-вом
                .map(longTreeSetEntry -> longTreeSetEntry.getValue().stream().sorted(Comparator.comparing(String::length)).collect(joining(", ")))//Сортировка по длине и вывод через запятую
                .orElse("");
        System.out.println(stringStream);

        System.out.println("-- 2 задание --");
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Dmitriy", 21, "Web-developer", 75000, true),
                new Employee("Elena", 25, "Manager", 95000, false),
                new Employee("Ivan", 23, "Cleaner", 30000, true),
                new Employee("Boris", 18, "Junior-developer", 50000, true),
                new Employee("Aoris", 18, "Junior-developer", 5000, true)
        ));

        int N = 3; // Количество искомых сотрудников

        System.out.println(employees.stream().filter(e -> e.getSalary() < 100000 && e.isMale())
                .sorted(Comparator.comparing(Employee::getName)) // Сортировка имен в алфавитном порядке
                .limit(N) // Ограничение на количество сотрудников
                .map(Employee::getName) // Извлечение имен сотрудников
                .collect(Collectors.joining(", ", N + "низкооплавчиваемых сотрудников(мужчин): ", ";")));
    }
}