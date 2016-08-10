package cn.ipay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/8/10 0010.
 */
public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }

}
