
public class ParkingCharges {

    private static final double PARKING_COST_PER_HOUR = 0.50;
    private static final double PARKING_COST_OF_THREE_HOURS = 2.00;
    private static final double PARKING_COST_OF_TWENTY_FOUR_HOURS = 10.00;

    private static final int PARKING_DURATION_PER_HOUR = 1;
    private static final int PARKING_DURATION_OF_THREE_HOURS = 3;
    private static final int PARKING_DURATION_OF_TWENTY_FOUR_HOURS = 24;
    private double  chargesDue = 0.00;

    public double calculateCharges(int hoursParked) {
        chargesDue = determineHourlyRate(hoursParked);
        chargesDue = determineThreeHoursParkingRate(hoursParked);
        chargesDue = determineTwentyFourHoursParkingRate(hoursParked);
        return chargesDue;
    }
    public double determineHourlyRate(int hoursParked){
        if(hoursParked <= PARKING_DURATION_PER_HOUR){return PARKING_COST_PER_HOUR * hoursParked;}
        return chargesDue;
    }
    public double determineThreeHoursParkingRate(int hoursParked){
        double totalCost = 0;
        double productOfHoursParked = PARKING_COST_OF_THREE_HOURS * hoursParked;
        if(hoursParked > PARKING_DURATION_OF_THREE_HOURS){
            int extraTime = hoursParked - PARKING_DURATION_OF_THREE_HOURS;
            for(int i = 0; i < extraTime; i++){productOfHoursParked += PARKING_COST_PER_HOUR ;}
            return productOfHoursParked;
        }
        else {return PARKING_COST_OF_THREE_HOURS;}
    }
    public double determineTwentyFourHoursParkingRate(int hoursParked){
        if(hoursParked == 24 ){chargesDue = PARKING_COST_OF_TWENTY_FOUR_HOURS * hoursParked;}
        return chargesDue;
    }
}
