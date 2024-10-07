interface Attacker{
    int attack();
    int rangeType();
}

interface Sun_Producer{
    int produce_sun();
}

public abstract class Plants {
    public String name;
    public int sun_cost;
    public boolean isNoctural;
    public int hp;

    public Plants(String name, int hp, int sun_cost){
        this.name = name;
        this.sun_cost = sun_cost;
        this.hp = hp;
        isNoctural = false;
    }

    public Plants(String name, int hp, int sun_cost, boolean isNoctural){
        this.name = name;
        this.sun_cost = sun_cost;
        this.hp = hp;
        this.isNoctural = isNoctural;
    }

    @Override
    public String toString(){
        return name + ": ";
    }

    public void die() {
        System.out.print(name + " dies ");
    }

    public static class Sunflower extends Plants implements Sun_Producer{
        public Sunflower(){
            super("Sunflower", 5, 50);
        }

        @Override
        public int produce_sun(){
            System.out.println(name + "produces 25 suns");
            return 25;
        }

    }
    
    public static class Peashooter extends Plants implements Attacker{

        public Peashooter(){
            super("Peashooter", 5, 100);
        }

        @Override
        public int attack(){
            return 1;
        }

        @Override
        public int rangeType(){
            return 1;
        }

    }

}
