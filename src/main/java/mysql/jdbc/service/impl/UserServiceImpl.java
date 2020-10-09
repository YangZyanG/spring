package mysql.jdbc.service.impl;


import mysql.entity.User;
import mysql.jdbc.mapper.UserMapper;
import mysql.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void insert(User user) {
        jdbcTemplate.update("insert into user (id, name, age, sex) values (?, ?, ?, ?)",
                new Object[]{user.getId(), user.getName(), user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR});

        //默认情况下spring事务处理只对RuntimeException方法做事务回滚
//        throw new RuntimeException();
    }

    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from user", new UserMapper());
        return list;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
