package org.example;
//Неправильный размер массива
public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Размер массива не 4x4");
    }
}
