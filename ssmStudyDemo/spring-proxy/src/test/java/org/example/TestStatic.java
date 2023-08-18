package org.example;

import org.example.pojo.Employee;
import org.example.proxy.Calculator;
import org.example.proxy.CalculatorStaticProxy;
import org.example.proxy.ProxyFactory;
import org.example.proxy.impl.CalculatorImpl;
import org.junit.Test;

public class TestStatic {

    @Test
    public void testStatic(){
        Employee employee = new Employee(2);
        Employee employee1 = new Employee(2);
        Employee employee2 = new Employee(2);
        System.out.println(Employee.getId());
    }

    @Test
    public void testStaticProxy(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        int add = proxy.add(1, 2);
        int mul = proxy.mul(1, 2);
        int sub = proxy.sub(2, 1);
        int div = proxy.div(4, 2);
        System.out.println(add+" "+mul+" "+sub+" "+div);
    }

    @Test
    public void testDynamicProxy(){
        /**
         * 动态代理：
         * 1.jdk动态代理：要求必须有接口，最终生成的代理类和目标类实现相同的接口，
         *              生成的代理类在com.sun.proxy包下类名为$proxy7（$proxy加一个数字）
         * 2.cglib动态代理:最终生成的代理类会继承目标类，并且和目标类在相同的包下
         */
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        int add = proxy.add(1, 2);
        int mul = proxy.mul(1, 2);
        int sub = proxy.sub(2, 1);
        int div = proxy.div(4, 2);
        System.out.println(add+" "+mul+" "+sub+" "+div);
    }
}
