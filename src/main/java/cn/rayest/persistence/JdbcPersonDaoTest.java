package cn.rayest.persistence;

import com.mockobjects.sql.MockMultiRowResultSet;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/25.
 */
public class JdbcPersonDaoTest {
    @Test
    public void testFindByLastName() throws Exception {
        // 模拟数据库连接
        DataSource dataSource = createMock(DataSource.class);
        Connection connection = createMock(Connection.class);
        expect(dataSource.getConnection()).andReturn(connection);
        String sql = "SELECT * FROM people WHERE last_name = ?";
        PreparedStatement stmt = createMock(PreparedStatement.class);
        expect(connection.prepareStatement(sql)).andReturn(stmt);
        stmt.setString(1, "Smith");
        // 模拟查询结果
        MockMultiRowResultSet resultSet = new MockMultiRowResultSet();
        String[] columns = new String[]{"first_name", "last_name"};
        resultSet.setupColumnNames(columns);
        List<Person> smiths = createListOfPeopleWithLastName("Smith");
        resultSet.setupRows(asResultSetArray(smiths));
        expect(stmt.executeQuery()).andReturn(resultSet);
        // 释放资源
        resultSet.setExpectedCloseCalls(1);
        stmt.close();
        replay(dataSource, connection, stmt);
        // 执行并验证
        JdbcPersonDao dao = new JdbcPersonDao();
        dao.setDataSource(dataSource);
        List<Person> people = dao.findByLastName("Smith");
        assertEquals(smiths, people);
        verify(dataSource, connection, stmt);
        resultSet.verify();
    }

    private Object[][] asResultSetArray(List<Person> people) {
        Object[][] array = new Object[people.size()][2];
        for (int i = 0; i < array.length; i++) {
            Person person = people.get(i);
            array[i] = new Object[]{person.getFirstName(), person.getLastName()};
        }
        return array;
    }

    private List<Person> createListOfPeopleWithLastName(String lastName) {
        List<Person> expected = new ArrayList<Person>();
        expected.add(new Person("Alice", lastName));
        expected.add(new Person("Billy", lastName));
        expected.add(new Person("Clark", lastName));
        return expected;
    }
}
