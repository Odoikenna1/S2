import chapter2.BMITable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import chapter2.BMICalculator;

import java.util.Arrays;

import static chapter2.BMITable.*;
import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {
    private  BMICalculator odotronics;
    @BeforeEach
    void setUp(){
        odotronics = new BMICalculator();
    }
    @Test
    void test_That_We_Can_return_Bmi_Table_Enum_Constants(){
        String result = odotronics.getValues();
        System.out.println(result);
        assertEquals(result, Arrays.toString(new BMITable[]{UNDER_WEIGHT, OPTIMUM_WEIGHT, OVERWEIGHT, CLASS1_OBESITY, CLASS2_OBESITY, CLASS3_OBESITY}));
    }

    @Test
    void test_That_calculate_BMI_can_find_user_BMI_status(){
        String result = odotronics.getResult(65,34);
        assertEquals("CLASS3_OBESITY", result);
    }
}