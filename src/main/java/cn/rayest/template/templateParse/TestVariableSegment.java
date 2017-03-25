package cn.rayest.template.templateParse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/23.
 */
public class TestVariableSegment {

    @Test
    public void variableEvaluatesToItsValue() throws Exception{
        Map<String, String> variables = new HashMap<String, String>();
        String name = "myvar";
        String value = "myvalue";
        variables.put(name, value);
        assertEquals(value, new Variable(name).evaluate(variables));
    }


}
