package com.web;

import com.mapper.PWMapper;
import com.pojo.PW;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置req的编码
        req.setCharacterEncoding("UTF-8");
        //调用mybatis查询密码有无对应id
        //获取密码
        String password = req.getParameter("password");
        System.out.println(password);
        //获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        PWMapper pwMapper = sqlSession.getMapper(PWMapper.class);
        //调用方法
        PW id = pwMapper.selectIdByPassword(password);
        //判断
        if(id!=null){
            int id0 = id.getId();
            if (id0 == 1) {
                //调用方法
                String url = pwMapper.selectUrlById(id0).getUrl();
                System.out.println("https://www.gonethings.cloud/"+url);
                resp.sendRedirect("https://www.gonethings.cloud/"+url);
            }else if (id0 == 2) {
                //调用方法
                String url = pwMapper.selectUrlById(id0).getUrl();
                System.out.println(url);
                resp.sendRedirect("https://www.bilibili.com/video/"+url);
            }else {
                resp.sendRedirect("/Load/false.html");
            }
        }else{
            resp.sendRedirect("/Load/false.html");
        }
        //释放资源
        sqlSession.close();
    }
}
