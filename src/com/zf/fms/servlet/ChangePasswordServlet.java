package com.zf.fms.servlet;

import com.zf.fms.bean.FamilyUser;
import com.zf.fms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePasswordServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        //获取当前登录的用户对象
        FamilyUser loginUser = (FamilyUser) req.getSession().getAttribute("loginUser");
        if ("".equals(password)){
                req.setAttribute("error", "请输入新密码");
                req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);
            }else{
                int update = userService.updatePass(password,loginUser.getUserId());
                if (update != -1) {
                    //注册成功，跳往审批
                    req.getSession().removeAttribute("loginUser");
                    resp.sendRedirect(req.getContextPath() + "/index");
                } else {
                    req.setAttribute("error", "注册失败");
                    req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);

                }
            }


          }

}
