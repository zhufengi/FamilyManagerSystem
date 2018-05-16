package com.zf.fms.servlet;

import com.zf.fms.bean.FamilyUser;
import com.zf.fms.service.UserService;
import com.zf.fms.utils.Utf8Tool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DoRegUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String work = req.getParameter("work");
        String utfName = Utf8Tool.toChinese(name);
        String utfWork = Utf8Tool.toChinese(work);
        System.out.println("work===:"+work);
        int userCount = userService.getUserCount();
        FamilyUser familyUser = new FamilyUser((userCount+1),utfName,null,null,password, phone, utfWork, null, null,2);
        int reg = userService.reg(familyUser);
        if (reg != 0 && reg != -1) {
            //注册成功
            resp.sendRedirect(req.getContextPath()+"/userInfo");
        } else  {
            //用户名重复，注册失败
            req.setAttribute("error", "用户名重复，注册失败");
            req.getRequestDispatcher("/registerUser.jsp").forward(req, resp);
        }
    }
}
