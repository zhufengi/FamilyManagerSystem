<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>家庭管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            个人中心 > <a style="color: coral">个人信息</a>
        </div>
        <table class="listtable">
            <caption>
                我的个人信息:
            </caption>
            <tr class="listheader">
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>手机号码</th>
                <th>工作</th>
                <th>生日</th>
                <th>地址</th>
            </tr>
            <c:forEach items="${familyUser}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td>${user.phone}</td>
                    <td>${user.work}</td>
                    <td><fmt:formatDate value="${user.birthTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>${user.birthAddress}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
