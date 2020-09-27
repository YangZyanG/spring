package aop.xml;

/**
 * @author yangziyang
 * @since 2020-09-27
 */
public class LogService {

    public void before(){
        System.out.println("before advice");
    }

    public void after(){
        System.out.println("after advice");
    }
}
