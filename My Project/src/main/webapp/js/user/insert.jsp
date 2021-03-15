<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setAttribute("webPath", request.getContextPath());%>
<html>
<head>
    <title>更新</title>
</head>
<body>
<div>id:${user.id}</div>
<form:form method="post" action="${webPath}/user/toUpdate2" modelAttribute="user" >
    <form:input path="id" style="display:none"/>
    姓名:<form:input path="name"/>
    <br/>
    年龄:<form:input path="age"/>
    <br/>
    部门:<form:select path="dept" items="${dept}"></form:select>
    <input type="submit" value="保存">
</form:form>
</body>
</html>
