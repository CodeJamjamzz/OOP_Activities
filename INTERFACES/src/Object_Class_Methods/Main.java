package Object_Class_Methods;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog("John", 19));
        animals.add(new Cat("Jan", 13));
        animals.add(new Dog("Jam", 19));
        animals.add(new Cat("James", 15));
        animals.add(new Dog("John", 29));

        Collections.sort(animals, new NearNameSorter("John", 7));
        for(Animal a: animals){
            System.out.println(a.getClass().getSimpleName() + ":  " + a.name + " | " + a.age);
        }

        // Strings
//        for(Animal a: animals){
//            if(a.equals("John")){
//                System.out.println(a.name + " has a similar name");
//            }
//        }

        // AGE
//        for(Animal a: animals){
//            if(a.equals(19)){
//                System.out.println(a.name + " has similar age");
//            }
//        }

        //Objects->names
//        Dog dog = new Dog("John", 12);
//        for(Animal a: animals){
//            if(a.equals(dog)){
//                System.out.println(a.getClass().getSimpleName() + ": " + a.name + " has similar names");
//            }
//        }

        //Objects->age
//        Dog dog = new Dog("John", 19);
//        for(Animal a: animals){
//            if(a.equals(dog)){
//                System.out.println(a.getClass().getSimpleName() + ": " + a.age + " has similar ages");
//            }
//        }


    }
}
