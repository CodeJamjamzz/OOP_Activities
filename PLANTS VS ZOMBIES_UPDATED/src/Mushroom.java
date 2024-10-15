public abstract class Mushroom extends Plants {
    public boolean state;

    public Mushroom(int hp, String name, int sun_cost, boolean state){
        super(hp,name,sun_cost);
        this.state = state;
    }

    public Mushroom(String name, int sun_cost, boolean state){
        super(name,sun_cost);
        this.state = state;
    }

    public boolean isAwake(){
        if(state){
            return true;
        }

        return false;
    }

    public void awaken(CoffeeBean coffeebean){
        state = true;
        return;
    }

    public static class Sunshroom extends Mushroom implements SunProducer{
        public Sunshroom(boolean state){
            super("Sunshroom", 25, state);
        }

        public int produce_sun(){
            if(isAwake()){
                return 10;
            }
            
            System.out.println(name + " is asleep and cannot produce sun");
            return 0;
        }

    }

    public static class PuffShroom extends Mushroom implements Attacker{
        public PuffShroom(boolean state){
            super("PuffShroom", 0, state);
        }

        public int attack(){
            if(isAwake()){
                return 1;
            }

            System.out.println(name + " is asleep and cannot attack");
            return 0;
        }

        public int rangeType(){
            if(isAwake()){
                    return rangeType.AOE.get_value();  
                }
                return 0;        
            }
        }

    public static class Doomshroom extends Mushroom implements Attacker, InstantKiller{
        public Doomshroom(boolean state){
            super(0,"Doomshroom", 125, state);
        }

        public int attack(){
            if(isAwake()){
                System.out.println(die());
                return 10;
            }

            System.out.println(name + " is asleep and cannot attack");
            return 0;
        }

        public String die(){
            return name + " while exploding and leaves a creater";
        }

        public int rangeType(){
            if(isAwake()){
                return rangeType.AOE.get_value();  
            }
            return 0;        
        }
        
        public int killType(){
            return killType.IN.get_value();
        }
    }

    

}
