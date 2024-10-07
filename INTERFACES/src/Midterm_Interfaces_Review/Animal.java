package Midterm_Interfaces_Review;

public class Animal implements Swimmer {
    public String name;
    public int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void talk(){
        System.out.println("My name is: " + name);
    }

    @Override
    public void swim(){
        System.out.println("Swimming");
    }
}
