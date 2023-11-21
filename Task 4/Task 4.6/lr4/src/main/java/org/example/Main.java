package org.example;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 задание");
        Integer[] arr1 = {8, 12, 3, 19,50,35};
        String[] arr2 = {"карась", "кот", "еда", "огонь", "алфавит"};
        System.out.println(Arrays.toString(arr1));
        swapElements(arr1, 0,3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        swapElements(arr2, 1,4);
        System.out.println(Arrays.toString(arr2));

        System.out.println("2 задание");
        List<String> list = convertToList(arr2);
        System.out.println(list);

        System.out.println("3 задание");
        Box<Apple> appleBox1 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());
        Box<Apple> appleBox2 = new Box<>(new Apple());

        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        appleBox2.add(new Apple());
        appleBox2.add(new Apple());

        orangeBox.add(new Orange());

        //System.out.println("Сравнение коробки яблок и коробки апельсинов: " + appleBox1.compare(orangeBox));
        //System.out.println("Сравнение сравнение второй коробки яблок и апельсинов: " + appleBox1.compare(appleBox2));

        System.out.println("\n\nПервая коробка с яблоками ");
        appleBox1.printBox();
        appleBox1.getWeight();
        System.out.println("Вторая коробка с яблоками ");
        appleBox2.printBox();
        System.out.println("Коробка с апельсинами ");
        orangeBox.printBox();

        appleBox1.moveTo(appleBox2);

        System.out.println("Первая коробка с яблоками после перемещения:");
        appleBox1.printBox();

        System.out.println("Вторая коробка с яблоками после перемещения:");
        appleBox2.printBox();

        LemonBox lemonBox1 = new LemonBox(new Lemon());
        lemonBox1.add(new Lemon());
        lemonBox1.add(new Apple());
        lemonBox1.add(new Orange());

        System.out.println("Коробка с лимонами");
        lemonBox1.printBox();

        lemonBox1.moveTo(appleBox1);
        appleBox1.moveTo(lemonBox1);
        orangeBox.moveTo(lemonBox1);
        orangeBox.moveTo(orangeBox);
        lemonBox1.moveTo(lemonBox1);



//        bananaBox1.printBox();
//        System.out.println("Содержимое второй коробки с бананами");
//        bananaBox2.printBox();
//        System.out.println("Содержимое первой коробки после пересыпки");
//        bananaBox1.moveTo(bananaBox2);
//        bananaBox1.printBox();
//        System.out.println("Содержимое первой коробки после пересыпки");
//        bananaBox2.printBox();


    }
    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static <V> List<V> convertToList(V[] array){
        return Arrays.asList(array);
    }
}