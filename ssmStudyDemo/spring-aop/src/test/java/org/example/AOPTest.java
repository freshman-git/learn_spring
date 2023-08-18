package org.example;

import org.example.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void testAop1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int add = calculator.add(1, 2);
        System.out.println(add);
    }

    @Test
    public void testAop2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int mul = calculator.mul(1, 2);
        System.out.println(mul);
    }

    @Test
    public void testAop3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int mul = calculator.div(1, 1);
        System.out.println(mul);
    }
}
