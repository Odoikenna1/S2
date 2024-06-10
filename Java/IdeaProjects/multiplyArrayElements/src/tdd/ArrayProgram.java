package tdd;

import java.util.Arrays;

public class ArrayProgram {
    private int[] arrayOfNumbers = {2, 3, 5, 2, 5, 3};
    private int[] productOfArrayElements = new int [arrayOfNumbers.length];

    public String displayArray() {
        return Arrays.toString(arrayOfNumbers);
    }

    public void findProductOfArrayElements() {
        for (int i = 0; i < arrayOfNumbers.length; i++)
        {
            productOfArrayElements[i] = arrayOfNumbers[i] * 2;
        }
    }
    public int[] getArrayProduct()
    {
        return productOfArrayElements;
    }
}
