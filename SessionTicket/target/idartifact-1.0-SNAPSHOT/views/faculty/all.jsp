<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 09.10.2016
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
</head>
<body>
    <c:forEach items="${faculties}" var="f">
        <div style="width:20%; height:auto;margin-left: 40%;float: left; border: 1px solid orange;
        ">
            <p>${f.name}</p>
            <%--<img src="C:\Users\Rostyslav\Desktop\+${f.urlImage}" height="30%" width="100%"/>--%>
        </div>
    </c:forEach>
<p style="clear: left;"></p>

    <script>
        window.scrollTo(0,500);
    </script>
</body>
</html>
