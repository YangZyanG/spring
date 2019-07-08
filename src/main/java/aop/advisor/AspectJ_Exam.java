package aop.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJ_Exam {

    @Pointcut("execution(* aop.Student.exam(..))")
    public void exam(){

    }

    @Before("exam()")
    public void beforeExam(){
        System.out.println("开始考试..");
    }

    @After("exam()")
    public void afterExam(){
        System.out.println("离开考场..");
    }

    @Around("exam()")
    public Object aroundExam(ProceedingJoinPoint point){
        System.out.println("进入考场..");

        Object object = null;
        try{
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("考试结束..");
        return object;
    }
}
