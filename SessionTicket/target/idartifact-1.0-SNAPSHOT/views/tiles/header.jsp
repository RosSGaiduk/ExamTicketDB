<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 08.10.2016
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/headerStyle.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<div class="forheader">
    <ul class="menu">
        <li style = "float:left;margin-left:60%;"><p><a href = "/" style="color:white; text-decoration:none; font-size:14px;">home</a></p>
        </li>
        <li style = "margin-left:2%;"><p><a href = "#" style="color:white; text-decoration:none; font-size:14px;">categories</a></p>
            <ul class="submenu">
                <li><a href="/newSession">Create session</a></li>
                <li><a href=#>Select faculty</a></li>
                <li><a href=#>Select teachers</a></li>
            </ul>
        </li>
        <li style = "margin-left:2%;"><p><a href = "/addUser" style="color:white; text-decoration:none; font-size:14px;">registration</a></p></li>
        <li style = "margin-left:2%;"><p><a href = "/loginpage" style="color:white; text-decoration:none; font-size:14px;">login</a></p></li>
        <li style = "margin-left:2%;"><p><a href = "#" style="color:white; text-decoration:none; font-size:14px;">about</a></p></li>
    </ul>
</div>
</body>
</html>
