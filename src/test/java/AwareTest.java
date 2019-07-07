import aware.BeanNameAwareBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AwareTest {

    @Test
    public void beanNameAware(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aware.xml");
        BeanNameAwareBean bean = (BeanNameAwareBean) applicationContext.getBean("beanNameAwareBean");
        System.out.println(bean.getBeanName());
    }
}
