package abstractBean;

import bean.User;

public abstract class LookupMethodAbstract {

    public void showMe(){
        this.getBean().showMe();
    }

    public abstract User getBean();
}
