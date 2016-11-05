<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 05.11.2016
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div style="width: 60%;height: auto;margin-left: 20%;margin-bottom: 50px;border: 2px solid blueviolet;border-radius: 0%;float: left;background-color: cornsilk; color:black;">
        <%--<p>${examSelected.id}</p>--%>

            <form method="post" action="/deleteExam">
        <h3>
           <%-- <p name = "idExam">${examSelected.id}</p>--%>
            <input name="idExam" value="${examSelected.id}">
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
