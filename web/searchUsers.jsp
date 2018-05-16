<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>家庭管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">

    </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > <a style="color: coral">搜索成员</a>
        </div>
        <form action="/searchUser" method="post">
            <fieldset>
                <table class="formtable">
                    <tr>
                        <td>账号名：</td>
                        <td>
                            <input type="text" id="name" name="name" value="${name}" maxlength="20"/>
                        </td>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="查询"/>
                            <input type="reset" class="clickbutton" value="重置"/>
                        </td>

                    </tr>
                </table>
            </fieldset>
        </form>

        <table class="listtable">
            <tr class="listheader">
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>手机号码</th>
                <th>工作</th>
                <th>生日</th>
                <th>地址</th>
            </tr>
            <c:forEach items="${list}" var="user">
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
