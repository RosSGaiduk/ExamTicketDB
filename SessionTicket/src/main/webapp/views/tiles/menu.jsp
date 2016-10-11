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
</head>
<body>
<div class = "formenu">
</div>
<ul class="main-ul" style="margin-left: 30px;">
    <li><a href="/addFaculty"><span>New faculty</span></a></li>
    <li><a href="#"><span>Faculties</span></a>
        <ul>
            <li><a href="/"><span>Львів</span></a></li>
            <li><a href="/"><span>Тернопіль</span></a></li>
            <li><a href="/"><span>Івано-Франківськ</span></a></li>
            <li><a href="/"><span>Ужгород</span></a></li>
        </ul>
    </li>
    <li><a href="/addGroup"><span>New group</span></a></li>
    <li><a href="/addStudent"><span>New student</span></a></li>
    <li><a href="/addTeacher"><span>New teacher</span></a></li>
    <li><a href="/"><span>Registration</span></a></li>
</ul>

</body>
</html>
