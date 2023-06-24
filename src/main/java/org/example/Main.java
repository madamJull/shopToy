package org.example;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        ToyMachine machine = new ToyMachine();
        fillRandom(machine);
        machine.printToys();
        runQuiz(machine);
    }
    private static void runQuiz(ToyMachine machine) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("toy.txt", false);
            fileWriter.write(machine.getToysList());
            int i = 0;
            while (machine.getToysCount() > 0) {
                i++;
                Toy nextToy = machine.getNext();
                String str = "" + i + ": " + nextToy.toString() + "\n";
                fileWriter.write(str);
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void fillRandom(ToyMachine machine) {
        int toysTypeCount = 1;
        int toysMaxCount = 50;
        int rate = 0;
        int count = 0;
        Random rnd = new Random();
        for (int i = 1; i <= toysTypeCount; i++) {
            rate = rnd.nextInt(101);
            Toy toy = new Toy(i, "Toy" + i, rate);
            count = 1 + rnd.nextInt(toysMaxCount);
            for (int c = 1; c <= count; c++) {
                machine.add(toy);
            }
        }
    }
}