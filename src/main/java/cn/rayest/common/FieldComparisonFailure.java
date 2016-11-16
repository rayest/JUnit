package cn.rayest.common;

/**
 * Created by Rayest on 2016/10/6 0006.
 */
public class FieldComparisonFailure {
    private final String filed;
    private final String longString;
    private final String shortString;

    public FieldComparisonFailure(String filed, String longString, String shortString) {
        this.filed = filed;
        this.longString = longString;
        this.shortString = shortString;
    }

    public String getFiled() {
        return filed;
    }

    public String getLongString() {
        return longString;
    }

    public String getShortString() {
        return shortString;
    }
}
