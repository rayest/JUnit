package cn.rayest.template.templateParse;

import cn.rayest.template.Segment;

import java.util.Map;

/**
 * Created by lirui on 2017/3/23.
 */
public class PlainText implements Segment {

    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {

        return text.equals(((PlainText)o).text);
    }

    public String evaluate(Map<String, String> variables) {
        return null;
    }
}
