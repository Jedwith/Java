package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        String[][] array = {
                {"1", "2","4","1"},
                {"5", "0", "3", "9"},
                {"0", "8", "5", "1"},
                {"9", "4", "8", "1"},
        };
        char myChar = 'е'; // Здесь вы можете заменить символ на любой другой символ, который вас интересует
        //1072-а
        //1073-б
        //1074-в
        //1075-г
        //1076-д
        //1077-е
        //1078-ё
        //1079-ж
        //1080-з




        //1091-у
        //1086-о
        //1099-ы
        //1080-и
        //1101-э
        //1103-я
        //1102-ю
        //1077-е
        // int charCode = (int) ; // Преобразуем символ в его код

       // System.out.println("Символ: " + myChar);
        //System.out.println("Код символа: " + charCode);
        try {
            check(array);
        }
        catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
    }
    public static void check(String[][] array) throws MyArraySizeException, MyArrayDataException, MyVowelsException{
        if (array.length != 4)
            throw new MyArraySizeException();
        for (int i = 0; i < array.length; i++){
            if (array[i].length != 4)
                throw new MyArraySizeException();
        }
       // String vowels = "аиеёоуыэюя";
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try{
                    if (!az(array[i][j])){
                        sum += Integer.valueOf(array[i][j]);
                    }
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j,array[i][j]);
                }
            }
        }
        boolean check = true;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try{
                    if (az(array[i][j])){
                        throw new MyVowelsException(i,j,array[i][j]);
                    }
                } catch (MyVowelsException e){
                    check = false;
                    e.printStackTrace();
                }
            }
        }
        if(check){
            System.out.println("Сумма " + sum);

        }
    }

    public static boolean az(String c){
        int x = (int)c.charAt(0);
        for (int i = 1072; i <= 1080; i++) {
            if(x==i){
                return true;
            }
        }
        return false;
    }
}