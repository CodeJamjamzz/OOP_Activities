package Object_Class_Methods;
import java.util.Comparator;

class AgeSorter implements Comparator<Animal> {
    public int compare(Animal a, Animal b){
        return Integer.compare(a.age, b.age);
    }
}
