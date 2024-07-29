import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestParkingCharges {
    @Test
    void test_thatCalculateCharges_methodCanDetermine_theChargesIncurredByCustomersWhoParksForMoreThan3hours() {
        ParkingCharges calculator = new ParkingCharges();
        double chargesDue = calculator.calculateCharges(5);
        assertEquals(11, chargesDue);
    }
}