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
</head>


<body id = "body">

<form:form method="post" modelAttribute="groupNew" action="/trying">
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
    </select>
    <form:button>OK</form:button>
</form:form>


<script type="text/javascript">
    var groupsArray;
    function doStudentAjax(){
        $("#selectGroup option").remove();
        $.ajax({
            url: '/updateSearchGroup',
            data: ({nameFaculty: $('#nameFaculty').val()}),
            async: false,
            success: function(data){
                /*$('#sizeOfGroup').html(data.split('-').length-1);*/
                /*$('#sizeOfGroup').innerHTML = data.split('-').length-1;*/
                groupsArray = data.split('-');


                for (var i = 0; i < groupsArray.length; i++) {
                    var option = document.createElement("option");
                    var stringId = "nameFacultyP" + i;
                    option.setAttribute("id", stringId);
                    document.getElementById("selectGroup").appendChild(option);

                }

                for (var i = 0; i < groupsArray.length; i++){
                    $('#nameFacultyP'+i).html(groupsArray[i]);
                    console.log(groupsArray[i]);
                }
            }
        });
    }
</script>

<script>
    doStudentAjax();
</script>

</body>
</html>
