package factoryBean;

import bean.MyTestBean;

public class MyTestBeanFactory {

    public MyTestBean getBean(){
        return new MyTestBean();
    }
}
