package com.zf.fms.servlet;

import com.zf.fms.bean.FamilyUser;
import com.zf.fms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FamilyUser> familyUser = new ArrayList<>();
        FamilyUser loginUser = (FamilyUser) req.getSession().getAttribute("loginUser");
        familyUser.add(loginUser);
        req.setAttribute("familyUser", familyUser);
        req.getRequestDispatcher("/userInfo.jsp").forward(req, resp);
    }
}
