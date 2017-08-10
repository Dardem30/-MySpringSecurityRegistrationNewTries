<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
          href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript"
            src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script>
    <script type="text/javascript"
            src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
            src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
            src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
</head>
<body>
<spring:form method="post" action="/saveEmployeeDate" modelAttribute="employeeDate">
    <div class="well">
        <div id="datetimepicker3" class="input-append">
            <spring:input path="time" data-format="hh:mm:ss" type="text"></spring:input>
            <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
        </div>
        <div id="datetimepicker4" class="input-append">
            <spring:input path="date" data-format="yyyy-MM-dd" type="text"></spring:input>
            <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
        </div>
    </div>
    <select name="employee.id">
        <c:forEach items="${employeeList}" var="employee" varStatus="status">
            <option value="${employee.id}">
                <c:out value="${employee.name}"/>
            </option>
        </c:forEach>
    </select>
    <spring:button>ok</spring:button>
</spring:form>
<script type="text/javascript">
    $(function() {
        $('#datetimepicker3').datetimepicker({
            pickDate: false
        });
    });
        $(function() {
            $('#datetimepicker4').datetimepicker({
                pickTime: false
            });
        });
</script>
</body>
<html>