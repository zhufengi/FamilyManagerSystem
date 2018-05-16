package com.zf.fms.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public class PermissFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String servletPath = req.getServletPath();
        if ("/index.jsp".equals(servletPath)){
            filterChain.doFilter(req,servletResponse);
        }else {
            Object loginUser = req.getSession().getAttribute("loginUser");
            if (loginUser == null){
                ((HttpServletResponse)servletResponse).sendRedirect(req.getContextPath()+"/index.jsp");
            }else {
                filterChain.doFilter(req,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
