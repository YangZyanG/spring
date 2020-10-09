package mysql.mybatis.mapper;

import mysql.entity.User;

public interface UserMapper {

    void insert(User user);

    User getUser(String id);
}
