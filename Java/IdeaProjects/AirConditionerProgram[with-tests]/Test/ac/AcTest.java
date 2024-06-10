package ac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcTest {

    private Ac odoTronic;

    @BeforeEach
    public void setUp()
    {
        odoTronic = new Ac();
    }


    @Test
    public void testThatAcCanBeSwitchedOn()
    {
        assertFalse(odoTronic.getStateOfAc());
        odoTronic.turnAcOn();
        assertTrue(odoTronic.getStateOfAc());
    }
    @Test
    public void testThatAcCanBeSwitchedOff()
    {
        assertFalse(odoTronic.getStateOfAc());
        odoTronic.turnAcOn();
        assertTrue(odoTronic.getStateOfAc());
        odoTronic.turnAcOff();
        assertFalse(odoTronic.getStateOfAc());

    }
    @Test
    public void testThatAcTemperatureCanBeChanged()
    {
        Ac odoTronic = new Ac();
        odoTronic.turnAcOn();
        odoTronic.setTemperature(15);
        assertEquals(16, odoTronic.getAcTemperature());
    }
    @Test
    public void testThatAcTemperatureCanBeRaised()
    {
        Ac odoTronic = new Ac();
        assertFalse(odoTronic.getStateOfAc());
        odoTronic.turnAcOn();
        assertTrue(odoTronic.getStateOfAc());
    }
    @Test
    public void testThatAcTemperatureCanBeDropped()
    {
        Ac odoTronic = new Ac();
        odoTronic.turnAcOn();
        int dropTempToDegree = 6;
        for (int currentTemperature = 16; currentTemperature > dropTempToDegree; currentTemperature--)
        {
            odoTronic.dropTemperature();
        }
        assertEquals(16, odoTronic.getAcTemperature());
    }
}