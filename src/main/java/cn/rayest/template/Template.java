package cn.rayest.template;

/**
 * Created by Rayest on 2016/11/16 0016.
 */
public class Template {
    private String variableValue;

    public Template(String templateText) {
    }

    public void set(String variable, String value){
        this.variableValue = value;
    }

    public String evaluate(){
        return "Hello, " + variableValue;
    }
}
