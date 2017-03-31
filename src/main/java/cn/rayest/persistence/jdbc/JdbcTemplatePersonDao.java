package cn.rayest.persistence.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by lirui on 2017/3/25.
 */
public class JdbcTemplatePersonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findByLastname(String lastName) {
        return null;
    }
}
