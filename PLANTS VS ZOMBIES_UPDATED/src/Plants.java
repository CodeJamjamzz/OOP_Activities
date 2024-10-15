
import java.util.Comparator;

interface SunProducer{
    int produce_sun();
}

interface Attacker{
    int attack();
    int rangeType();
}

interface InstantKiller{
    int killType();
}

interface PlantUpgrade{
    int concurrentSunCost();
}

interface Upgradable{
    PlantUpgrade upgrade();
}

public abstract class Plants implements Comparable<Plants>{
    public String name;
    public int hp;
    public int sun_cost;

    public Plants(int hp, String name, int sun_cost){
        this.hp = hp;
        this.name = name;
        this.sun_cost = sun_cost;
    }

    public Plants(String name, int sun_cost){
        this.hp = Health.DEFAULT.get_value();
        this.name = name;
        this.sun_cost = sun_cost;
    }

    public boolean isAlive(){
        if(hp < 0){
            return false;
        }

        return true;
    }

    public String toString(){
        if(hp > 6){
            return name + "(infinite) " + "- cost: " + sun_cost;
        }

        return name + "(" + hp + ") " + "- cost: " + sun_cost;
    }

    public String die(){
        hp = 0;
        return name + " dies" ;
    }


    public static class Sunflower extends Plants implements SunProducer, Upgradable{
        public Sunflower(){
            super("Sunflower", 50);
        }

        public int produce_sun(){
            return 25;
        }

        public PlantUpgrade upgrade(){
            PlantUpgrade plant = new Plants.TwinSunflower();
            return plant;
        }
    }

    public static class TwinSunflower extends Plants implements SunProducer, PlantUpgrade{
        public static int instances = 0;
        public static int suncost = 250;
        public TwinSunflower(){
            super("TwinSunflower", suncost);
            instances++;
            suncost += concurrentSunCost();
        }

        public int produce_sun(){
            return 50;
        }

        public int concurrentSunCost(){
            return instances * 50;
        }
    }

    public static class Peashooter extends Plants implements Attacker{
        public Peashooter(){
            super("Peashooter", 100);
        }

        public int attack(){
            return 1;
        }

        public int rangeType(){
            return rangeType.SL.get_value();
        }
    }

    public static class WallNut extends Plants{
        public WallNut(){
            super(25, "WallNut", 50);
        }
    }

    public static class Squash extends Plants implements InstantKiller, Attacker{
        public Squash(){
            super(0,"Squash", 50);
        }

        public int attack(){
            System.out.println(die());
            return 3;
        }

        public String die(){
            return name + " dies while squashing zombies";
        }

        public int rangeType(){
            return rangeType.LR.get_value();
        }

        public int killType(){
            return killType.CC.get_value();
        }
    }

    public static class Jalapeno extends Plants implements InstantKiller, Attacker{
        public Jalapeno(){
            super(0,"Jalapeno",125);
        }

        public String die(){
            return name + " dies while exploding";
        }

        public int attack(){
            System.out.println(die());
            return 5;
        }

        public int rangeType(){
            return rangeType.SL.get_value();
        }

        public int killType(){
            return killType.IN.get_value();
        }
    }

    public static class CoffeeBean extends Plants{
        public CoffeeBean() {
            super(Health.INFINITE.get_value(), "CoffeeBean", 75);
        }
    }

    public static class LilyPad extends Plants implements Upgradable{
        public LilyPad(){
            super("LilyPad", 25);
        }

        public PlantUpgrade upgrade(){
            PlantUpgrade plant = new Cattail();
            return plant;
        }
    }

    public static class Cattail extends Plants implements Attacker, PlantUpgrade{
        public static int instances = 0;
        public static int suncost = 250;
        public Cattail(){
            super("Cattail", suncost);
            instances++;
            suncost += concurrentSunCost();
        }

        public int attack(){
            return 1;
        }

        public int rangeType(){
            return rangeType.FR.get_value();
        }

        public int concurrentSunCost(){
            return instances * 25;
        }
    }

    public int compareTo(Plants p){
        return name.compareTo(p.name);
    }
    
}

class HPSorter implements Comparator<Plants>{
    public int compare(Plants a, Plants b){
        if(a.hp == b.hp){
            return a.compareTo(b);
        } else if (a.hp > b.hp){
            return -1;
        }

        return 1;
    }
}

class SunCostSorter implements Comparator<Plants>{
    public int compare(Plants a, Plants b){
        if(a.sun_cost == b.sun_cost){
            return a.compareTo(b);
        } else if (a.sun_cost > b.sun_cost){
            return -1;
        }

        return 1;
    }
}
