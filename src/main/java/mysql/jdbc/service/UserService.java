package mysql.jdbc.service;

import mysql.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {

    public void insert(User user);

    public List<User> getUsers();
}
