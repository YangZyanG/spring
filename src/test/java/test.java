import abstractBean.LookupMethodAbstract;
import bean.ChangeMe;
import bean.ImportBean;
import bean.MyTestBean;
import customize.bean.User;
import factoryBean.Car;
import factoryBean.CarFactoryBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class test {

    @Test
    public void test(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println("name:"+myTestBean.getTest());

        BeanDefinition beanDefinition = ((XmlBeanFactory) beanFactory).getBeanDefinition("myTestBean");
        System.out.println(beanDefinition.getAttribute("test"));
    }

    @Test
    public void lookupMethod(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LookupMethodAbstract lookupMethodAbstract = (LookupMethodAbstract) applicationContext.getBean("lookupMethod");
        lookupMethodAbstract.showMe();
    }

    @Test
    public void replacedMethod(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ChangeMe changeMe = (ChangeMe) applicationContext.getBean("changeMe");
        changeMe.changeMe();
    }

    @Test
    public void alias(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyTestBean myTestBean = (MyTestBean) applicationContext.getBean("aliasMyTestBean");
        System.out.println("name:" + myTestBean.getTest());
    }

    @Test
    public void importBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ImportBean importBean = (ImportBean) applicationContext.getBean("importBean");
        importBean.importBean();
    }

    @Test
    public void customize(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (customize.bean.User) applicationContext.getBean("user");
        System.out.println(user.toString());
    }

    @Test
    public void factoryBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myFactoryBean.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.toString());

        CarFactoryBean carFactoryBean = (CarFactoryBean) applicationContext.getBean("&car");
        System.out.println(carFactoryBean.getCarInfo());
    }
}
