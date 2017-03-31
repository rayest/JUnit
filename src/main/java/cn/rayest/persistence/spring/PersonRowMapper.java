package cn.rayest.persistence.spring;


import cn.rayest.persistence.jdbc.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lirui on 2017/3/25.
 */
public class PersonRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Person(resultSet.getString("first_name"), resultSet.getString("last_name"));
    }
}
