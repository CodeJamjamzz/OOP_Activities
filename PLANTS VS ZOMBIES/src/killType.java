public enum killType {
    IN(1), CC(2);

    private final int value;
    
    killType(int value){
        this.value = value;
    }

    public int get_value(){
        return value;
    }
}
