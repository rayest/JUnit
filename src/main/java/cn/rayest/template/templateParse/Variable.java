package cn.rayest.template.templateParse;

import cn.rayest.template.Segment;

import java.util.Map;

/**
 * Created by lirui on 2017/3/23.
 */
public class Variable implements Segment {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        return name.equals(((Variable)o).name);
    }

    public String evaluate(Map<String, String> variables) {
        return null;
    }
}
