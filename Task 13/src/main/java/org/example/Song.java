package org.example;

public class Song {
    private int id;
    private String name;
    private String singer;
    private int time;
    private String dateAdded;

    public Song(int id, String name, String singer, int time) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.time = time;
        this.dateAdded = dateAdded;
    }
    public String printInfo(){
        return "ID Песни: " + id + ", Название: " + name + ", Исполнитель: " + singer + ", Время проигрывания: " + time;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public int getTime() {
        return time;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
