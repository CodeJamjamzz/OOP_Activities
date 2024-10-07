public class Dog extends Animal {
    public String breed;

    Dog(String name, int age, String breed){super(name,age); this.breed = breed;}

    @Override
    public String ToString(){
        return super.ToString() + "Dog";
    }
}
