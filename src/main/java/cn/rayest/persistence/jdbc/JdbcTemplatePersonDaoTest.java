package cn.rayest.persistence.jdbc;

import cn.rayest.persistence.spring.PersonRowMapper;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/25.
 */
public class JdbcTemplatePersonDaoTest {

    @Test
    public void testFindByLastname() throws Exception {
        final String lastName = "Smith";
        final List<Person> smiths = createListOfPeopleNamedSmith(lastName);
        JdbcTemplate template = createMock(JdbcTemplate.class);
        template.query(eq("SELECT * FROM employee WHERE last_name = ?"), aryEq(new Object[]{lastName}), isA(PersonRowMapper.class));
        expectLastCall().andReturn(smiths);
        replay(template);

        JdbcTemplatePersonDao dao = new JdbcTemplatePersonDao();
        dao.setJdbcTemplate(template);
        assertEquals(smiths, dao.findByLastname(lastName));
        verify(template);
    }

    private List<Person> createListOfPeopleNamedSmith(String lastName) {
        List<Person> expectedList = new ArrayList<Person>();
        expectedList.add(new Person("Alice", lastName));
        expectedList.add(new Person("Billy", lastName));
        expectedList.add(new Person("Clark", lastName));
        return expectedList;
    }

}
