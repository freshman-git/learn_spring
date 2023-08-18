package org.example.abstratTest;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {

    @Test
    public void testDataSource() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dataSource.xml");
        DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testDataSource2() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dataSource.xml");
        DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource2");
        System.out.println(dataSource.getConnection());
    }
}
