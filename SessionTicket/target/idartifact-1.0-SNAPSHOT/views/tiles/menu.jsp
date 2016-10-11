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

<ul id="nav" style="margin-left: 20%">
    <li>
        <a href="#" title="Service and information about faculty">Faculty</a>
        <ul>
            <li><a href="/allFaculties">All</a></li>
            <li><a href="/addFaculty">Add</a></li>
        </ul>
    </li>


    <li>
        <a href="#" title="Group service">Group</a>
        <ul>
            <li><a href="/addGroup">Add</a></li>
        </ul>
    </li>

    <li>
        <a href="#" title="Subject">Subject</a>
        <ul>
            <li><a href="/allSubjects">All</a></li>
            <li><a href="/addSubject">Add</a></li>
        </ul>
    </li>

    <li>
        <a href="#" title="Student service">Student</a>
        <ul>
            <li><a href="/">All</a></li>
            <li><a href="/addStudent">Add</a></li>
            <li><a href="#">Find student</a></li>
        </ul>
    </li>
    <li>
        <a href="#" title="Teacher service">Teacher</a>
        <ul>
            <li><a href="/allTeachers">All</a></li>
            <li><a href="/addTeacher">Add</a></li>
        </ul>
    </li>
</ul>
</body>
</html>
