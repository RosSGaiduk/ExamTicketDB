<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 10.10.2016
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <script type="text/javascript">
        function doStudentAjax(){
            $.ajax({
                url: '/updateSearchGroup',
                data: ({nameFaculty: $('#nameFaculty').val()}),
                success: function(data){
                    /*$('#sizeOfGroup').html(data.split('-').length-1);*/
                    /*$('#sizeOfGroup').innerHTML = data.split('-').length-1;*/
                    document.getElementById("sizeOfGroup").innerHTML = data.split('-').length-1;
                    document.getElementById("sizeOfGroup").setAttribute("value",(data.split('-').length-1));
                    document.getElementById("sizeOfGroup").setAttribute("name",(data.split('-').length-1));
                    for (var i = 0; i < data.split('-').length-1; i++){
                        $('#nameFacultyP'+i).html(data.split('-')[i]);
                    }
                    /*$('#nameFacultyP0').html(data.split('-')[0]);
                    $('#nameFacultyP1').html(data.split('-')[1]);
                    $('#nameFacultyP2').html(data.split('-')[2]);*/
                    /*$('#nameFacultyP').html(data.length); ПРАЦЮЄ, ПОВЕРНЕ ДОВЖИНУ СТРІЧКИ(ЯКЩО МИ ПОВЕРНУЛИ СТРІЧКУ)*/
                    /*$('#nameFacultyP').html(data[0]); ПРАЦЮЄ, ПОВЕРНЕ ПЕРШУ БУКВУ СТРІЧКИ (ЯКЩО МИ ПОВЕРНУЛИ СТРІЧКУ)*/
                    //за цьою id в тег присвоїться значення data
                }
            });
        }
    </script>
</head>
<body id = "body">

    <form:form method="post" modelAttribute="student" action="/trying">
        <select id = "nameFaculty" name="facultySelect" onchange="doStudentAjax()" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px;margin-left: 40%;">
            <c:forEach items="${faculties}" var="f">
                <option id = "facultyId">${f.name}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <br>
        <select id = "selectGroup" name="groupSelect" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
            <%--<c:forEach items="${groups}" var="g">
                <option>${g.name}</option>
            </c:forEach>--%>
           <%-- <option id="nameFacultyP0"></option>
            <option id="nameFacultyP1"></option>
            <option id="nameFacultyP2"></option>
            <option id="nameFacultyP3"></option>
            <option id="nameFacultyP4"></option>
            <option id="nameFacultyP5"></option>
            <option id="nameFacultyP6"></option>
            <option id="sizeOfGroup"></option>--%>
        </select>
    </form:form>

    <script>
        /* <p id = "sizeOfGroup"></p>*/
        var elem = document.createElement("p");
        elem.setAttribute("id","sizeOfGroup");
        document.getElementById("body").appendChild(elem);

        /*var c = document.getElementById("sizeOfGroup").innerHTML;*/
        var c = document.getElementById("body").lastChild.nodeType;
        document.write(c);

        /*document.write(document.getElementById("sizeOfGroup").innerHTML);*/

        for (var i = 0; i < 7; i++){
            var option = document.createElement("option");
            var stringId = "nameFacultyP"+i;
            option.setAttribute("id",stringId);
            document.getElementById("selectGroup").appendChild(option);
        }

    </script>

</body>
</html>
