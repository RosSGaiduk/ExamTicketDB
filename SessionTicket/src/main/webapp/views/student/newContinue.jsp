<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 10.10.2016
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<div class="headForForms">
</div>
<div class="forms">
<form:form action="/createStudentFinished" method="post" modelAttribute="studentContinue">
    <form:label path="name"><h3 style="margin-left: 40%;">Name: </h3></form:label>
    <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font>
    <form:input path="name" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="lastName"><h3 style="margin-left: 40%;">Last name: </h3></form:label>
    <font style="color: red"><form:errors path="lastName" cssStyle="margin-left: 40%"/></font>
    <form:input path="lastName" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="age"><h3 style="margin-left: 40%;">Age: </h3></form:label>
    <font style="color: red"><form:errors path="age" cssStyle="margin-left: 40%"/></font>
    <form:input path="age" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="course"><h3 style="margin-left: 40%;">Course: </h3></form:label>
    <font style="color: red"><form:errors path="course" cssStyle="margin-left: 40%"/></font>
    <form:input path="course" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="form"><h3 style="margin-left: 40%;">Form: </h3></form:label>
    <font style="color: red"><form:errors path="form" cssStyle="margin-left: 40%"/></font>
    <form:input path="form" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <p><h3 style="margin-left: 40%">Groups from faculty:</h3><h3 style="margin-left: 40%">${studentContinue.nameFaculty}</h3></p>
    <select name="groupSelect" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
        <c:forEach items="${groups}" var="g">
            <option>${g.name}</option>
        </c:forEach>
    </select>
    <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
    </form:form>
    </div>
</body>
</html>
