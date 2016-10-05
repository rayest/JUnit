package cn.northWind.mock.method;

import cn.northWind.mock.Position;

/**
 * Created by Rayest on 2016/10/5 0005.
 * 工资计算方法的简单实现
 */
public class IncomeCalculationMethodImpl implements IncomeCalculationMethod {
    public double calc(Position position) {
        double d = 0;
        switch (position) {
            case BOSS:
                d = 7000.00;
                break;
            case MANAGER:
                d = 5000.00;
                break;
            case PROGRAMMER:
                d = 3000.00;
                break;
        }
        return d;
    }
}
