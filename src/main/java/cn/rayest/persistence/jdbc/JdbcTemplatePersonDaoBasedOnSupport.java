package cn.rayest.persistence.jdbc;

import cn.rayest.persistence.spring.PersonRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lirui on 2017/3/25.
 */
public class JdbcTemplatePersonDaoBasedOnSupport extends JdbcDaoSupport implements PersonDao {
    public Person find(Integer id) {
        return null;
    }

    public void save(Person person) {

    }

    public void update(Person person) {

    }

    public void delete(Person person) {

    }

    public List<Person> findAll() {
        return null;
    }

    public List<Person> findByLastName(String lastName) throws SQLException {
        String sql = "SELECT * FROM employee WHERE last_name = ?";
        String[] args = new String[]{lastName};
        RowMapper mapper = new PersonRowMapper();
        return getJdbcTemplate().query(sql, args, mapper);
    }
}
