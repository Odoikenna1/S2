package motorBike;
public class MotorBike
{

    private boolean isEngineOn;
    private boolean isClutchEngaged;

    private int gear;
    private int acceleration;


    public boolean checkIfBikeEngineIsOn()
    {
        boolean defaultState = isEngineOn;
        return defaultState;
    }
    public void startEngine()
    {
        isEngineOn = true;
        if (isEngineOn){gear =1;}
    }
    public void stopEngine()
    {
        isEngineOn = false;
    }
    public boolean getStateOfClutch()
    {
        return isClutchEngaged;
    }
    public boolean pullClutchIn(String action)
    {
        if(checkIfBikeEngineIsOn() == true && action.equalsIgnoreCase("pull")) return isClutchEngaged = true;
        else return isClutchEngaged = false;
    }

    public boolean getStateOfTransmission()
    {
        if(checkIfBikeEngineIsOn() == true && isClutchEngaged == true) return true;
        else return false;
    }
    public int getGearPosition()
    {
         return gear;
    }
    public void putGearOn(int gearposition)
    {
        if(getStateOfTransmission() == true) {
            gear = gearposition;
        }
    }
    public int getAcceleration()
    {
        return acceleration;
    }
    public int increaseAcceleration()
    {
        if(checkIfBikeEngineIsOn() == true && getStateOfClutch() == true && getStateOfTransmission() == true && getGearPosition() == 1) {
            acceleration++;
            if (acceleration > 20) {return acceleration = 20;}
        }
        else if(checkIfBikeEngineIsOn() == true && getStateOfClutch() == true && getStateOfTransmission() == true && getGearPosition() == 2) {
            acceleration += 2;
            if (acceleration > 30) return acceleration = 30;
        }
        else if(checkIfBikeEngineIsOn() == true && getStateOfClutch() == true && getStateOfTransmission() == true && getGearPosition() == 3) {
            acceleration += 3;
            if (acceleration > 40) return acceleration = 40;
        }
        else if(checkIfBikeEngineIsOn() == true && getStateOfClutch() == true && getStateOfTransmission() == true && getGearPosition() == 4) {
            acceleration+=4;
        }
        else if (checkIfBikeEngineIsOn() == true && getStateOfClutch() == true && getStateOfTransmission() == true && getGearPosition() > 4) {
            if (acceleration >=21 || acceleration <= 30)
            {
                return acceleration+=4;
            }
        }else if (checkIfBikeEngineIsOn() == true && getStateOfClutch() == true && getStateOfTransmission() == true && getGearPosition() < 1) {
            if (acceleration >=0 || acceleration <= 25)
            {
                return acceleration++;
            }
        }
        return acceleration;
    }
    public int decreaseAcceleration(int gearPosition)
    {
        gear = gearPosition;
        if(gear == 1) return acceleration--;
        if(gear == 2) return acceleration-=2;
        if(gear == 3) return acceleration-=3;
        if(gear == 4) return acceleration-=4;
        else return acceleration-=1;
    }
}
