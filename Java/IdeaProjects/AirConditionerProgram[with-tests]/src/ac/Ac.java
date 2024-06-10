package ac;

public class Ac {

    private boolean isTheAcOn;
    private int temperature =16;


    public void turnAcOn()
    {
         isTheAcOn = true;
    }
    public void turnAcOff()
    {
        isTheAcOn = false;
    }
    public boolean getStateOfAc()
    {
        return isTheAcOn;
    }
    public int setTemperature(int newTemperature)
    {
        turnAcOn();
        if (newTemperature >= 16 && newTemperature <= 30) temperature = newTemperature;
        return this.temperature;
    }
    public void raiseTemperature()
    {
        turnAcOn();
        if(this.temperature < 30) this.temperature++;
    }
    public void dropTemperature()
    {
        turnAcOn();
        if(this.temperature > 16) this.temperature--;
    }
    public int getAcTemperature()
    {
        turnAcOn();
        return temperature;
    }

}
