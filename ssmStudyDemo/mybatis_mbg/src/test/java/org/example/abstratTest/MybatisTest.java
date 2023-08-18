package org.example.abstratTest;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;

public class MybatisTest {

    @Test
    public void testMBG() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }
}
