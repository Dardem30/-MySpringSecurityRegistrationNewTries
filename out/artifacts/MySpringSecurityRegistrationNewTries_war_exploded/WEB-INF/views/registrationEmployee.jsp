<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 06.08.2017
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form modelAttribute="employee" action="/registration" method="post">
    <spring:input path="name"/>
    <spring:input path="lastname"/>
    <select name="department.id" path="department">
        <c:forEach items="${listDepartment}" var="department">
            <option value="${department.id}">
                <c:out value="${department.name}"/>
            </option>
        </c:forEach>
    </select>
    <spring:button>ok</spring:button>
</spring:form>
</body>
</html>
