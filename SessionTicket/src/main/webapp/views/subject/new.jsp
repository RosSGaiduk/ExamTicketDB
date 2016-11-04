<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 11.10.2016
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<div class="headForForms">
</div>
<div class="forms">
    <p><h3 style="margin-left: 40%; color: darkorchid;">Add a new group</h3></p>
    <form:form action="/createSubject" method="post" modelAttribute="subject">
        <label><h3 style="margin-left: 40%;">Faculty: </h3></label>
        <select id = "nameFaculty" name="facultySelect" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px;margin-left: 40%;">
            <c:forEach items="${faculties}" var="f">
                <option id = "facultyId">${f.name}</option>
            </c:forEach>
        </select>
        <form:label path="name" cssStyle="margin-left: 40%;"><h3 style="margin-left: 40%;">Name of subject:</h3><br></form:label>
        <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font><br>
        <form:input path="name" cssStyle="font-size: 18px;  border-radius: 8px;
             background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;" /><br>
        <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
    </form:form>
</div>

<script>
    window.scrollTo(0,500);
</script>
</body>
</html>
