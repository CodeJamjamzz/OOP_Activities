import java.util.Comparator;

public class Animal {
    public String name;
    public int age;

    public Animal(String name, int age){
        this.age = age;
        this.name = name;
    }

    // @Override
    // public boolean equals(Object object){
    //     if(object instanceof String){
    //         return Objects.equals(name, object);
    //     }

    //     return false;
    // }

    @Override
    public boolean equals(Object object){
        if(object instanceof Integer){
            return this.age == (int)object;
        }

        return false;
    }

}

class AnimalAgeSorter implements Comparator<Animal>{
    public int age;

    public AnimalAgeSorter(int age){
        this.age = age;
    }

    public int compare(Animal a, Animal b){

        if (a instanceof Dog && !(b instanceof Dog)) {
            return -1; // 'a' comes before 'b'
        }
        // Check if 'b' is a Dog and 'a' is not
        else if (b instanceof Dog && !(a instanceof Dog)) {
            return 1; // 'b' comes before 'a'
        }

        if(a instanceof Dog && b instanceof Dog){
            int diff1 = Math.abs(age - a.age);
            int diff2 = Math.abs(age - b.age);

            if(diff1 == diff2){
                return Integer.compare(a.age, b.age);
            } 

            if(diff1 > diff2){
                return 1;
            }

            return -1; 
        } 
        return 0;
    }

    // public int compare(Animal a, Animal b){
    //     if(!(a instanceof Dog) && b instanceof Dog){
    //         return 1;
    //     } else if (a instanceof Dog && !(b instanceof Dog)){
    //         return -1;
    //     }

    //     return 0;
    // }
} 

class Dog extends Animal{
    
    public Dog(String name, int age){
        super(name, age);
    }

    public Dog(){
        super("Unknown", 0);
    }

    // @Override
    // public boolean equals(Object object){
    //     if(object instanceof Dog){
    //         return true;
    //     }

    //     return false;
    // }
}

class Cat extends Animal{
    public Cat(String name, int age){
        super(name,age);
    }
}


