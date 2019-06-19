import abstractBean.LookupMethodAbstract;
import bean.ChangeMe;
import bean.MyTestBean;
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
}
