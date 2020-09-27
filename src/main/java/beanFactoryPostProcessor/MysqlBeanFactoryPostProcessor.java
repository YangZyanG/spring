package beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * @author yangziyang
 * @since 2020-09-24
 */
public class MysqlBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("mysqlAccount");
        beanDefinition.getPropertyValues().add("username", "caicaizi");
    }
}
