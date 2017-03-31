package cn.rayest.persistence.hibernate;

import cn.rayest.persistence.jdbc.Person;
import cn.rayest.persistence.jdbc.PersonDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lirui on 2017/3/25.
 */
public class HibernatePersonDao implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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

    public List findByLastName(String lastName) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Person p where p.lastName = :lastName";
        Query query = session.createQuery(hql);
        query.setParameter("lastName", lastName);
        return query.list();
    }
}
