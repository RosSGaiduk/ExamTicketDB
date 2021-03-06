<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 09.10.2016
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <p><h3 style="margin-left: 40%; color: darkorchid;">Add a new group</h3></p>
        <form:form action="/createGroup" method="post" modelAttribute="grouppP">
            <form:label path="name"><h4 style="margin-left: 40%;">Name of group:</h4></form:label>
            <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font>
            <form:input path="name" cssClass="inputStyle"/><br>
            <p style="clear: left"></p>
            <p><h4 style="margin-left: 40%;">Faculty</h4></p>
            <select name="facultySelect" class="inputStyle">
                    <%--<option>Пункт 1</option>
                    <option>Пункт 2</option>--%>
                <c:forEach items="${faculties}" var="f">
                    <option>${f.name}</option>
                </c:forEach>
            </select>
            <%-- And creating 4 subjects for this group(this group will have exam which includes each of this subjects)--%>
            <p style="clear: left"></p>
            <p><h4 style="margin-left: 40%;">Subject1</h4></p>
            <select name="groupSubject1" class="inputStyle">
                <c:forEach items="${subjects}" var="s">
                    <option>${s.name}</option>
                </c:forEach>
            </select>

            <p style="clear: left"></p>
            <p><h4 style="margin-left: 40%;">Subject2</h4></p>
            <select name="groupSubject2" class="inputStyle">
                <c:forEach items="${subjects}" var="s">
                    <option>${s.name}</option>
                </c:forEach>
            </select>
            <br>
            <p style="clear: left"></p>
            <p><h4 style="margin-left: 40%;">Subject3</h4></p>
            <select name="groupSubject3" class="inputStyle">
                <c:forEach items="${subjects}" var="s">
                    <option>${s.name}</option>
                </c:forEach>
            </select>
            <p style="clear: left;"></p>
            <p><h4 style="margin-left: 40%;">Subject4</h4></p>
            <select name="groupSubject4" class="inputStyle">
                <c:forEach items="${subjects}" var="s">
                    <option>${s.name}</option>
                </c:forEach>
            </select>
            <br>
            <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
            </form:form>
    </div>


<%--<script>
    window.scrollTo(0,500);
</script>--%>
</body>
</html>
