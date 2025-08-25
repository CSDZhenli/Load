package com.mybatis;

import com.mapper.PWMapper;
import com.pojo.PW;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CeShi {
    //全查
    @Test
    public void testSelectAll() throws IOException {
        //获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象，并以次执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取PWMapper接口的代理对象
        PWMapper PWMapper = sqlSession.getMapper(PWMapper.class);
        //执行方法
        List<PW> PWList = PWMapper.selectAll();
        System.out.println(PWList);
        //释放资源
        sqlSession.close();
    }
}
