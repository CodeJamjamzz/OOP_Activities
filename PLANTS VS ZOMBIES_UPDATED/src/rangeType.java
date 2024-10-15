public enum rangeType {
    SL(1), AOE(2), LR(3),FR(4);
    private final int value;

    rangeType(int value){
        this.value = value;
    }

    int get_value(){
        return value;
    }
}
