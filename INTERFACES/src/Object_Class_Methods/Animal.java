package Object_Class_Methods;
import java.util.Objects;
import java.util.Comparator;

public class Animal {
    public String name;
    public int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object object){
//        if(getClass() == object.getClass()){
//            return Objects.equals(name, ((Animal)object).name);
//        }

        if(object instanceof Animal){
            if(Objects.equals(age, ((Animal)object).age) && getClass() == object.getClass()){
                return true;
            }
        }

        if(object instanceof String){
            return name.equals(object);
        }

        if(object instanceof Integer){
            if(age == (int) object){
                return true;
            }
        }

        return super.equals(object); // super refers to the object class
    }
}

class Dog extends Animal{
    public Dog(String name, int age){
        super(name,age);
    }
}

class Cat extends Animal{
    public Cat(String name, int age){
        super(name,age);
    }
}

