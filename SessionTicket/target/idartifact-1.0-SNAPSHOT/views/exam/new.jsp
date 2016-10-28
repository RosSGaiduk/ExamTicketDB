<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 11.10.2016
  Time: 19:59
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
<sql:setDataSource var="mysrc" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/examlnu"
                   user="root"  password="123456root"/>



<div class="headForForms">
</div>
<div class="forms">
    <p><h3 style="margin-left: 40%; color: darkorchid;">Add a new exam</h3></p>
    <form:form action="/createExam" method="post" modelAttribute="newExam">
        <label><h3 style="margin-left: 40%;">Faculty: </h3></label>
        <%--<font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font><br>--%>
        <%--<form:input path="date" cssStyle="margin-left: 40%;"/>--%>
        <select id = "nameFaculty" name="facultySelect" onchange="doStudentAjax()" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px;margin-left: 40%;">
            <c:forEach items="${faculties}" var="f">
                <option id = "facultyId">${f.name}</option>
            </c:forEach>
        </select>

        <label><h3 style="margin-left: 40%;">Group: </h3></label>
        <select id = "selectGroup" name="groupSelect" onchange="doSubjectAjax()" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
        </select>

        <label><h3 style="margin-left: 40%;">Subject: </h3></label>
        <select id = "selectSubject" name="subjectSelect" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
        </select>

        <label><h3 style="margin-left: 40%;">Date: </h3></label>
        <input name="dateCalendar" type="date" style="margin-left:40%;
        height: 35px; font-size: 18px;border-radius: 3px;
        padding: 0 3px;"/>
        <br>
        <form:label path="hour" cssStyle="margin-left: 40%;"><h3 style="margin-left: 40%;">Hour:</h3><br></form:label>
        <form:input path="hour" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; "/>
        <form:label path="minute" cssStyle="margin-left: 40%;"><h3 style="margin-left: 40%;">Minute:</h3><br></form:label>
        <form:input path="minute" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;"/>


        <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">OK</form:button></p>
    </form:form>
</div>


<script type="text/javascript">
    var groupsArray;
    function doStudentAjax(){
        $("#selectGroup option").remove();
        $.ajax({
            url: '/updateSearchGroup',
            data: ({nameFaculty: $('#nameFaculty').val()}),
            async: false,
            success: function(data){
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
        doSubjectAjax();
    }
</script>


<script type="text/javascript">
    var subjectsArray;
    function doSubjectAjax(){
        $("#selectSubject option").remove();
        $.ajax({
            url: '/updateSearchSubject',
            data: ({nameGroup: $('#selectGroup').val()}),
            async: false,
            success: function(data){
                subjectsArray = data.split('-');
                for (var i = 0; i < subjectsArray.length; i++) {
                    var option = document.createElement("option");
                    var stringId = "nameOfSubject" + i;
                    option.setAttribute("id", stringId);
                    document.getElementById("selectSubject").appendChild(option);
                }
                for (var i = 0; i < subjectsArray.length; i++){
                    $('#nameOfSubject'+i).html(subjectsArray[i]);
                    console.log(subjectsArray[i]);
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
