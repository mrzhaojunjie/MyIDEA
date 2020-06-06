package com.sky.Servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();   //从请求中获取Cookie
        if(cookies != null){
            writer.write("您最后一次登陆时间为");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("lastLoginTime")){
                    long l = Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    writer.write(date.toLocaleString());
                }
            }
        }else{
            writer.println("这是您第一次进入本站");
        }
        Cookie time = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        resp.addCookie(time);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
