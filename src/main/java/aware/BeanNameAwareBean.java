package aware;

import org.springframework.beans.factory.BeanNameAware;

/***
 * 实现BeanNameAware用于获取当前bean的beanName属性
 */
public class BeanNameAwareBean implements BeanNameAware {

    private String beanName;

    public void setBeanName(String s) {
        beanName = s;
    }

    public String getBeanName() {
        return beanName;
    }
}
