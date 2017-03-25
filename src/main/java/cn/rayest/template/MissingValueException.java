package cn.rayest.template;

/**
 * Created by lirui on 2017/3/22.
 */
public class MissingValueException  extends RuntimeException{
    public MissingValueException(String message) {
        super(message);
    }
}
