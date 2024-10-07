import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        int ctr,sunProduced = 0,damageDealt = 0;
        int c = 0;

        List<Plants> plants = new ArrayList<>();
        List<Mushroom> mushrooms = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();
        String input;

        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Wall Nut":
                    plants.add(new Plants.WallNut());
                    break;
                case "Sun-shroom":
                    if(mode.equals("Night") || mode.equals("Fog")){
                        Mushroom sunShroom = new Mushroom.Sunshroom(true);
                        plants.add(sunShroom);
                        mushrooms.add(sunShroom);
                    }else{
                        Mushroom sunShroom = new Mushroom.Sunshroom(false);
                        plants.add(sunShroom);
                        mushrooms.add(sunShroom);
                    }
                    break;
                case "Sunflower":
                    plants.add(new Plants.Sunflower());
                    break;
                case "Peashooter":
                    plants.add(new Plants.Peashooter());
                    break;
                case "Puff-shroom":
                    if(mode.equals("Night") || mode.equals("Fog")){
                        Mushroom puffShroom = new Mushroom.PuffShroom(true);
                        plants.add(puffShroom);
                        mushrooms.add(puffShroom);
                    }else{
                        Mushroom puffShroom = new Mushroom.PuffShroom(false);
                        plants.add(puffShroom);
                        mushrooms.add(puffShroom);
                    }


                    break;
                case "Doom-shroom":
                    if(mode.equals("Night") || mode.equals("Fog")){
                        Mushroom doomShroom = new Mushroom.Doomshroom(true);
                        plants.add(doomShroom);
                        mushrooms.add(doomShroom);
                    }else{
                        Mushroom doomShroom = new Mushroom.Doomshroom(false);
                        plants.add(doomShroom);
                        mushrooms.add(doomShroom);
                    }

                    break;
                case "Twin Sunflower":
                    boolean find = false;
                    c = -1;
                    int i;
                    for(i = 0; i < plants.size(); i++){
                        if(plants.get(i) instanceof Plants.Sunflower){
                            find = true;
                            c = i;
                            break;
                        }
                    }

                    if(c != -1){
//                        plants.set(c, new Plants.TwinSunflower());
                        plants.set(c, (Plants) ((Upgradable)plants.get(c)).upgrade());
                    }

                    break;
                case "Squash":
                    plants.add(new Plants.Squash());
                    break;
                case "Jalapeno":
                    plants.add(new Plants.Jalapeno());
                    break;
                case "Lily Pad":
                    plants.add(new Plants.LilyPad());
                    break;
                case "Cattail":
                    boolean find2 = false;
                    c = 0;
                    for(int i2 = 0; i2 < plants.size(); i2++){
                        if(plants.get(i2) instanceof Plants.LilyPad){
                            find2 = true;
                            c = i2;
                            break;
                        }
                    }

                    if(find2){
//                        plants.set(c, new Plants.Cattail());
                        plants.set(c, (Plants) ((Upgradable)plants.get(c)).upgrade() );
                    }

                    break;
                case "Coffee Bean":
                    Plants coffee = new Plants.CoffeeBean();
                    for(Plants a: plants){
                        if(a instanceof Mushroom && !((Mushroom)a).isAwake()){
                            ((Mushroom)a).awaken((Plants.CoffeeBean) coffee);
                            System.out.println(coffee.die());
                            break;
                        }
                    }

                    plants.add(coffee);
                    break;
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));

        do {
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Produce Sun":
                    // add implementation here
                    // produceSun(plants);
                    ctr = 0;
                    int sum = 0;
                    for(Plants plant: plants){
                        if(plant instanceof SunProducer){
                            ctr++;
                            sunProduced += ((SunProducer)plant).produce_sun();
                        }
                    }
                    System.out.println(ctr + " sun producers gather " + sunProduced + " suns");
                    break;
                case "Attack":
                    // add implementation here
                    ctr = 0;
                    for(Plants plant: plants){
                        if(plant instanceof Attacker && plant.isAlive()){
                            ctr++;
                            damageDealt += ((Attacker)plant).attack();
                        }
                    }

                    if(ctr > 0){
                        System.out.println(ctr + " attackers dealing " + damageDealt + " damage");
                        break;
                    }

                    System.out.println("You have no attackers");
                    break;
                // add more cases here
                case "Instant Kill Status":
                    for(Plants plant: plants){
                        if(plant instanceof InstantKiller && plant.isAlive()){
                            InstantKiller instantKiller = (InstantKiller) plant;
                            instantKiller.killType();
                        }
                    }
                    break;
                case "Attacker Status":
                    for(Plants plant: plants){
                        if(plant instanceof Attacker && plant.isAlive()){
                            Attacker attacker = (Attacker) plant;
                            attacker.rangeType();
                        }
                    }
                    break;
                case "Sort by Name":
                    Collections.sort(plants);
                    for(Plants plant: plants){
                        if(plant.hp == Health.INFINITE.get_value()){
                            System.out.println(plant.name + " (" + "∞" + ") - cost: " + plant.sun_cost);
                        }else{
                            System.out.println(plant.name + " (" + plant.hp + ") - cost: " + plant.sun_cost);
                        }
                    }
                    break;
                case "Sort by HP":
                    plants.sort(new HPSorter());
                    for(Plants plant: plants){
                        if(plant.hp == Health.INFINITE.get_value()){
                            System.out.println(plant.name + " (" + "∞" + ") - cost: " + plant.sun_cost);
                        }else{
                            System.out.println(plant.name + " (" + plant.hp + ") - cost: " + plant.sun_cost);
                        }

                    }
                    break;
                case "Sort by Sun Cost":
                    plants.sort(new SunCostSorter());
                    for(Plants plant: plants){
                        if(plant.hp == Health.INFINITE.get_value()){
                            System.out.println(plant.name + " (" + "∞" + ") - cost: " + plant.sun_cost);
                        }else{
                            System.out.println(plant.name + " (" + plant.hp + ") - cost: " + plant.sun_cost);
                        }

                    }
                    break;
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}