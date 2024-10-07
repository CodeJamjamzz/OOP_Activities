public abstract class Animal implements Comparable<Animal>{
    public String name;
    int age;

    public Animal(String name, int age){this.name = name; this.age = age;}

    public int compareTo(Animal a){
        if(this.name.compareTo(a.name) == 0){
            return this.age - a.age;
        }

        return this.name.compareTo(a.name);
    }

    public String ToString(){
        return "Animal: ";
    }
}


