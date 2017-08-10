<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Created by IntelliJ IDEA.
 User: Роман
 Date: 05.08.2017
 Time: 10:10
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>
            <form method="post" modelAttribute="user" action="/addUser">
            <input name="username"/>
            <input name="password">
            <select name="roles.id">
                <c:forEach items="${roleList}" var="role" varStatus="status">
                    <option value="${role.id}">
                        <c:out value="${role.name}"/>
                    </option>
                </c:forEach>
            </select>
            <select name="employee.id">
                <c:forEach items="${employeeList}" var="employee" varStatus="status">
                    <option value="${employee.id}">
                        <c:out value="${employee.name}"/>
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="ok">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
        </td>
        <td>
            <form method="post" modelAttribute="role" action="/addRole">
            <input name="name"/>
            <select name="users[0].id">
                <c:forEach items="${userList}" var="user" varStatus="status">
                    <option value="${user.id}">
                        <c:out value="${user.username}"/>
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="ok">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
        </td>
    </tr>
    </thead>
</table>
<h3>Table role</h3>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${roleList}" var="role">
        <tr>
            <td>${role.id}</td>
            <td>${role.name}</td>
            <td><a href="/adminUpdateRole?id=${role.id}">update</a></td>
            <td><a href="/adminDeleteRole?id=${role.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<h3>Table user</h3>
<table>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>employee.id</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.employee.name}</td>
            <td><a href="/adminUpdateUser?id=${user.id}">update</a></td>
            <td><a href="/adminDeleteUser?id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>


</body>

</html>
