package cn.rayest.persistence.hibernate;

import cn.rayest.persistence.jdbc.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lirui on 2017/3/25.
 */
public class HibernatePersonDaoIntegrationTest {

    @Test
    public void persistedObjectsExistsInDatabase() throws Exception {
        SessionFactory factory = getSessionFactory();
        HibernatePersonDao dao = new HibernatePersonDao();
        dao.setSessionFactory(factory);
        Person person = new Person("John", "Doe");
        dao.save(person);
        assertNotNull(person.getId());

        Session session = factory.openSession();
        Object copy = session.get(Person.class, person.getId());
        assertEquals(person, copy);
    }

    private SessionFactory getSessionFactory() throws IOException {
        return createConfiguration().buildSessionFactory();
    }

    private Configuration createConfiguration() throws IOException {
        // 从类路径中载入产品确认信息
        Configuration configuration = loadProductionConfiguration();
        loadTestConfigurationInto(configuration, "../resources/hibernate.test.properties");
        return configuration;
    }

    private void loadTestConfigurationInto(Configuration configuration, String path) throws IOException {
        // 从文件中载入测试确认信息
        Properties properties = loadPropertiesFrom(path);
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            // 覆盖单个属性
            configuration.setProperty(key, value);
        }
    }

    private Properties loadPropertiesFrom(String path) throws IOException {
        InputStream stream = getClass().getResourceAsStream(path);
        assertNotNull("Resource not found: " + path, stream);
        Properties properties = new Properties();
        properties.load(stream);
        stream.close();
        return properties;
    }

    private Configuration loadProductionConfiguration() {
        return new Configuration().configure();
    }

}
