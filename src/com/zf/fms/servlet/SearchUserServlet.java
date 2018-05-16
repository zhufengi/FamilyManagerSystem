package com.zf.fms.servlet;


import com.zf.fms.bean.FamilyUser;
import com.zf.fms.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<FamilyUser> list = userService.searchEmp(name);
        req.setAttribute("list", list);
        req.setAttribute("name", name);
        req.getRequestDispatcher("/searchUsers.jsp").forward(req, resp);
    }
}
