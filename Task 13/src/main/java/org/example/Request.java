package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Request {
    public ArrayList<Song> songList = new ArrayList<>();
    @Autowired
    SongService songService;

    public boolean add(String name){
        Song foundSong = songService.findByName(name);
        if (foundSong != null && foundSong.getName().equals(name)) {
            System.out.println("Заявка на добавление композиции: " + foundSong.getName());
            songList.add(foundSong);
            System.out.println("Композиция " + foundSong.getName() + " успешно добавлена в заявку");
            return true;
        } else {
            System.out.println("Композиция не найдена");
            return false;
        }
    }
}
