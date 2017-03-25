package cn.rayest.template.templateParse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/23.
 */
public class TestPlainTextSegment {
    @Test
    public void plainTextEvaluatesAsIs() throws Exception{
        Map<String, String> variables = new HashMap<String, String>();
        String text = "abc def";
        assertEquals(text, new PlainText(text).evaluate(variables));
    }
}
