package cn.rayest.persistence;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lirui on 2017/3/25.
 */
public interface PersonDao {

    Person find(Integer id);

    void save(Person person);

    void update(Person person);

    void delete(Person person);

    List<Person> findAll();

    List<Person> findByLastName(String lastName) throws SQLException;
}
