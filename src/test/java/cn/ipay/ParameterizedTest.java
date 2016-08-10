package cn.ipay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/8/10 0010.
 */

@RunWith(Parameterized.class)
public class ParameterizedTest {

    private double expected;
    private double valueOne;
    private double valueTwo;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters(){
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},
                {3, 2, 1},
                {4, 3, 1},
        });
    }

    public ParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() throws Exception {
        Calculator calculator = new Calculator();
        double result = calculator.add(valueOne, valueTwo);
        assertEquals(expected, result, 0);

    }
}
