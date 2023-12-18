package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MileService {
    @Autowired
    FavoritesService favoritesService;
//    public void sendEmail(){
//        String email = "Ega346@gmail.com";
//        if (!favoritesService.favorites.isEmpty()){
//            StringBuilder message = new StringBuilder();
//            for (Song song : favoritesService.favorites){
//                message.append(song.printInfo()).append("\n");
//            }
//            System.out.println("Сообщение: \nСписок ваших песен в избранном: \n" + message + "отправлено на " + email);
//        }
//        else{
//            System.out.println("В вашем избранном нет песен");
//        }
//    }

    public void sendEmail(List<Song> favorites){
        String email = "Ega346@gmail.com";
        Song lastAddedSong = null;
        for (Song song : favorites) {
            lastAddedSong = song; // Последняя песня будет перезаписываться до тех пор, пока цикл не дойдет до конца списка
        }
        if (lastAddedSong != null) {
            StringBuilder message = new StringBuilder();
            message.append(lastAddedSong.printInfo());
            System.out.println("Сообщение: \nПоследняя добавленная песня в избранное: \n" + message + "\nотправлена на " + email);
        } else {
            System.out.println("В вашем избранном нет песен");
        }
    }

}
