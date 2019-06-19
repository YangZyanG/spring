package bean;

/***
 * 子元素lookup-method示例
 */
public class Teacher extends User {

    @Override
    public void showMe(){
        System.out.println("i am Teacher!");
    }
}
