package com.sky.Servlet.servlet;

import com.sky.Servlet.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/s1")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        resp.setContentType("text/html;charset=GBK");

        HttpSession session = req.getSession();
        session.setAttribute("name",new Person("陈沛鑫",18));
        String sessionId = session.getId();
        if(session.isNew()){
            resp.getWriter().write("创建成功，其ID为"+sessionId);
        }else{
            resp.getWriter().write("Session已经存在，其ID为"+sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
