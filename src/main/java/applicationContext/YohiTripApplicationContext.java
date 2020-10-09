package applicationContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangziyang
 * @since 2020-09-23
 */
public class YohiTripApplicationContext extends ClassPathXmlApplicationContext {

    public YohiTripApplicationContext() {

    }

    public YohiTripApplicationContext(String configLocation) {
        super(configLocation);
    }

    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        super.setAllowBeanDefinitionOverriding(false);
        super.setAllowCircularReferences(true);
        super.customizeBeanFactory(beanFactory);
    }

    protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory){
        beanFactory.registerResolvableDependency(ApplicationContext.class, this);
        super.prepareBeanFactory(beanFactory);
    }

    protected void postProcessBeanFactory(BeanFactory beanFactory){

    }
}
