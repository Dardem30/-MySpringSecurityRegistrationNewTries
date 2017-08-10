<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 23.07.2017
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${user.id}--%>
<%--${user.username}--%>
<%--${user.password}--%>
<%--${employee.name}--%>
<%--${department.name}--%>
${employee.id}
${employee.name}
${employee.lastname}
<%--<c:if test="${not empty employee.messages}">--%>
<%--<c:forEach items="${employee.messages}" var="message">--%>
    <%--${message.text}--%>
<%--</c:forEach>--%>
<%--</c:if>--%>
<%--${message.text}--%>
<%--<a href="/userUpdate?id=${employee.id}">edit</a>--%>
<h4 align="right">your messages</h4>
<table align="right">
<c:forEach items="${messageListEmployee}" var="message">
    <tr>
        <td>${message.text}</td>
    </tr>
</c:forEach>
</table>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/userRole">userRole</a>
    </br>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>lastname</td>
    </tr>
    <c:forEach items="${listEmployee}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.lastname}</td>
        </tr>
    </c:forEach>
</table>
    <%--<a href="/admin">admin</a>--%>
</security:authorize>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
</h2>
<h3>Admins</h3>
<c:forEach items="${listAdmin}" var="admin">
    <tr>
        <td>${admin.name}</td>
        <td>${admin.lastname}</td>
    </tr>
</c:forEach>
<spring:form modelAttribute="message" method="post" action="/sendMessageToAdminEmployee">
    <spring:textarea path="text"/>
    <select  name="employee.id">
        <c:forEach items="${listAdmin}" var="employee" varStatus="status">
            <option value="${employee.id}">
                <c:out value="${employee.name}"/>
            </option>
        </c:forEach>
    </select>
    <spring:button>send</spring:button>
</spring:form>
<a href="/saveEmployeeDate">saveEmployeeDate</a>
<%--<spring:form method="post" action="/saveEmployeeDate" modelAttribute="employeeDate">--%>
    <%--<input type="text" name="time" value="12:12:12">--%>
    <%--<input type="date" name="date">--%>
    <%--<input type="submit" value="ok">--%>
<%--</spring:form>--%>
</body>
</html>
