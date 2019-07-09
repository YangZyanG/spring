package mysql.mybatis.mapper;

import mysql.mybatis.entity.User;

public interface UserMapper {

    void insert(User user);

    User getUser(String id);
}
