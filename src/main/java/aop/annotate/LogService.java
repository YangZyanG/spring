package aop.annotate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author yangziyang
 * @since 2020-09-27
 */

@Aspect
public class LogService {

    @Pointcut("execution(public void aop.annotate.UserService.insert(..))")
    public void pointcut(){

    }

//    @Before("pointcut()")
//    public void before(){
//        System.out.println("before advice");
//    }
//
//    @After("pointcut()")
//    public void after(){
//        System.out.println("after advice");
//    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before advice");
        System.out.println("用户插入失败");
//        joinPoint.proceed(joinPoint.getArgs());
        System.out.println("after advice");
    }
}
