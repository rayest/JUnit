package cn.rayest.persistence;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lirui on 2017/3/25.
 */
public class JdbcPersonDao implements PersonDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

    public List<Person> findByLastName(String lastname) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM people WHERE last_name = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, lastname);
        ResultSet resultSet = stmt.executeQuery();
        List<Person> people = new ArrayList<Person>();
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            people.add(new Person(firstName, lastName));
        }
        resultSet.close();
        stmt.close();
        connection.close();
        return people;

    }

}
