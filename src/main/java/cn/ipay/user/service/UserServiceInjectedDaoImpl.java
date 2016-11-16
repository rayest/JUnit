package cn.ipay.user.service;

import cn.ipay.user.dao.UserDao;
import cn.ipay.user.dao.UserDaoImpl;
import cn.ipay.user.model.User;
import cn.ipay.user.model.UserException;

import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/19 0019.
 */
public class UserServiceInjectedDaoImpl implements UserService {
    private UserDao userDao;

    public UserServiceInjectedDaoImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceInjectedDaoImpl() {
        userDao = new UserDaoImpl();
    }

    public void add(User user) throws SQLException {
        if (load(user.getUsername()) != null) {
            throw new UserException("用户名已经存在!");
        }
        userDao.add(user);

    }

    public void delete(String username) throws SQLException {
        userDao.delete(username);

    }

    public User load(String username) throws SQLException {
        return userDao.load(username);
    }

    public User login(String username, String password) throws SQLException {
        User user = load(username);
        if (user == null) {
            throw new UserException("用户名不存在！");
        }
        if (user.getPassword() != password) {
            throw new UserException("用户名密码不存在！");
        }
        return user;
    }
}
