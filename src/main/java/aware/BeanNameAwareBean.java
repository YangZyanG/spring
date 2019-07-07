package aware;

import org.springframework.beans.factory.BeanNameAware;

/***
 * 实现BeanNameAware用于过去当前bean的name属性
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
