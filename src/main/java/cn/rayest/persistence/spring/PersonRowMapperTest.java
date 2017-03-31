package cn.rayest.persistence.spring;

import cn.rayest.persistence.jdbc.Person;
import com.mockobjects.sql.MockSingleRowResultSet;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * Created by lirui on 2017/3/25.
 */
public class PersonRowMapperTest {
    @Test
    public void testMappingRow() throws Exception{
        Person expected = new Person("John", "Doe");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("first_name", expected.getFirstName());
        data.put("last_name", expected.getLastName());
        MockSingleRowResultSet resultSet = new MockSingleRowResultSet();
        resultSet.addExpectedNamedValues(data);
        assertEquals(expected, new PersonRowMapper().mapRow(resultSet, 1));
    }
}
