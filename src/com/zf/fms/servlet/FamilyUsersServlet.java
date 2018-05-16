package com.zf.fms.servlet;

import com.zf.fms.bean.FamilyUser;
import com.zf.fms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FamilyUsersServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FamilyUser loginUser = (FamilyUser) req.getSession().getAttribute("loginUser");
        List<FamilyUser> familyUsers = userService.getFamilyer();
        req.setAttribute("familyUsers", familyUsers);
        req.getRequestDispatcher("/familyUsers.jsp").forward(req, resp);
    }
}
