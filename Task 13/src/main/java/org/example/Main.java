package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FavoritesService service = context.getBean("favoritesService", FavoritesService.class);
        service.addToFavorties("Купи песика","4x4");
        service.addToFavorties("Частушки");
    }
}