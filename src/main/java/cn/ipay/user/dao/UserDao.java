package cn.ipay.user.dao;

import cn.ipay.user.model.User;

import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public interface UserDao {
    void add(User user) throws SQLException;

    void delete(String username) throws SQLException;

    User load(String username) throws SQLException;
}
