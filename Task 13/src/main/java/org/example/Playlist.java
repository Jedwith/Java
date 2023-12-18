package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Playlist {
    public ArrayList<Song> playlist = new ArrayList<>();
    @Autowired
    Request request;
//        public boolean add(Song song) {
//        if (request.songList.contains(song)) {
//            playlist.add(song);
//            System.out.println("Песня " + song.getName() + " добавлена в плейлист");
//            System.out.println("Общее количество песен: " + playlist.size());
//            return true;
//        } else {
//            System.out.println("Композиция не найдена в заявке");
//            return false;
//        }
//    }

    public boolean add() {
        if (!request.songList.isEmpty()) {
            for (Song song : request.songList) {
                if (!playlist.contains(song)) {
                    playlist.add(song);
                    System.out.println("Песня '" + song.getName() + "' добавлена в избранное ");
                }
            }
            return true;
        } else {
            System.out.println("В плейлисте нет песен");
            return false;
        }
    }





//    public void add(Song song) {
//        if (song != null && !playlist.contains(song)) {
//            playlist.add(song);
//            System.out.println("Песня " + song.getName() + " добавлена в плейлист.");
//        } else {
//            System.out.println("Песня уже есть в плейлисте или передан некорректный объект песни.");
//        }
//    }
}

