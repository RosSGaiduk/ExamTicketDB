<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 06.11.2016
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <%--<script src="/resources/scripts/autoScrollDown.js"></script>--%>
</head>
<body>

<p style="margin-left: 20%;">Тут можна добавити факультет або предмет для обраного викладача.</p>
<div style="width: 60%;height: auto;margin-left: 20%;margin-bottom: 50px;margin-top:30px;border-radius: 0%;float: left;background-color: white; color:black;">
    <div style="width: 100%; height: auto; margin-left: 30%;">
        <form:form method="post" action="/editTeacher">
        <h3>
            <input id = "idTeacherId" name="idTeacher" value="${teacher.id}" readonly="readonly">
            <p>Ім'я: ${teacher.name}</p>
            <p>Прізвище: ${teacher.lastName}</p>
            <p>Дата народження: ${teacher.birth} ${examSelected.teacher.name}</p>
            <p>Наукове звання: ${teacher.seat}</p>
            <p>Факультети, на яких викладає:</p>
                <c:forEach items="${teacher.faculties}" var="faculties">
                    <p><h5>${faculties.name}</h5></p>
                </c:forEach>
            <p><h3>Предмети:</h3></p>
            <c:forEach items="${teacher.subjects}" var="subject">
                <p><h5>${subject.name}</h5></p>
            </c:forEach>
        </h3>
        <h3>Додати факультет: </h3>
        <select name="addFacultyToTeacher">
            <option>no faculty</option>
            <c:forEach items="${faculties}" var="f">
                <option>${f.name}</option>
            </c:forEach>
        </select>
        <h3>Додати предмет: </h3>
        <select name="addSubjectToTeacher">
            <option>no subject</option>
            <c:forEach items="${subjects}" var="s">
                <option>${s.name}</option>
            </c:forEach>
        </select>
        <button type="submit">EDIT</button>
    </form:form>
    </div>
</div>



</body>
</html>
