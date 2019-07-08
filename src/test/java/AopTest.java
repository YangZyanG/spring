import aop.Student;
import aop.pojo.Student_1;
import aop.pojo.Student_2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void exam(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
//        Student_1 student_1 = (Student_1) applicationContext.getBean("student_1");
//        Student_2 student_2 = (Student_2) applicationContext.getBean("student_2");
//
//        student_1.exam();
//        student_2.exam();
        Student student = (Student) applicationContext.getBean("student_1");
        student.exam();
    }
}
