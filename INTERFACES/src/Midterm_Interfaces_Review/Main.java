package Midterm_Interfaces_Review;

public class Main {
    public static void main(String[] args) {
        Swimmer swim = new Animal("James", 18);
        swim.swim(); // only does the swim method
        ((Animal)swim).talk(); // needs to typecast to use the methods in animal
        System.out.println(swim.name);
    }
}
