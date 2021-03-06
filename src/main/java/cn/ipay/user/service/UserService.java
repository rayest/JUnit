package cn.ipay.user.service;

import cn.ipay.user.model.User;

import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public interface UserService {
    void add(User user) throws SQLException;
    void delete(String username) throws SQLException;
    User load(String username) throws SQLException;
    User login(String username, String password) throws SQLException;
}
