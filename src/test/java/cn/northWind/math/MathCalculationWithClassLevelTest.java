package cn.northWind.math;

import cn.northWind.math.MathCalculationWithClassLevel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/10/4 0004.
 */
public class MathCalculationWithClassLevelTest {

    @BeforeClass // 在测试类测试之前进行运行该方法，仅一次
     public static void setUpBeforeClass() throws Exception {
        System.out.println("setUp...");
    }

    @AfterClass // 在测试类测试结束后进行运行该方法，仅一次
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDown...");
    }

    @Test
    public void testMinus() throws Exception {
        MathCalculationWithClassLevel calculation = new MathCalculationWithClassLevel();
        int result = calculation.minus(10, 3);
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() throws Exception {
        MathCalculationWithClassLevel calculation = new MathCalculationWithClassLevel();
        int result = calculation.multiply(10, 3);
        assertEquals(30, result);
    }
}
