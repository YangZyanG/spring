import mysql.jdbc.entity.User;
import mysql.jdbc.service.UserService;
import mysql.mybatis.mapper.UserMapper;
import mysql.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MysqlTest {

    @Test
    public void jdbc(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mysql-jdbc.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");

        User user = new User();
        user.setId("3");
        user.setName("yangzy");
        user.setAge(27);
        user.setSex("male");

        userService.insert(user);

        List<User> list = userService.getUsers();
        for (User temp : list){
            System.out.println(temp.getId() + ", " + temp.getName() + ", " + temp.getAge() + ", " + temp.getSex());
        }
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

    @Test
    public void mybatis(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            mysql.mybatis.entity.User user = new mysql.mybatis.entity.User("2222", "yangziyang", 27, "male");
            userMapper.insert(user);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void springMybatis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mysql-spring-mybatis.xml");
        mysql.spring_mybatis.mapper.UserMapper userMapper = (mysql.spring_mybatis.mapper.UserMapper) applicationContext.getBean("userMapper");
        System.out.println(userMapper.getUser("1"));
    }
}
