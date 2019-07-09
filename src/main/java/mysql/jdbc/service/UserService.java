package mysql.jdbc.service;

import mysql.jdbc.entity.User;

import java.util.List;

public interface UserService {

    public void insert(User user);

    public List<User> getUsers();
}
