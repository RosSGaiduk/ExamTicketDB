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
<select id="facultyName" onchange="doAjax()" style="font-size: 18px;  border-radius: 8px; margin-bottom: 30px;
         background: #F6F6f6; padding: 6px 0 4px 10px; float: left;">
<c:forEach items="${faculties}" var="f">
    <option>${f.name}</option>
</c:forEach>
</select>

<div id = "divs" style="width: 60%; height: auto; margin-left: 20%; float: left;"></div>
<script>
    function doAjax(){
        var el = document.getElementById('divs');
        while ( el.firstChild ) el.removeChild( el.firstChild );
        $.ajax({
            dataType: "json",
            url: "/sessionsByFaculty",
            async: false,
            data: {facultyName: $('#facultyName').val()},
            success: function (json) {
                var htmlStr = '';
                var count = 0;
                var countExams = 0;
                var countSessions = 0;
                $.each(json, function(k, v){
                    count++;
                    var myDiv = document.createElement("div");
                    var stringId = "information" + count;
                    myDiv.setAttribute("id", stringId);
                    myDiv.style = "width: 20%;height: auto;margin-left: 10px;margin-bottom: 50px;border: 2px solid blueviolet;border-radius: 0%;float: left;background-color: cornsilk;";
                    document.getElementById("divs").appendChild(myDiv);

                    if (countExams < v.count) {
                        var lines = "<h3>" + v.groupp + "<br>" +
                                "<br>" + v.subject + "<br>" +
                                "<br>" + v.date + "<br>" +
                                "<br>" + v.time + "<br>" +
                                "</h3>";
                        countExams++;
                    }
                        $('#information'+count).html(lines);
                    if (countExams >= v.count){
                        countExams = 0;
                        countSessions++;
                        var myDiv = document.createElement("div");
                        myDiv.style = "width: 100%;height: auto;margin-left: 0%;margin-bottom: 50px;border: 2px solid blueviolet;border-radius: 0%;float: left;background-color: cornsilk;";
                        document.getElementById("divs").appendChild(myDiv);
                        myDiv.innerHTML = "Session: "+countSessions;
                    }
                });
            }
        });
    }
</script>

<script>
    window.scrollTo(0,500);
</script>
</body>
</html>
