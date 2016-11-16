package cn;

/**
 * Created by Rayest on 2016/10/7 0007.
 */
public class Application {
    public static void main(String[] args) {
        int a = 100;
        int b = 10;
        System.out.println(compare(a, b));
    }

    public static boolean compare(int a, int b) {
        if (a > b) {
            return true;
        }
        return false;
    }
}
