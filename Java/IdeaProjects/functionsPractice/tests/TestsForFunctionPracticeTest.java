import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsForFunctionPracticeTest {
    private AllFunctions functionIdentifier;

    @BeforeEach
    void setUp(){
        functionIdentifier = new AllFunctions();
    }

    @Test
    void test_that_find_sum_of_numbers_work(){
        int actualValue = functionIdentifier.findSumOfTwoNumbers(5, 6);
        int expectedValue = 5 + 6;
        assertEquals(expectedValue, actualValue);
    }
    @Test
    void test_that_minute_to_seconds_converter_works(){
        int actualValue = functionIdentifier.convertMinutesToSeconds(5);
        int  expectedValue = 300;
        assertEquals(expectedValue, actualValue);
    }
    @Test
    void test_function_that_returns_next_int_from_the_original_number_passed_works()
    {
        assertEquals(6, functionIdentifier.findNextInt(5));
    }
    @Test
    void test_number_equality_function()
    {
        boolean expectedValueForFalse = functionIdentifier.isNumberEqual(5, 8);
        assertFalse(expectedValueForFalse);
        boolean expectedValueForTrue = functionIdentifier.isNumberEqual(8, 8);
        assertTrue(expectedValueForTrue);
    }
    @Test
    void test_getVoteCount_function()
    {
        assertEquals(10, functionIdentifier.getVoteCount(35, 25));
    }
}