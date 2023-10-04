package org.example;
//В ячейке массива лежит что-то не то
public class MyArrayDataException extends RuntimeException{
    private int i;
    private int j;
    private String message;
    public MyArrayDataException(int i, int j, String message) {
        super("В массиве под индексами [" + (i + 1) + "]"+"["+ (j + 1) + "] находится не целое число" + "\"" + message + "\"");
        this.i = i;
        this.j = j;
        this.message = message;
    }
}
