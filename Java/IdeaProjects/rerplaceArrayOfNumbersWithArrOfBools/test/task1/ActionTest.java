package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
    @Test
    void testAction() {
        Action fight = new Action();
        int[] arrOfNums = {4, 5, 8, 8, 8, 2, 9};
        boolean[] answer = fight.conversion(arrOfNums);
        assertArrayEquals(answer, new boolean[]{false, true, false, false, false, false, true});
    }
}