package org.example.abstratTest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PageTest {

    @Test
    public void testPage() throws IOException {
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页
        Page<Emp> page = PageHelper.startPage(1, 2);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(emps,3);
        boolean hasNextPage = pageInfo.isHasNextPage();
        System.out.println("hasNextPage:"+hasNextPage);
        emps.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
