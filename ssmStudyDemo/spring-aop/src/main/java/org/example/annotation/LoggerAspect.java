package org.example.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect//将当前组件标识为切面

//切面的优先级
//通过@Order注解的value属性设置优先级，默认值Integer的最大值
//@Order注解的value属性值越小，优先级越高
public class LoggerAspect {

    @Pointcut("execution(* org.example.annotation.impl.CalculatorImpl.*(..))")
    public void pointCut(){}


    /**
     *
     * @Before:前置通知，目标对象方法执行之前执行
     * @After：后置通知，目标对象方法的finall子句中执行
     * @AfterReturning：返回通知，在目标对象方法返回值之后执行
     * @AfterThrowing：异常通知，在目标对象方法catch子句中执行
     * @Arroud:环绕通知
     */

//    @Before("execution(public int org.example.annotation.impl.CalculatorImpl.add(int,int))")
//    @Before("execution(* org.example.annotation.impl.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAspectMethod(JoinPoint joinPoint){
//        System.out.println("前置通知");
//        joinPoint是连接点
        Signature signature = joinPoint.getSignature();
//        获得连接点所对应方法的方法名
        String name = signature.getName();
//        获得连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:Before 方法"+name+"参数"+ Arrays.toString(args));

    }

    @After("pointCut()")
    public void afterAspectMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:after 方法"+name+"参数"+ Arrays.toString(args));
    }

//    returning:用来接收目标对象方法的返回值
//    将通知方法的某个参数指定为接收目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAspectMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:afterReturning 方法"+name+"参数"+ Arrays.toString(args)+"结果："+result);
    }


    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void afterThrowingAspectMethod(JoinPoint joinPoint,Throwable exception){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect:afterReturning 方法"+name+"参数"+ Arrays.toString(args)+"异常:"+exception);
    }

    @Around("pointCut()")
    public Object aroundAspectMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕：before");
            result = joinPoint.proceed();
            System.out.println("环绕：afterReturning");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕：throwing");
        }finally {
            System.out.println("环绕：after");
        }
        return result;
    }
}
