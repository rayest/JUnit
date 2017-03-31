package cn.rayest.persistence.hibernate;

import cn.rayest.persistence.jdbc.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/3/25.
 */
public class HibernatePersonDaoTest {

    private SessionFactory factory;
    private Session session;
    private Query query;

    @Before
    public void setUp() {
        factory = createMock(SessionFactory.class);
        session = createMock(Session.class);
        query = createMock(Query.class);
    }

    @Before
    public void testFindByLastName() throws SQLException {
        String hql = "";
        String lastname = "Smith";
        List<Person> theSmiths = new ArrayList<Person>();
        theSmiths.add(new Person("Alice", lastname));
        theSmiths.add(new Person("Billy", lastname));
        theSmiths.add(new Person("Clark", lastname));

        expect(factory.getCurrentSession()).andReturn(session);
        expect(session.createQuery(hql)).andReturn(query);
        expect(query.list()).andReturn(theSmiths);

        replay(factory, session,query);

        HibernatePersonDao dao = new HibernatePersonDao();
        dao.setSessionFactory(factory);
        assertEquals(theSmiths, dao.findByLastName(lastname));

        verify(factory, session, query);
    }

}
