import aop.xml.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void xml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.insert();
        userService.update();
    }

    @Test
    public void annotate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        aop.annotate.UserService userService = (aop.annotate.UserService) applicationContext.getBean("userService_1");
        userService.insert();
        userService.update();
    }
}
