package org.example;
import java.util.*;
public class ToyMachine {
    private HashMap<Toy, Integer> toys;

    public ToyMachine() {
        this.toys = new HashMap<>();
    }

    public void add(Toy toy) {
        Integer count = 0;
        if (toys.keySet().contains(toy)) {
            count = toys.get(toy);
        }
        toys.put(toy, ++count);

    }

    public void printToys(){
        for (Toy toy : toys.keySet()) {
            System.out.println("in machine: " + toy + ": " + toys.get(toy));
        }
    }
    public String getToysList(){
        String result = "";
        for (Toy toy : toys.keySet()) {
            result = result + "in machine: " + toy + ": " + toys.get(toy) + "\n";
        }
        return result + "\n";
    }

    private void remove(Toy toy) {
        Integer count = toys.get(toy);
        if (count == 1) {
            toys.remove(toy);
        } else {
            toys.put(toy, --count);
        }

    }

    public int getToysCount() {
        int count = 0;
        for (Toy toy : toys.keySet()) {
            count += toys.get(toy);
        }
        return count;
    }
    public Toy getNext() {
        HashMap<Toy, Integer> rates = new HashMap<>();
        int fullRate = 0;
        for (Toy toy : toys.keySet()) {
            int toyRate = toy.getRate();
            int toyCount = toys.get(toy);
            int rate = toyRate * toyCount;
            rates.put(toy, fullRate + rate);
            fullRate += rate;
        }
        int test = 0;
        if (fullRate > 0 ){
            test = 1 + new Random().nextInt(fullRate);
        }

        for (Toy toy : rates.keySet()) {
            int rate = rates.get(toy);
            if (test <= rate) {
                remove(toy);
                return toy;
            }
        }

        return null;

    }

}
