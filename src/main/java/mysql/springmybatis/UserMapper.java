package mysql.springmybatis;

import mysql.entity.User;

/**
 * @author yangziyang
 * @since 2020-10-09
 */
public interface UserMapper {

    void insert();

    User getUser(String id);
}
