package com.zf.fms.servlet;

import com.zf.fms.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int login = userService.login(username, password);
        ServletContext sc = req.getServletContext();
//        Object visitcount = sc.getAttribute("vc");
//        if (visitcount == null) {
//            visitcount = "0";
//        }
//        int vc = Integer.parseInt(visitcount.toString()) + 1;
//        sc.setAttribute("vc", vc);

        if (login == -1){
            req.setAttribute("error", "用户名或者密码输入错误，请重新登录");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else {
            req.getSession().setAttribute("loginUser", userService.getLoginUser());
            resp.sendRedirect(req.getContextPath() + "/userInfo");
        }
    }
}
