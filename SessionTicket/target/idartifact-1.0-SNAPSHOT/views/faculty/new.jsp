<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div style="width: 60%; height: auto; border: 3px double deeppink; margin-left: 20%; margin-top: 50px; margin-bottom: 50px;">
    <form:form action="/createFaculty" method="post" modelAttribute="newFaculty">
        <form:label path="name" cssStyle="margin-left: 40%;">Name of faculty: <br></form:label>
        <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font><br>
        <form:input path="name" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>
        <p style="margin-left: 40%"><form:button>OK</form:button></p>
    </form:form>
    </div>
</head>
<body>

</body>
</html>
