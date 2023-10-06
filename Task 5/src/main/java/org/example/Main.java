package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1");
        String[] words = {"Собака", "Кот", "Дельфин", "Кот", "Медведь", "Зебра", "Собака", "Тигр", "Лев", "Кот"};
        LinkedHashMap<String, Integer> wordList = new LinkedHashMap<>();
        for (String i : words) {
            wordList.put(i, wordList.getOrDefault(i, 0) + 1);
        }
        System.out.println((wordList.entrySet()));

        System.out.println();

        System.out.println("Задание №2");
        Synonyms synonyms = new Synonyms();
        synonyms.add("Красивый", "Замечательный");
        synonyms.add("Красивый", "Замечательный");
        synonyms.add("Красивый", "Прекрасный");
        synonyms.add("Умный", "Сообразительный");
        synonyms.add("Грустный", "Печальный");
        synonyms.add("Крутой", "Прекрасный");



        synonyms.printAll();

    }

}