import mysql.jdbc.entity.User;
import mysql.jdbc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MysqlTest {

    @Test
    public void jdbc(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jdbc.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");

        User user = new User();
        user.setId("1");
        user.setName("yangzy");
        user.setAge(27);
        user.setSex("male");

        userService.insert(user);

        List<User> list = userService.getUsers();
        for (User temp : list){
            System.out.println(temp.getId() + ", " + temp.getName() + ", " + temp.getAge() + ", " + temp.getSex());
        }
    }
}
