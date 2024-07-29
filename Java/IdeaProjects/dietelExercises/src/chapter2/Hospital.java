package chapter2;

public class Hospital{
    public static void main(String [] args){

        User Bob = new User(64, 24);
        BMICalculator calc = new BMICalculator();
        int height = Bob.getHeight();
        int weight = Bob.getWeight();
        System.out.println(calc.getStatus(height, weight));
    }
}
