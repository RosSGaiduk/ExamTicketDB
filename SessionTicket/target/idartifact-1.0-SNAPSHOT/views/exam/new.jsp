<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 11.10.2016
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<sql:setDataSource var="mysrc" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/examlnu"
                   user="root"  password="123456root"/>

<sql:query dataSource="${mysrc}" var="result">
    select * from studentoflnu;
</sql:query>

<c:forEach var="row" items="${result.rows}">
    <div style = "width:60%; height: auto; margin-left: 20%; border: 1px solid orange; float: left;">
    <tr>
        <td><c:out value="${row.id}"/></td>
        <td><c:out value="${row.name}"/></td>
        <td><c:out value="${row.lastname}"/></td>
        <td><c:out value="${row.form}"/></td>
    </tr>
    </div>
</c:forEach>

<div class="headForForms">
</div>
<div class="forms">
    <p><h3 style="margin-left: 40%; color: darkorchid;">Add a new exam</h3></p>
    <form:form action="/createExam" method="post" modelAttribute="newExam">
        <form:label path="date" cssStyle="margin-left: 40%;">Date of subject:<br></form:label>
        <%--<font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font><br>--%>
        <%--<form:input path="date" cssStyle="margin-left: 40%;"/>--%>
        <input name="dateCalendar" type="date" style="margin-left:40%;
        height: 35px; font-size: 18px;border-radius: 3px;
        padding: 0 3px;"/>
        <br>
        <form:label path="hour" cssStyle="margin-left: 40%;">Hour:<br></form:label>
        <form:input path="hour" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; "/>
        <form:label path="minute" cssStyle="margin-left: 40%;">Minute:<br></form:label>
        <form:input path="minute" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;"/>
        <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
    </form:form>
</div>
</body>
</html>
