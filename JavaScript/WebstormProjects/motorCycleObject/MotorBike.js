class MotorBike{
    constructor(){
        this.bmx = {
            isEngineOn: false,
            isClutchEngaged: false,
            gear: 0,
            acceleration:0
        }
    }
    getStateOfEngine()
    {
        return this.bmx.isEngineOn;
    }
    startEngine()
    {
        this.bmx.isEngineOn = true;
    }
    stopEngine()
    {
        this.bmx.isEngineOn = false;
    }
    pullClutch(action)
    {
        if(this.bmx.isEngineOn === true && action === "pull") this.bmx.isClutchEngaged= true;
    }
    getStateOfClutch()
    {
        return this.bmx.isClutchEngaged;
    }
    // getStateOfTransmission()
    // {
    //     let isTransmissionEngaged = false;
    //     if(this.getStateOfClutch() === true)
    //     {
    //         isTransmissionEngaged = true;
    //     }
    //     return isTransmissionEngaged;
    // }
}
module.exports =MotorBike;
