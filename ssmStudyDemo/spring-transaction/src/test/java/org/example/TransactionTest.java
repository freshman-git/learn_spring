package org.example;

import org.example.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务配置步骤：
 * 1：在Spring的配置文件中配置事务管理器
 * 2：开启事务的注解驱动
 * 在需要被事务管理的方法上，添加@Transactional注解该方法就会被事务管理
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class TransactionTest {


    @Autowired
    private BookController bookController;

    @Test
    public void testByBook(){
        bookController.buyBook(1,1);
    }
}
