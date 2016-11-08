<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 06.11.2016
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <%--<script src="/resources/scripts/autoScrollDown.js"></script>--%>
</head>
<body>
<div style="width: 60%;height: auto;margin-left: 20%;margin-top: 70px;margin-bottom: 90px; border-radius: 0%;float: left;background-color: white; color:black;">
    <%--<p>${examSelected.id}</p>--%>
    <form method="post" action="/editSubject">
        <h3>
            <input id = "idSubjectId" name="idSubject" value="${subjectSelected.id}" readonly="readonly">
                <h4>Предмет: ${subjectSelected.name}</h4>
                <c:forEach items="${subjectSelected.faculties}" var="f">
                <h4>Факультет: ${f.name}</h4>
            </c:forEach>
        </h3>
        <select name = "facultySelect">
            <c:forEach items="${faculties}" var="f">
                <option>${f.name}</option>
            </c:forEach>
        </select>
        <button type="submit">EDIT</button>
    </form>
</div>
</body>
</html>
