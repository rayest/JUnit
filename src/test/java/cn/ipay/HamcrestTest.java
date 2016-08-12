package cn.ipay;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;

/**
 * Created by Rayest on 2016/8/12 0012.
 */

public class HamcrestTest {
    private List<String> values;

    @Before
    public void setUpList(){
        values = new ArrayList<String>();
        values.add("1");
        values.add("2");
        values.add("3");
    }

    @Test
    public void testWithoutHamcrest(){
        assertTrue(values.contains("1") || values.contains("2")|| values.contains("3"));
    }

    @Test
    public void testWithHamcrest(){
        assertThat(values, hasItem(anyOf(equalTo("1"), equalTo("2"), equalTo("3"))));
    }
}
