package cn.rayeston.mock;

import cn.rayeston.mock.exception.CalculationMethodException;
import cn.rayeston.mock.exception.PositionException;
import cn.rayeston.mock.method.IncomeCalculationMethod;

/**
 * Created by Rayest on 2016/10/5 0005.
 * 收入计算器
 */
public class IncomeCalculator {
    private IncomeCalculationMethod incomeCalculationMethod;
    private Position position;
    public void setIncomeCalculationMethod(IncomeCalculationMethod incomeCalculationMethod) {
          this.incomeCalculationMethod = incomeCalculationMethod;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double calc(){
        if (incomeCalculationMethod == null){
            throw new CalculationMethodException("IncomeCalculationMethod not yet maintain");
        }
        if (position == null){
            throw new PositionException("Position not yet maintain");
        }
        return incomeCalculationMethod.calc(position);
    }

}
