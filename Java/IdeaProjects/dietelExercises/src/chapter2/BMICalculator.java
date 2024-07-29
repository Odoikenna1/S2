package chapter2;

import java.util.ArrayList;
import java.util.Arrays;

public class BMICalculator {
    BMITable[] status = BMITable.values();
    private ArrayList<UserData> localStorage;

    public String getValues(){
        return Arrays.toString(status);
    }

    public String getResult(int weightInKilograms, int heightInMeters){
        int value = calculateBMI(weightInKilograms, heightInMeters);
        return findStatus(value);
    }

    private static String findStatus(int value) {
        for(BMITable values : BMITable.values()){
            for(int count : values.getBodyWeightPounds()){
                if(value == count){
                    return values.name();
                }
            }
        }
        return "Status Unknown";
    }

    public int calculateBMI(int weightInKilograms, int heightInMeters){
        return weightInKilograms / heightInMeters * heightInMeters;
    }
}
