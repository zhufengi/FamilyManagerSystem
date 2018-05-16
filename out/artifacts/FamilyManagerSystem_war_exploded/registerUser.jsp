<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            人员管理 > <a style="color: coral">成员注册</a>
        </div>
        <form method="post" action="doRegUser" accept-charset="UTF-8">
            <fieldset>
                <legend>员工信息</legend>
                <table class="formtable" style="width:50%">


                    <tr>
                        <td>账户名：</td>
                        <td>
                            <input type="text" id="name" name="name" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input type="password" id="password" name="password" maxlength="20"
                                   placeholder="请输入密码"/>
                        </td>
                    </tr>

                    <tr>
                        <td>联系电话：</td>
                        <td>
                            <input type="text" id="phone" name="phone" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>工作：</td>
                        <td>
                            <input type="text" id="work" name="work" maxlength="20"/>
                        </td>
                    </tr>

                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="注册"/>
                            <input type="reset" class="clickbutton" value="重置"/>
                        </td>
                    </tr>

                </table>
            </fieldset>
            <c:if test="${error!=null}">
                <tr>
                    <td colspan="2">${error}</td>
                </tr>
            </c:if>
        </form>
    </div>
</div>

</body>
</html>
