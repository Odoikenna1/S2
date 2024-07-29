package chapter2;

public class User {

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void calculateBMI(){
        int weight = getWeight();
        int height = getHeight();
        BMICalculator calculator = new BMICalculator();
        calculator.getStatus(weight, weight);
    }
    User(int weight, int height){
        this.weight = weight;
        this.height = height;
    }
    private String name;
    private int age;
    private int weight;
    private int height;
    private String status;

}
