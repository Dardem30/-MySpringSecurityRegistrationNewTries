<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 06.08.2017
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form method="post" modelAttribute="role" action="/adminUpdateRole">
    <spring:input path="id" readonly="true"/>
    <spring:input path="name"/>
    <select name="users[0].id">
        <c:forEach items="${userList}" var="user" varStatus="status">
            <option value="${user.id}">
                <c:out value="${user.username}"/>
            </option>
        </c:forEach>
    </select>
    <spring:button>ok</spring:button>
</spring:form>
</body>
</html>
