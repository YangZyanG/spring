package bean;

import java.io.Serializable;

/***
 * 子元素lookup-method示例
 */
public class Teacher extends User implements Serializable {

    @Override
    public void showMe(){
        System.out.println("i am Teacher!");
    }
}
