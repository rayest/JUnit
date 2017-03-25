package cn.rayest.velocity;

/**
 * Created by lirui on 2017/3/25.
 */
public abstract class VelocityTestCase {

    // private VelocityContext context;

    protected  String getWebRoot(){
        return ".";
    }

    protected void setAttribute(String name, Object value){
       // context.put(name, value);
    }

}
