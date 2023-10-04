package org.example;
//В ячейке массива гласная буква
public class MyVowelsException extends RuntimeException{
    private int i;
    private int j;
    private String message;
    public MyVowelsException(int i, int j, String message) {
        super("В массиве под индексами [" + (i + 1) + "]"+"["+ (j + 1) + "] находится буква от 'а-з': " + "\"" + message + "\"");
        this.i = i;
        this.j = j;
        this.message = message;
    }

}
