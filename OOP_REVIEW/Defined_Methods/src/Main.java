import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Dog("John", 18));
        animals.add(new Dog("John", 18));
        animals.add(new Cat("Jan", 14));
        animals.add(new Dog("Jam", 12));
        animals.add(new Cat("Jems", 15));
        
        // Dog dog = new Dog();
        // for(Animal i: animals){
        //     if(dog.equals(i)){
        //         System.out.println(i.name + " is a Dog");
        //     }
        // }

        // for(Animal a: animals){
        //     if(a.equals("Jan")){
        //         System.out.println(a.name + " has a similar name");
        //     }
        // }

        // for(Animal a: animals){
        //     if(((Animal)a).equals(18)){
        //         System.out.println(a.name + " has a similar age");
        //     }
        // }
        
        AnimalAgeSorter sort = new AnimalAgeSorter(13);
        Collections.sort(animals, sort);
        for(Animal a: animals){
            if(a instanceof Cat){
               System.out.println("CAT: " + a.name + " " + a.age); 
            } else if (a instanceof Dog){
                System.out.println("DOG: " + a.name + " " + a.age); 
            }
        }

    }
}
