<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 11.10.2016
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <script src="/resources/scripts/autoScrollDown.js"></script>
</head>
<body>
<div class="headForForms">
</div>
<div class="forms">
    <select id = "facultyName" onchange="doAjax1()" style="width:350px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px;margin-left: 0%; margin-top: 30px;">
        <c:forEach items="${faculties}" var="f">
            <option id = "facultyId">${f.name}</option>
        </c:forEach>
    </select>

</div>
<h3 id = "teachersText" style="float: left; margin-left: 20%;"></h3>
<div id = "divs" style="width: 100%; height: auto; float: left;"></div>

<script>
    function doAjax1(){
        var el = document.getElementById('divs');
        while ( el.firstChild ) el.removeChild( el.firstChild );
        $.ajax({
            dataType: "json",
            url: "/findTeachersByFaculty",
            async: false,
            data:({nameFaculty: $('#facultyName').val()}),
            success: function (json) {
                var count = 0;
                $('#teachersText').html("<h3>Викладачі факультету '"+ $('#facultyName').val()+"'</h3>");
                $.each(json, function (k, v) {
                    count++;
                    var aId = document.createElement("a");
                    aId.setAttribute("id", "idA"+count);
                    aId.href = "/teacherSelect/"+ v.id;
                    document.getElementById("divs").appendChild(aId);

                    var myDiv = document.createElement("div");
                    var stringId = "information" + count;
                    myDiv.setAttribute("id", stringId);
                    myDiv.style = "width: 60%;height: auto;margin-left: 20%;margin-bottom: 50px;border: 2px solid blueviolet;border-radius: 0%;float: left;background-color: cornsilk; color:black;";
                    document.getElementById("idA"+count).appendChild(myDiv);


                    var lines = "<h4>"+"Прізвище: "+v.lastName + "<br>" + "Ім'я: " + v.name + "<br>"+ "Дата народження: "+v.birth + "<br>" + "Наукове звання: "+v.seat+"<br>"+ "Предмети: "+v.subjects+"</h4>";
                    $("#information"+count).html(lines);
                });
            }
        });
    }
</script>


<script>
    doAjax1();
</script>
</body>
</html>
