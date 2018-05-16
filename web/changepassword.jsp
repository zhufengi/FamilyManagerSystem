<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/13 0013
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        修改密码
        </div>
        <form method="post" action="/changePassword">
            <fieldset>
                <legend>修改密码信息</legend>
                <table class="formtable" style="width:50%">
                    <%--<tr>--%>
                        <%--<td>原密码:</td>--%>
                        <%--<td>--%>
                            <%--<input id="origin" type="password" name="password"/>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td>新密码:</td>
                        <td>
                            <input id="new" type="password" name="password"/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="确认修改" class="clickbutton"/>
                            <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                        </td>
                    </tr>
                </table>
                <c:if test="${error!=null}">
                    <tr>
                        <td colspan="2">${error}</td>
                    </tr>
                </c:if>
            </fieldset>
        </form>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="xiguasince@163.com">管理员</a>
</div>
</body>
</html>
