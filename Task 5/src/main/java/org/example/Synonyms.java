package org.example;

import java.util.*;

public class Synonyms {
    private Map<String, LinkedHashSet<String>> synonyms = new TreeMap<>();;

    public void add (String term, String synonym){
        LinkedHashSet<String> pars = synonyms.getOrDefault(term, new LinkedHashSet<>());
        for(String key : synonyms.keySet()){
            LinkedHashSet<String> translations = synonyms.get(key);
            if(translations.contains(synonym)){
                System.out.println("Синоним " + synonym + " уже есть у слова " + key);
                return;
            }
        }

        pars.add(synonym);
        synonyms.put(term, pars);
    }
    public void get(String term) {
        System.out.print(term + " синоним: " + synonyms.get(term));
    }

    public void printAll() {
        System.out.println(synonyms.entrySet());
    }
}
