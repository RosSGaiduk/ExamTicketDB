<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
Created by IntelliJ IDEA.
User: Rostyslav
Date: 02.11.2016
Time: 19:44
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
    <c:forEach items="${sessions}" var="s">
            <c:forEach items="${s.exams}" var="e">
                <div style="width: 23%; height: auto; margin-left: 10px; float: left; border: 1px solid crimson; margin-bottom: 10px;">
                    <h3>${e.faculty.name}</h3>
                    <h3>${e.groupP.name}</h3>
                    <h3>${e.subject.name}</h3>
                    <h3>${e.date}</h3>
                    <h3>${e.examTime}</h3>
                </div>
            </c:forEach>
        <%--<p style="clear: left"></p>--%>
        <div style="width:100%; float: left"></div>
    </c:forEach>
</body>
</html>
