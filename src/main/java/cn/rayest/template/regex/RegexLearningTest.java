package cn.rayest.template.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lirui on 2017/3/22.
 */
public class RegexLearningTest {

    @Test
    public void testHowGroupCountWorks() throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertEquals(1, matcher.groupCount());
    }

    @Test
    public void testFindStartAndEnd() throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertTrue(matcher.find());
        assertEquals(4, matcher.start());
        assertEquals(10, matcher.end());

        assertTrue(matcher.find());
        assertEquals(22, matcher.start());
        assertEquals(28, matcher.end());

        assertFalse(matcher.find());
    }
}
