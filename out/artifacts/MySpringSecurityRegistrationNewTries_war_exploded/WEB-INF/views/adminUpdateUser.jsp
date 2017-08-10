<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 06.08.2017
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="user" method="post" action="/adminUpdateUser">
    <spring:input path="id" readonly="true"/>
    <spring:input path="username"/>
    <spring:input path="password"/>
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
    <spring:button>ok</spring:button>
</spring:form>
</body>
</html>
