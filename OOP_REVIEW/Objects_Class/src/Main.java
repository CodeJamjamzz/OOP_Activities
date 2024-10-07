import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Animal.Dog("John", 12));
        animals.add(new Animal.Dog("John", 10));
        animals.add(new Animal.Dog("John", 2));
        animals.add(new Animal.Cat("Jan", 12));
        animals.add(new Animal.Dog("Japing", 12));
        animals.add(new Animal.Cat("Joz", 12));
        animals.add(new Animal.Cat("Jam", 10));
        
        Animal dog = new Animal.Dog("John", 18);
        for(Animal a: animals){
            if(a.equals(dog)){
                System.out.println(a.name + " " + a.age);
            }
        }

        // AnimalSorter sort = new AnimalSorter();
        // Collections.sort(animals, sort);
        // for(Animal a: animals){
        //     System.out.println(a.name + " " + a.age);
        // }
    }
}
