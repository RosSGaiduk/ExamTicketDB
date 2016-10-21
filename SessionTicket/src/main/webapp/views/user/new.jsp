<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 21.10.2016
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<div class="headForForms">
</div>

<div class="forms">
    <form:form action="/createUser" method="post" modelAttribute="newUser">

        <form:label path="firstName"><h3 style="margin-left: 40%;">First name: </h3></form:label>


        <form:input path="firstName" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

        <form:label path="lastName"><h3 style="margin-left: 40%;">Last name: </h3></form:label>


        <form:input path="lastName" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

        <label><h3 style="margin-left: 40%;">Date: </h3></label><br>
        <input name="birthDateUser" type="date" style="margin-left:40%;
        height: 35px; font-size: 18px;border-radius: 3px;
        padding: 0 3px;"/>

        <form:label path="email"><h3 style="margin-left: 40%;">Email: </h3></form:label>


        <form:input path="email" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

        <form:label path="password"><h3 style="margin-left: 40%;">Password: </h3></form:label>


        <form:password path="password" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

        <form:label path="confirmPassword"><h3 style="margin-left: 40%;">Confirm password: </h3></form:label>


        <form:password path="confirmPassword" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

        <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>

    </form:form>
</div>
</body>
</html>
