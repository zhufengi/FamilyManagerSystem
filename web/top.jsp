<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-header">
    <div class="header-title">
        欢迎访问家庭管理系统
    </div>
    <div class="header-quicklink">
        欢迎您<strong><c:if test="${loginUser!=null}">,${loginUser.name}</c:if></strong>
        <a href="changepassword.jsp">[修改密码]</a>
    </div>
</div>
