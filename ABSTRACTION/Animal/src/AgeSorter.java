import java.util.Comparator;

public class AgeSorter implements Comparator<Animal> {
    public int compare(Animal a, Animal b){
        if(a.age > b.age){
            return -1;
        } else if (a.age == b.age) {
            return 0;
        }

        return 1;

    }
}
