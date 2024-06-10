package motorBike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsForMotorCycleTest
{
    private MotorBike bmx;

    @BeforeEach
    void test_initializeNewBikeObject_EnsureDefaultStateIsOff()
    {
        bmx =  new MotorBike();
        bmx.checkIfBikeEngineIsOn();
        assertFalse(bmx.checkIfBikeEngineIsOn());
    }
    @Test
    void test_ThatChecks_startEngineWorks()
    {
        bmx.startEngine();
        assertTrue(bmx.checkIfBikeEngineIsOn());
    }
    @Test
    void test_ThatChecks_stopEngineWorks()
    {
        bmx.stopEngine();
        assertFalse(bmx.checkIfBikeEngineIsOn());
    }
    @Test
    void test_ThatChecks_If_clutchCanBeEngagedWhen_BikeEngineIsOff()
    {
        bmx.pullClutchIn("pull");
        assertFalse(bmx.getStateOfClutch());
    }
    @Test
    void test_ThatChecks_If_clutchCanBeEngagedWhen_BikeEngineIsOn()
    {
        bmx.startEngine();
        bmx.pullClutchIn("pull");
        assertTrue(bmx.getStateOfClutch());
    }
    @Test
    void test_check_If_transmissionIsEngaged_WhenClutchIsPulledIn()
    {
        bmx.startEngine();
        bmx.pullClutchIn("pull");
        assertTrue(bmx.getStateOfTransmission());
    }
    @Test
    void test_check_If_transmissionIsDisEngaged_WhenClutchIsReleased()
    {
        bmx.startEngine();
        bmx.pullClutchIn("release");
        assertFalse(bmx.getStateOfTransmission());
    }
    @Test
    void test_check_That_Bike_Accelerates()
    {
        bmx.startEngine();
        bmx.pullClutchIn("pull");
        bmx.putGearOn(3);
        for (int i = 0; i < 18; i++) {
            bmx.increaseAcceleration();
        }
        assertEquals(40, bmx.getAcceleration());
    }
    @Test
    void test_checkIf_Accelerationdecreases()
    {
        bmx.startEngine();
        bmx.pullClutchIn("pull");
        bmx.putGearOn(2);
        for (int i = 0; i < 13; i++) {
            bmx.increaseAcceleration();
        }
       bmx.decreaseAcceleration(2);
       assertEquals(24, bmx.getAcceleration());
    }
}