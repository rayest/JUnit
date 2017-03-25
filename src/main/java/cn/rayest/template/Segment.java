package cn.rayest.template;

import java.util.Map;

/**
 * Created by lirui on 2017/3/23.
 */
public interface Segment {
    String evaluate(Map<String, String> variables);
}
