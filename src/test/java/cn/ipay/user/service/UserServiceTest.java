package cn.ipay.user.service;

import cn.ipay.user.model.User;
import cn.ipay.user.model.UserException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class UserServiceTest {
    private UserService userService;
    private User baseUser;

    private void assertUserEquals(User user, User testUser) {
        assertEquals(testUser.getUsername(), user.getUsername());
        assertEquals(testUser.getPassword(), user.getPassword());
        assertEquals(testUser.getNickname(), user.getNickname());
    }

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
        baseUser = new User("admin", "123", "π‹¿Ì‘±");
    }

    @Test
    public void testAdd() throws Exception {
        userService.add(baseUser);
        User testUser = userService.load("admin");
        assertNotNull(testUser);
        assertUserEquals(baseUser, testUser);
    }

    @Test(expected = UserException.class)
    public void testAddExistUsername() throws Exception {
        userService.add(baseUser);
        User user = new User("admin", "123", "123");
        userService.add(user);
    }

    @Test
    public void testDelete() throws Exception {
        userService.add(baseUser);
        User testUser = userService.load(baseUser.getUsername());
        assertNotNull(testUser);
        userService.delete(baseUser.getUsername());
        testUser = userService.load(baseUser.getUsername());
        assertNull(testUser);
    }

    @Test
    public void testLogin() throws Exception {
        userService.add(baseUser);
        String username = "admin";
        String password = "123";
        User testUser = userService.login(username, password);
        assertUserEquals(baseUser, testUser);
    }

    @Test(expected = UserException.class)
    public void testNotExistUserLogin() throws Exception {
        userService.add(baseUser);
        String username = "admin";
        String password = "123";
        userService.login(username, password);

    }

    @Test(expected = UserException.class)
    public void testPasswordErrorUserLogin() throws Exception {
        userService.add(baseUser);
        String username = "admin";
        String password = "123";
        userService.login(username, password);
    }
}
