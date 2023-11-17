package org.example;
import java.util.*;

public class Box<F extends Fruit>{

    private List<F> list = new ArrayList<>();


    public List<F> getList() {
        return list;
    }
    public Box(F obj) {
        list.add(obj);
    }

    void add(F obj) {
        list.add(obj);
    }

    void moveTo(Box<? super F> box) {
        if (box != this) {
            for (F obj : list) {
                box.add(obj);
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
class LemonBox extends Box<Fruit> {
    public LemonBox(Fruit obj) {
        super(obj);
    }

    @Override
    void add(Fruit obj) {
        super.add(obj);
    }
    @Override
    void moveTo(Box<? super Fruit> box) {
        if (box != this) {
            for (Fruit obj : getList()) {
                box.add(obj);
            }
            getList().clear();
        }
    }
}