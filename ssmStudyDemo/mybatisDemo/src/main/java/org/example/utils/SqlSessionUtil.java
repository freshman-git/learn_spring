package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    public SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //sqlSessionFactory.openSession()  无参方法不会自动提交事务
//        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过将参数设置为true可以自动提交事务，MybatisTest中sqlSession.commit()就不需要了
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
