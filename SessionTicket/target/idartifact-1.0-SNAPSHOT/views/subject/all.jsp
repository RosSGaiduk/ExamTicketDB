<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 11.10.2016
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
        <c:forEach items="${subjects}" var="s">
            <a href="/subject/${s.id}">
            <div style="width: 20%; height: auto; float: left;margin-left: 4%; color: black; margin-top: 20px; margin-bottom: 20px; background-color: white;">
            <h4>Предмет: ${s.name}</h4>
                <c:forEach items="${s.faculties}" var="f">
                <h4>Факультет: ${f.name}</h4>
                </c:forEach>
            </div>
            </a>
        </c:forEach>
</body>
</html>
