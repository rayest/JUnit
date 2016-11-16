package cn.ipay.user.dao;

import cn.ipay.user.model.User;
import cn.ipay.user.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rayest on 2016/8/18 0018.
 */
public class UserDaoImpl implements UserDao {

    public void add(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_user (username, password, nickname) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getNickname());
        preparedStatement.executeUpdate();
        DbUtil.close(preparedStatement);
        DbUtil.close(connection);

    }

    public void delete(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = DbUtil.getConnection();
        String sql = "DELETE FROM t_user WHERE username = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
        DbUtil.close(preparedStatement);
        DbUtil.close(connection);
    }

    public User load(String username) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE username = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (user == null){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
            }
        }
        DbUtil.close(resultSet);
        DbUtil.close(preparedStatement);
        DbUtil.close(connection);
        return user;
    }

}
