package org.example.abstratTest;

import org.example.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-factory.xml");
        User bean = (User) context.getBean("beanFactory");
        System.out.println(bean);
    }
}
