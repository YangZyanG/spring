package aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/***
 * BeanFactoryAware用于获取BeanFactory，从而可以获取容器中所有的bean以及一些服务。
 */
public class BeanFactoryAwareBean implements BeanFactoryAware {

    private BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
