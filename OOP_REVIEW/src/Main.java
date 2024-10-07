import java.io.IOError;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Plants> plants = new ArrayList<>();
        String op;

        do { 
            
            System.out.print("Enter option: ");
            op = scan.next();

            switch(op){
                case "Sunflower":
                    plants.add(new Plants.Sunflower());
                    break;
                case "Peashooter":
                    plants.add(new Plants.Peashooter());
                    break;
            }
        } while (op != "Done");
    }
}
