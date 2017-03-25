package cn.rayest.template.templateParse;

import cn.rayest.template.Segment;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/22.
 */
public class TestTemplateParse {

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        List<String> segments = parse("");
        assertSegments(segments, "");
    }

    @Test
    public void templateWithOnlyPlainText() throws Exception {
        List<String> segments = parse("plain text only");
        assertSegments(segments, "plain text only");
    }

    private List<String> parse(String template) {
        return new TemplateParse().parse(template);
    }

    private void assertSegments(List<? extends Object> actual, Object... expected) {
        assertEquals(expected.length, actual.size());
        assertEquals(Arrays.asList(expected), actual);
    }

    @Test
    public void parsingMultipleVariables() throws Exception {
        List<String> segments = parse("${a}:${b}:${c}");
        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    @Test
    public void parsingTemplateIntoSegmentObjects() throws Exception {
        TemplateParse parse = new TemplateParse();
        List<Segment> segments = parse.parseSegments("a ${b} c ${d}");
        assertSegments(segments,new PlainText("a "), new Variable("b"), new PlainText(" c "), new Variable("d"));
    }
}
