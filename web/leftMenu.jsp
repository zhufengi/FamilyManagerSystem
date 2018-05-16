<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="userInfo">个人信息</a></li>
            <li class="sidebar-menuitem"><a href="familyUsers">家庭成员</a></li>
        </ul>
    </div>

        <div class="sidebar-menugroup">
            <div class="sidebar-grouptitle">人员管理</div>
            <ul class="sidebar-menu">
                <c:if test="${loginUser.role==1}">
                <li class="sidebar-menuitem"><a href="regUser">成员注册</a></li>
                </c:if>
                <li class="sidebar-menuitem"><a href="searchUser">搜索成员</a></li>
            </ul>
        </div>


</div>
