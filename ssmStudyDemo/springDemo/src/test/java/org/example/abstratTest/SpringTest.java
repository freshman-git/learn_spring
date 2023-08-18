package org.example.abstratTest;

import org.example.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testHelloWorld(){
        //获取ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        HelloWorld hello = (HelloWorld) context.getBean("hello");
        hello.sayHello();
    }
}
