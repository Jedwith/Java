package org.example;
import java.util.*;

public class Box<F  extends Fruit>{

    private List<F> list = new ArrayList<>();


    public List<F> getList() {
        return list;
    }

    void add(AvoidFruit<F>... fruits) {
        for (AvoidFruit<F> fruit : fruits) {
            list.add((F) fruit);
        }
    }

    void moveTo(Box<? extends AvoidFruit<F>> box) {
        if (box != this) {
            for (F fruit : list) {
                box.add((AvoidFruit) fruit);
            }
            list.clear();
        }
    }

    float getWeight() {
        float weight = 0;
        if (list.isEmpty()) {
            return 0;
        }
        for (F l : list) {
            weight += l.getWeight();
        }
        return weight;
    }

    boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    void printBox() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста!!!");
            return;
        }
        for (F l : list) {
            System.out.println(l);
        }
    }
}
