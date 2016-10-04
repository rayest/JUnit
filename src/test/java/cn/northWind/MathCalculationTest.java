package cn.northWind;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/10/4 0004.
 */
public class MathCalculationTest {

    private MathCalculation calculation;

    @Before
    public void setUp() throws Exception {
        calculation = new MathCalculation();
        System.out.println("setUp...");
    }

    @After
    public void tearDown() throws Exception {
        calculation = null;
        System.out.println("Gone...");
    }

    @Test
    public void testAdd() throws Exception {
        int result = calculation.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void testDivide() throws Exception {
        int result = calculation.divide(10, 5);
        assertEquals(2, result);
    }
}
