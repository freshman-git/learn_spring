package org.example.abstratTest;

import org.example.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {


    @Test
    public void testLifeCycle(){
        //ApplicationContext是没有提供close方法的
        //ApplicationContext的子接口ConfigurableApplicationContext有close

        //单例模式在获取ioc容器时就执行了生命周期的前三步，实例化，依赖注入，初始化
        //多例模式在获取bean的时候才执行
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
        //bean的destroy方法在ioc容器关闭之后才会执行销毁方法
        context.close();
    }
}
