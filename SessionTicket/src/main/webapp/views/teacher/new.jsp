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
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<div class="headForForms">
</div>
<div class="forms">
<p><h3 style="margin-left: 40%; color: darkorchid;">Add a new teacher</h3></p>
<form:form action="/createTeacher" method="post" modelAttribute="newTeacher">

    <form:label path="name"><h3 style="margin-left: 40%;">Teacher's name: </h3></form:label>
    <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font>
    <form:input path="name" cssStyle="width:200px;font-size: 18px;  border-radius: 8px;
             background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;" /><br>


    <form:label path="lastName"><h3 style="margin-left: 40%;">Teacher's last name: </h3></form:label>
    <font style="color: red"><form:errors path="lastName" cssStyle="margin-left: 40%"/></font>
    <form:input path="lastName" cssStyle="width:200px;font-size: 18px;  border-radius: 8px;
             background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;" /><br>


    <form:label path="age"><h3 style="margin-left: 40%">Teacher's age:</h3></form:label>
    <font style="color: red"><form:errors path="age" cssStyle="margin-left: 40%"/></font>
    <form:input path="age" cssStyle="width:200px;font-size: 18px;  border-radius: 8px;
             background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;" /><br>


    <form:label path="seat"><h3 style="margin-left: 40%;">Teacher's seat:</h3></form:label>
    <form:select path="seat" cssStyle="width:200px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
        <form:option value="aspirant">aspirant</form:option>
        <form:option value="docent">docent</form:option>
        <form:option value="professor">professor</form:option>
    </form:select>


    <font style="color: red"><form:errors path="seat" cssStyle="margin-left: 40%"/></font><br>
    <p style="clear:left;"><h3 style="margin-left: 40%;">Faculty:</h3></p>
    <select name="facultySelect" style="width:200px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
        <c:forEach items="${faculties}" var="f">
            <option>${f.name}</option>
        </c:forEach>
    </select>

    <p style="clear:left;"><h3 style="margin-left: 40%";>Subject:</h3></p>
    <select name="subjectSelect" style="width:200px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
        <c:forEach items="${subjects}" var="s">
            <option>${s.name}</option>
        </c:forEach>
    </select>


    <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
</form:form>
    </div>
</body>
</html>
