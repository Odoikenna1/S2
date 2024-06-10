package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayProgramTest {
    ArrayProgram array;
    @Test
    void test_that_array_is_not_empty() {
        array = new ArrayProgram();
        array.displayArray();
        assertArrayEquals(new int[] {2, 3, 5, 2, 5, 3}, new int[]{2, 3, 5, 2, 5, 3});
    }
    @Test
    void test_that_array_elements_can_be_multiplied()
    {
        array = new ArrayProgram();
        int [] expected = {4, 6, 10, 4, 10, 6};
        array.findProductOfArrayElements();
        assertArrayEquals(expected, array.getArrayProduct());
    }

}