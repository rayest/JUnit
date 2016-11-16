package cn.ipay.user.util;

import java.sql.*;

/**
 * Created by Rayest on 2016/8/19 0019.
 */
public class DbUtil {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        DriverManager.getConnection("jdbc:mysql://localhost:3306/junit", "root", "199011081108");
        return connection;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
