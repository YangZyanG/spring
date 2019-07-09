package mysql.jdbc.mapper;

import mysql.jdbc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 创建表与实体间的映射
 */
public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(resultSet.getString("id"), resultSet.getString("name"),
                resultSet.getInt("age"), resultSet.getString("sex"));
        return user;
    }
}
