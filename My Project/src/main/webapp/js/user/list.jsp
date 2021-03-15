<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/js/common/include.jsp"%>
<head>
    <title>list</title>
</head>
<body style="background: url(${webPath}/static/img/1.jpg)" >
<div style="background: aliceblue">
<input type="button" value="随机新增行" onclick="toAction('${webPath}/user/toInsert')">
    <input type="button" value="新增行" onclick="toAction('${webPath}/user/toInsert2')">
<form id="form" name="form" method="post">
    <td>名称:<input type="text" value="${user.name}" name="name"></td>
    <td>年龄:<input type="text" value="${user.age}" name="age"></td>
    <td>编号:<input type="text" value="${user.id}" name="id"></td>
    <td>部门:<select name="dept">
    <c:forEach items="${dept}" var="dept">
    <option id="${dept.key}" value="${dept.key}">${dept.value}</option>
        <script type="text/javascript">
            <c:if test="${dept.key==user.dept}">
            $("#${dept.key}").attr("selected","selected");
            </c:if>
        </script>
    </c:forEach>
    </select>
    <td><input type="button" value="查询" onclick="toAction('${webPath}/user/list')"></td>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>年龄</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.dept}</td>
                <td><input type="button" value="删除" onclick="toAction('${webPath}/user/toDelete?id=${user.id}')">
                    <input type="button" value="更新" onclick="toAction('${webPath}/user/toUpdate?id=${user.id}')"></td>
            </tr>
        </c:forEach>
    </table>
    页大小:<input type="text" value="${user.pageSize}" name="pageSize">
</form>
当前共${user.rowCount}条数据<br/>
    <input type="button" value="👈上一页">
    <c:forEach items="${pageCount}" var="amount">
        <input type="button" value=${amount}>
    </c:forEach>
    <input type="button" value="👉下一页" onclick="toAction('${webPath}/user/toNext')">
共${user.pageCount}页
</div>
</body>
</html>
