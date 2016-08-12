package cn.ipay;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

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
}
