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
    <link href="<c:url value="/resources/css/formsStyle1.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <script src="/resources/scripts/autoScrollDown.js"></script>
</head>
<body id = "body">
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
        <select class="inputStyle" id = "nameFaculty" name="facultySelect" onchange="doGroupAjax()"/>
            <c:forEach items="${faculties}" var="f">
                <option id = "facultyId">${f.name}</option>
            </c:forEach>
        </select>

        <label><h3 style="margin-left: 40%;">Group: </h3></label>
        <select id = "selectGroup" name="groupSelect" onchange="doSubjectAjax()" class="inputStyle">
        </select>

        <label><h3 style="margin-left: 40%;">Subject: </h3></label>
        <select id = "selectSubject" name="subjectSelect" onchange="doTeacherAjax()" class="inputStyle">
        </select>

        <label><h3 style="margin-left: 40%;">Teacher: </h3></label>
        <select id = "selectTeacher" name="teachers" class="inputStyle">
        </select>

        <label><h3 style="margin-left: 40%;">Date: </h3></label>
        <input name="dateCalendar" type="date" class="inputStyle"/>
        <br>


        <label><h3 style="margin-left: 40%">Time:</h3></label>
        <input type="time" name="timeForExam" class="inputStyle"/>

        <p style="margin-left: 40%"><button type="submit" id = "buttonSend" style="width:50px; height: 30px;border-radius:20%;">OK</button></p>
    </form:form>
</div>

<p id = "offsetY"></p>

<script type="text/javascript">
    var groupsArray;
    function doGroupAjax(){
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
                    if (subjectsArray.length == 1 && subjectsArray[0] == "") {
                        $('#nameOfSubject' + i).html("exams are ready for this group");
                        alert("All exams are prepared for this group, you can select " +
                                "one of the existed exams and edit it or delete "+
                                $('#buttonSend').val()+" "+$('#buttonSend').html()+" ");

                       /* $('#buttonSend').html("adsad");*/
                        document.getElementById('buttonSend').disabled = true;
                    }
                    else {
                        $('#nameOfSubject' + i).html(subjectsArray[i]);
                        document.getElementById('buttonSend').disabled = false;
                        console.log(subjectsArray[i]);
                    }
                }
            }
        });
        doTeacherAjax();
    }
</script>

<script>
    function doTeacherAjax(){
        $("#selectTeacher option").remove();
        $.ajax({
            dataType: "json",
            url: "/findTeachersBySubject",
            async: false,
            data: ({
                nameFaculty: $('#nameFaculty').val(),
                nameSubject: $('#selectSubject').val()}),
            success: function(json){
                var count = 0;
                $.each(json, function(k, v) {
                    count++;
                    var option = document.createElement("option");
                    var stringId = "id" + count;
                    option.setAttribute("id", stringId);
                    option.innerHTML = v.name+" " + v.lastName + " " + v.seat;
                    document.getElementById("selectTeacher").appendChild(option);
                });
            }

        });
    }
</script>


<script>
    doGroupAjax();
</script>


<%--<script>
      var count = 0;
      function myFunct_1(){
          /*document.write("<p>"+counter+"</p>");*/
          if (window.pageYOffset.valueOf()<550 && !was) {
              count++;
              $(window).scrollTop(2 * count);
              /*$('#offsetY').html(window.pageYOffset);*/
          } else {
              was = true;
          }
      }
          var id = setInterval("myFunct_1()", 5);
</script>--%>




</body>
</html>
