package cn.rayest;

import cn.rayest.template.Template;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rayest on 2016/11/16 0016.
 * 模板引擎测试
 */
public class TemplateTest {
    @Test
    public void testOneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }
}
