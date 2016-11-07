<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 05.11.2016
  Time: 19:09
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
    <script src="/resources/scripts/autoScrollDown.js"></script>
</head>
<body>
<div style="width: 60%;height: auto;margin-left: 20%;margin-bottom: 60px;border-radius: 0%;float: left;background-color: white; color:black;">
        <%--<p>${examSelected.id}</p>--%>
            <form method="post" action="/deleteExam">
        <h3>
           <%-- <p name = "idExam">${examSelected.id}</p>--%>
            <input id = "idExamId" name="idExam" value="${examSelected.id}" readonly="readonly">
        <p>Group: ${examSelected.groupP.name}</p>
        <p>Subject: ${examSelected.subject.name}</p>
        <p>Teacher: ${examSelected.teacher.lastName} ${examSelected.teacher.name}</p>
        <p>Date: ${examSelected.date}</p>
        <p>Time: ${examSelected.examTime}</p>
        </h3>
        <button type="submit">DELETE</button>
    </form>
</div>


</body>
</html>
