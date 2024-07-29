package chapter2;

public enum BMITable {
    UNDER_WEIGHT(18),
    OPTIMUM_WEIGHT(19,20,21,22,23,24),
    OVERWEIGHT(25,26,27,28,29),
    CLASS1_OBESITY(30,31,32,33,34),
    CLASS2_OBESITY(35,36,37,38,39),
    CLASS3_OBESITY(40,41,42,43,44,45,46,47,48,49,50,51,52,53,54);

    private final int[] bodyWeightPounds;
    BMITable(int... weightInPounds){
        this.bodyWeightPounds = weightInPounds;
    }
    public int[] getBodyWeightPounds(){
        return bodyWeightPounds;
    }

}
