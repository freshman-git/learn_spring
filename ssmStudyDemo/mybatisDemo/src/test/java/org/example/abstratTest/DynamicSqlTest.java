package org.example.abstratTest;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DynamicSqlTest {

    @Test
    public void testDynamicSQL() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp(1, "张三", 20, "男",1);
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }
}
