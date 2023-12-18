package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class SongService {
    private ArrayList<Song> songs = new ArrayList<>();
    @PostConstruct
    public void insert(){
        songs.add(new Song(1, "Купи песика", "Милана Хаметова", 3));
        songs.add(new Song(2, "Частушка", "KarnaVal", 2));
        songs.add(new Song(3, "4x4", "Big Baby Tape", 4));
        songs.add(new Song(4, "Лидер", "Kizaru", 3));
        songs.add(new Song(5, "LegitCheck", "FRIENDLY THUG 52 NGG", 4));
        songs.add(new Song(6, "Частушки", "Сектор Газа", 5));
        songs.add(new Song(7, "Малиновая Лада", "GAYAZOV$ BROTHER$", 2));
        songs.add(new Song(8, "В шумном балагане", "Вилли Токарев", 5));
        songs.add(new Song(9, "Я РУССКИЙ", "SHAMAN", 2));
        songs.add(new Song(10, "BabyMama", "Скриптонит", 3));

    }
    public void printAll(){
        System.out.println("Список песен");
        for (Song s : songs){
            System.out.println(s.printInfo());
        }
    }
    public Song findByName(String name){
        for(Song s : songs){
            if (s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
    public Song findBySinger(String name, String singer){
        for(Song s : songs){
            if (s.getName().equals(name) && s.getSinger().equals(singer)){
                return s;
            }
        }
        return null;
    }
}
