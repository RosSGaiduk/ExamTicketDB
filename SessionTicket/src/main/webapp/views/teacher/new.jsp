<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 10.10.2016
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle1.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <%--<script src="/resources/scripts/autoScrollDown.js"></script>--%>
</head>
<body>
<div class="headForForms">
</div>
<div class="forms">
<%--<p><h3 style="margin-left: 0%; color: black;">Add a new teacher</h3></p>--%>
<form:form action="/createTeacher" method="post" modelAttribute="newTeacher">

    <form:label path="name"><h3 style="margin-left: 40%;">Teacher's name: </h3></form:label>
    <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font>
    <form:input path="name" cssClass="inputStyle"/><br>


    <form:label path="lastName"><h3 style="margin-left: 40%;">Teacher's last name: </h3></form:label>
    <font style="color: red"><form:errors path="lastName" cssStyle="margin-left: 40%"/></font>
    <form:input path="lastName" cssClass="inputStyle"/><br>


    <label><h3 style="margin-left: 40%;">Birth date: </h3></label>
    <input type="date" name="birthDate" class="inputStyle"><br>


    <form:label path="seat"><h3 style="margin-left: 40%;">Teacher's seat:</h3></form:label>
    <form:select path="seat" cssClass="inputStyle">
        <form:option value="аспірант">аспірант</form:option>
        <form:option value="доцент">доцент</form:option>
        <form:option value="професор">професор</form:option>
    </form:select>


    <font style="color: red"><form:errors path="seat" cssStyle="margin-left: 40%"/></font><br>
    <p style="clear:left;"><h3 style="margin-left: 40%;">Faculty:</h3></p>
    <select name="facultySelect" class="inputStyle" ">
        <c:forEach items="${faculties}" var="f">
            <option>${f.name}</option>
        </c:forEach>
    </select>

    <p style="clear:left;"><h3 style="margin-left: 40%";>Subject:</h3></p>
    <select name="subjectSelect" class="inputStyle">
        <c:forEach items="${subjects}" var="s">
            <option>${s.name}</option>
        </c:forEach>
    </select>


    <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
</form:form>
    </div>
</body>
</html>
