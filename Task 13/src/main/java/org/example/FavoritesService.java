package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class FavoritesService {
    @Autowired
    SongService songService;
    @Autowired
    Playlist playlist;
    @Autowired
    Request request;
    @Autowired
    MileService mileService;
    ArrayList<Song> favorites = new ArrayList<>();

    //    public FavoritesService(SongService songService, Playlist playlist, Request request) {
//        this.songService = songService;
//        this.playlist = playlist;
//        this.request = request;
//    }
    public int getTimeFavorites() {
        int totalTime = 0;
        for (Song song : favorites) {
            totalTime += song.getTime();
        }
        return totalTime;
    }

    public void printTimeFavorites() {
        int totalTime = getTimeFavorites();
        int hours = totalTime / 60;
        int minutes = totalTime % 60;
        System.out.println("Общая продолжительность треков в избранном " + hours + " часов " + minutes + " минут");
    }

    public boolean addFavor() {
        if (!request.songList.isEmpty()) {
            for (Song song : request.songList) {
                if (!favorites.contains(song)) {
                    String songDateAdded = "2023-08-21";
                    song.setDateAdded(songDateAdded);
                    favorites.add(song);
                    System.out.println("Песня '" + song.getName() + "' добавлена в избранное " + songDateAdded);
                }
            }
            return true;
        } else {
            System.out.println("В избранном нет песен");
            return false;
        }
    }

    public void addToFavorties(String... names) {
        boolean addedAtLeastOne = false;
        for (String name : names) {
            if (request.add(name)) {
                if (addFavor()) {
                    addedAtLeastOne = true;
                }
            }
        }
        if (addedAtLeastOne){
            printFavorites();
            mileService.sendEmail(favorites);
        }
        else{
            System.out.println("Песня не найдена");
        }
    }
    public Song getLastAddedSong() {
        if (!favorites.isEmpty()) {
            return favorites.get(favorites.size() - 1);
        } else {
            return null; // Возвращаем null, если избранные песни пусты
        }
    }



    public void printFavorites() {
        int totalSongs = 0;
        System.out.println("Избранные песни:");
        for (Song song : favorites) {
            System.out.println(song.printInfo());
            totalSongs++;
        }
        System.out.println("Итоговое количество песен: " + totalSongs);
        printTimeFavorites();
    }
//    public void printFavorites(){
//        System.out.println("Избранные песни:");
//        if (favorites.isEmpty()){
//            System.out.println("Список избранного пуст:");
//        }
//        else {
//            for (Song s : favorites){
//                System.out.println(s.printInfo());
//            }
//        }
//    }

    public void removeFromFavorites(String songName) {
        boolean found = false;
        Song songToRemove = null;
        for (Song song : favorites) {
            if (song.getName().equalsIgnoreCase(songName)) {
                found = true;
                songToRemove = song;
                break;
            }
        }
        if (found) {
            favorites.remove(songToRemove);
            System.out.println("Песня '" + songName + "' удалена из избранного.");
        } else {
            System.out.println("Песня с названием '" + songName + "' не найдена в избранном.");
        }
        printFavorites();
    }


    public void addToPlaylist(String name) {
        if (request.add(name)) {
            playlist.add();
        }
    }
}







//    public void addToPlaylist(String songName) {
//        Song song = request.songService.findByName(songName);
//        if (song != null) {
//            playlist.add(song);
//            System.out.println("Песня '" + song.getName() + "' добавлена в плейлист.");
//        } else {
//            System.out.println("Песня с названием '" + songName + "' не найдена.");
//        }
//    }
//}
