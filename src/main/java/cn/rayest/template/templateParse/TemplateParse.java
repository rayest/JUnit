package cn.rayest.template.templateParse;

import cn.rayest.template.Segment;
import cn.rayest.template.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lirui on 2017/3/22.
 */
public class TemplateParse {

    public List<String> parse(String template) {
        List<String> segments = new ArrayList<String>();
        int index = collectSegments(segments, template);
        addTail(segments, template, index);
        addEmptyStringIfTemplateWasEmpty(segments);
        return segments;
    }

    private void addEmptyStringIfTemplateWasEmpty(List<String> segments) {
        if (segments.isEmpty()) {
            segments.add("");
        }
    }

    private int collectSegments(List<String> segments, String source) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]\\}");
        Matcher matcher = pattern.matcher(source);
        int index = 0;
        while (matcher.find()) {
            addPrecedingPlainText(segments, source, matcher, index);
            addVariable(segments, source, matcher);
            index = matcher.end();
        }
        return index;
    }

    private void addPrecedingPlainText(List<String> segments, String source, Matcher matcher, int index) {
        if (index != matcher.start()) {
            segments.add(source.substring(index, matcher.start()));
        }
    }

    private void addVariable(List<String> segments, String src, Matcher matcher) {
        segments.add(src.substring(matcher.start(), matcher.end()));
    }

    private void addTail(List<String> segments, String template, int index) {
        if (index < template.length()) {
            segments.add(template.substring(index));
        }
    }

    public List<Segment> parseSegments(String template) {
        List<Segment> segments = new ArrayList<Segment>();
        List<String> strings = parse(template);
        for (String s : strings) {
            if (Template.isVariable(s)) {
                String name = s.substring(2, s.length() - 1);
                segments.add(new Variable(name));
            }else {
                segments.add(new PlainText(s));
            }
        }
        return null;
    }
}