<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 09.10.2016
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
</head>
<body>
<div class="headForForms">
</div>
<div class="forms">
    <form:form action="/createFaculty" method="post" modelAttribute="newFaculty">
        <form:label path="name" cssStyle="margin-left: 40%;">Name of faculty: <br></form:label>
        <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font><br>
        <form:input path="name" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>
        <p style="margin-left: 40%"><form:button>OK</form:button></p>
    </form:form>
</div>

<script>
    window.scrollTo(0,500);
</script>
</body>
</html>
