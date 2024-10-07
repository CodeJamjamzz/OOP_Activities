
import java.util.Comparator;
import java.util.Objects;

public class Animal implements Comparable<Animal>{
    public String name;
    public int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    // public boolean equals(Object object){
    //     if(object instanceof String){
    //         // return Objects.equals(object, name);
    //         return object.equals(name);
    //     }

    //     return false;
    // }

    // public boolean equals(Object object){
    //     if(this.age == ((Animal)object).age && getClass() == object.getClass()){
    //         return true;
    //     }

    //     return super.equals(object);
    // }

    public boolean equals(Object object){
        if(object instanceof String){
            if(object.equals(name)){
                return true;
            }

            return false;
        }

        if(object instanceof Integer){
            if(age == (int) object){
                return true;
            }

            return false;
        }

        if(object instanceof Animal){
            if(Objects.equals(name, ((Animal)object).name)){
                return true;
            }

            return false;
        }

        return false;
    }

    public int compareTo(Animal b){
        return this.name.compareTo(b.name);
    }

    public static class Dog extends Animal{
        public Dog(String name, int age){
            super(name,age);
        }
    }
    
    public static class Cat extends Animal{
        public Cat(String name, int age){
            super(name,age);
        }
    }
}

class AnimalSorter implements Comparator<Animal>{
    // public int compare(Animal a, Animal b ){
    //     if(Integer.compare(a.age, b.age) == 0){
    //         return a.name.compareTo(b.name);
    //     }

    //     if(a.age == b.age){
    //         return 0;
    //     } else if (a.age < b.age){
    //         return -1;
    //     }

    //     return 1;
    // }

    public int compare(Animal a, Animal b){
        if(a.compareTo(b) == 0){
            if(a.age == b.age){
                return 0;
            } else if (a.age < b.age){
                return -1;
            }
    
            return 1;
        }

        return a.compareTo(b);
    }
}

