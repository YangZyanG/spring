import aware.ApplicationContextAwareBean;
import aware.BeanFactoryAwareBean;
import aware.BeanNameAwareBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AwareTest {

    @Test
    public void beanNameAware(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aware.xml");
        BeanNameAwareBean bean = (BeanNameAwareBean) applicationContext.getBean("beanNameAwareBean");
        System.out.println(bean.getBeanName());
    }

    @Test
    public void beanFactoryAware(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aware.xml");
        BeanFactoryAwareBean bean = (BeanFactoryAwareBean) applicationContext.getBean("beanFactoryAwareBean");
        BeanFactory beanFactory = bean.getBeanFactory();
        //获取其他bean
        System.out.println(((BeanNameAwareBean) beanFactory.getBean("beanNameAwareBean")).getBeanName());
        //获取meta额外属性
        BeanDefinition beanDefinition = ((DefaultListableBeanFactory) beanFactory).getBeanDefinition("beanFactoryAwareBean");
        System.out.println(beanDefinition.getAttribute("extra"));
    }

    @Test
    public void applicationContextAware(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aware.xml");
        ApplicationContextAwareBean bean = (ApplicationContextAwareBean) applicationContext.getBean("applicationContextAwareBean");
        bean.getBeans();
    }
}
