package com.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/false.html")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取Cookie
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[] cookies=req.getCookies();
        if(cookies!=null) {
            for(Cookie cookie:cookies) {
                if(Objects.equals(cookie.getName(), "the_third") && Objects.equals(cookie.getValue(), "/death.html")) {
                    //
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }else{
            //跳转index.html
            req.getRequestDispatcher("/index.html").forward(servletRequest, servletResponse);
        }
    }
    @Override
    public void destroy() {
    }
}
