import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<Animal>();
        list.add(new Dog("James", 18, "Husky"));
        list.add(new Dog("Jam", 19, "Husky"));
        list.add(new Cat("John", 14, "Black"));
        list.add(new Dog("Jam", 13, "Husky"));
        list.add(new Dog("Jam", 15, "Husky"));
        list.add(new Cat("Jamersz", 13, "Black"));
        list.add(new Dog("Jamersz", 13, "Husky"));

        Collections.sort(list);
        for(Animal a: list){
            if(a instanceof Dog){
                System.out.println(a.name + " | " + "Age: " + a.age);
            }
        }

        System.out.println("Age Sort: ");
        AgeSorter agesort = new AgeSorter();
        Collections.sort(list, agesort);
        for(Animal a: list){
            if(a instanceof Dog){
                System.out.println(a.ToString() + " | " + "Age: " + a.age);
            }
        }

    }
}
