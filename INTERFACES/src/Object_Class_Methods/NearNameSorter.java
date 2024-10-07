package Object_Class_Methods;
import java.util.Comparator;

public class NearNameSorter implements Comparator<Animal> {
    public int age;
    public String name;

    public NearNameSorter(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Animal a, Animal b){
        int res1 = name.compareTo(a.name);
        int res2 = name.compareTo(b.name);

        if(res1 == res2){
            NearNumSorter num = new NearNumSorter(5);  //if both are close arrange by age closes to n
            return num.compare(a,b);
//            return 0;                                      method to know which string is closer
        } else if (res1 > res2){
            return 1;
        }

        return -1;
    }
}

class NearNumSorter implements Comparator<Animal>{
    int age;

    public NearNumSorter(int age){
        this.age = age;
    }

    @Override
    public int compare(Animal a, Animal b){
        int diff1 = Math.abs(a.age - this.age);
        int diff2 = Math.abs(b.age - this.age);

        if(diff1 == diff2){
            return 0;
        } else if (diff1 > diff2){
            return 1;
        }
        return -1;
    }
}