package mysql.spring_mybatis.mapper;

import mysql.spring_mybatis.entity.User;

public interface UserMapper {

    void insert(User user);

    User getUser(String id);
}
