<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/17 0017
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>家庭管理系统</title>
    <link rel="stylesheet" href="styles/common.css">
  </head>
  <body background="images/login_bg.jpg" class="background1">
    <div class="center1">
      <form method="post" action="index" style="margin-top: 25px">
        <tr class="text1" >
          <td>帐  号:</td>
          <td>
            <input type="text" id="username" name="username">
          </td>
        </tr>
        <br><br>
        <tr class="text1">
          <td>密  码:</td>
          <td>
            <input type="password" id="word" name="password">
          </td>
        </tr>
        <br><br>
        <tr>
          <td>
            <input type="submit" value="登录" class="clickbutton2">
          </td>
        </tr>
        <br><br>
        <c:if test="${error!=null}">
          <tr>
            <td colspan="2">${error}</td>
          </tr>
        </c:if>

      </form>
    </div>
  </body>
</html>
