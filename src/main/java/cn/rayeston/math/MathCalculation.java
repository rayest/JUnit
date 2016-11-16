package cn.rayeston.math;

/**
 * Created by Rayest on 2016/10/4 0004.
 */

public class MathCalculation {

    public int add(int a, int b){
        return a + b;
    }

    public int divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException("除数不能为 0");
        }
        return a / b;
    }
}
