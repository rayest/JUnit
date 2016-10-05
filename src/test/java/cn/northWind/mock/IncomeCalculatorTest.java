package cn.northWind.mock;

import cn.northWind.mock.exception.CalculationMethodException;
import cn.northWind.mock.exception.PositionException;
import cn.northWind.mock.method.IncomeCalculationMethod;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Rayest on 2016/10/5 0005.
 */

public class IncomeCalculatorTest {
    private IncomeCalculationMethod incomeCalculationMethod;
    private IncomeCalculator incomeCalculator;

    @Before
    public void setUp() throws Exception {
        incomeCalculationMethod = EasyMock.createMock(IncomeCalculationMethod.class); // 创建一个模拟对象
        incomeCalculator = new IncomeCalculator(); // new 一个工资计算器
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalc1() throws Exception {

        // 记录 + 回放
        EasyMock.expect(incomeCalculationMethod.calc(Position.BOSS)).andReturn(7000.00).times(2); // 方法执行两次
        EasyMock.expect(incomeCalculationMethod.calc(Position.MANAGER)).andReturn(5000.00);

        EasyMock.replay(incomeCalculationMethod); // 回放

        // 测试 + 验证
        incomeCalculator.setIncomeCalculationMethod(incomeCalculationMethod); // 测试的开始设置

        try {
            incomeCalculator.calc();
            fail("Exception did not occur");
        }catch (PositionException e){
        }

        incomeCalculator.setPosition(Position.BOSS); // 测试 BOSS , 断言两次
        assertEquals(7000.00, incomeCalculator.calc(), 0);
        assertEquals(7000.00, incomeCalculator.calc(), 0);

        incomeCalculator.setPosition(Position.MANAGER); // 测试 MANAGER，断言一次
        assertEquals(5000.00, incomeCalculator.calc(),0);

        incomeCalculator.setPosition(Position.PROGRAMMER); // 测试 PROGRAMMER，没有断言

        EasyMock.verify(); // 判断这个模拟对象中的所有方法是不是都已经执行完
    }

    @Test(expected = CalculationMethodException.class)
    public void testNoCalculation() throws Exception {
        incomeCalculator.setPosition(Position.MANAGER);
        incomeCalculator.calc();
    }

    @Test(expected = PositionException.class)
    public void testNoPosition() throws Exception {
        EasyMock.expect(incomeCalculationMethod.calc(Position.BOSS)).andReturn(7000.00);
        EasyMock.replay(incomeCalculationMethod);
        incomeCalculator.setIncomeCalculationMethod(incomeCalculationMethod);
        incomeCalculator.calc();
    }

    @Test(expected = PositionException.class)
    public void testCalc2() throws Exception {
        // 记录在接收 manager 参数的时候，执行 cal 方法会抛出 positionException 异常
        EasyMock.expect(incomeCalculationMethod.calc(Position.MANAGER)).andThrow(new PositionException("Don't know this guy")).times(1);
        EasyMock.replay(incomeCalculationMethod);
        incomeCalculator.setPosition(Position.MANAGER);
        incomeCalculator.setIncomeCalculationMethod(incomeCalculationMethod);
        incomeCalculator.calc();
    }
}
