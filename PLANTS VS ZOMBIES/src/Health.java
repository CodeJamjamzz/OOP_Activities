public enum Health {
    DEFAULT(6),
    INFINITE(Integer.MAX_VALUE);

    Health(int value){
        this.value = value;
    }

    private final int value;

    public int get_value(){
        return value;
    }
}
