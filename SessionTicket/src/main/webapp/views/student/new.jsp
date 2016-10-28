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
<body>

<sql:setDataSource var="mysrc" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/examlnu"
                   user="root"  password="123456root"/>


<div class="headForForms">
</div>
<p>${$query = "SELECT MAX(id) FROM groupp"}</p>
<div class="forms">
<form:form action="/createStudent" method="post" modelAttribute="student">

    <form:label path="name"><h3 style="margin-left: 40%;">Name: </h3></form:label>
    <font style="color: red"><form:errors path="name" cssStyle="margin-left: 40%"/></font>

    <form:input path="name" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="lastName"><h3 style="margin-left: 40%;">Last name: </h3></form:label>
     <font style="color: red"><form:errors path="lastName" cssStyle="margin-left: 40%"/></font>
    <form:input path="lastName" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="age"><h3 style="margin-left: 40%;">Age: </h3></form:label>
     <font style="color: red"><form:errors path="age" cssStyle="margin-left: 40%"/></font>
    <form:input path="age" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="course"><h3 style="margin-left: 40%;">Course: </h3></form:label>
     <font style="color: red"><form:errors path="course" cssStyle="margin-left: 40%"/></font>
    <form:input path="course" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <form:label path="form"><h3 style="margin-left: 40%;">Form: </h3></form:label>
     <font style="color: red"><form:errors path="form" cssStyle="margin-left: 40%"/></font>
    <form:input path="form" cssStyle="font-size: 18px;  border-radius: 8px;
         background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%; " /><br>

    <label><h3 style="margin-left: 40%;">Faculty: </h3></label>

    <select id = "nameFaculty" name="facultySelect" onchange="doStudentAjax()" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px;margin-left: 40%;">
        <c:forEach items="${faculties}" var="f">
            <option id = "facultyId">${f.name}</option>
        </c:forEach>
    </select>

    <label><h3 style="margin-left: 40%;">Group: </h3></label>
    <select id = "selectGroup" name="groupSelect" style="width:250px;font-size: 18px;  border-radius: 8px;
                    background: #F6F6f6; padding: 6px 0 4px 10px; margin-left: 40%;">
    </select>
    <p style="margin-left: 40%"><form:button style="width:50px; height: 30px;border-radius:20%;">NEXT</form:button></p>
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
                /*$('#nameFacultyP0').html(data.split('-')[0]);
                 $('#nameFacultyP1').html(data.split('-')[1]);
                 $('#nameFacultyP2').html(data.split('-')[2]);*/
                /*$('#nameFacultyP').html(data.length); ПРАЦЮЄ, ПОВЕРНЕ ДОВЖИНУ СТРІЧКИ(ЯКЩО МИ ПОВЕРНУЛИ СТРІЧКУ)*/
                /*$('#nameFacultyP').html(data[0]); ПРАЦЮЄ, ПОВЕРНЕ ПЕРШУ БУКВУ СТРІЧКИ (ЯКЩО МИ ПОВЕРНУЛИ СТРІЧКУ)*/
                //за цьою id в тег присвоїться значення data
                /* dataGlobal = data;*/
            }
        });
    }
</script>



<%--<div style="float: left; width: 25%; height: 600px; background-image: url(/resources/img/student.png);
background-size: 100%; background-repeat: no-repeat; margin-bottom: 300px;">
</div>
<div style="width: 60%; height: 600px; float: left">
    <font size="4" face="Verdana"><p style="text-align: justify">Student affairs, student support, or student services is the department or division of services
        and support for students at institutions of higher education to enhance student growth and development in the
        United States and abroad.[1] People who work in this field are known as student affairs practitioners or student
        affairs professionals. These student affairs practitioners work to provide services and support for students at
        institutions of higher education.[1]
        The size and organization of a student affairs division or department may vary based on the size, type, and
        location of an institution. The title of the head of student affairs also varies widely; traditionally in the
        United States, this position has been known as the "dean of students", as distinguished from the academic dean or the
        deans of individual schools with in a university. In some institutions today, student affairs departments are led by
        a vice president or vice chancellor who then reports directly to the president/chancellor of the institution. In other
        cases the head of student affairs may report to the provost or academic dean.
        Although institutions of higher education have had to deal with student affairs in some way for as long as they have existed,
        student affairs as a distinct professional field emerged first in the Anglo-American context in the late 19th century.[2]
        There it developed from the originally distinct positions of "dean of women" and "dean of men". The field developed much
        later in continental Europe, where development first began in the 1950s[3] but was greatly spurred when the Bologna Process
        in the 1990s created a surge in international students with greater needs for student support.[4] Similarly in many other
        countries where student affairs is still a largely inchoate profession, such as Uruguay, professional activity in the field
        has emerged in relation to the needs of international students.[5]
        The profession of student affairs "grew from the campus up, not from theory down".[11] Early higher education in the United
        States was based on the Oxbridge model of education; thus, most early institutions were residential and the tutors lived in
        the halls with the students. These men were the precursor to student affairs professionals in the United States. Typically,
        they served as dean of disclipline and in loco parentis (in place of the parent). These early student affairs practitioners
        focus was on control of the student as opposed to modern philosophy which focuses on the development of the student as a
        whole, but has always connected those interested in the welfare of students with students needing assistance.[11]
        In the late 19th and early 20th centuries, as the number of land-grant institutions increased, enrollment expanded,
        student populations began to include women, the idea of vocationalism began to influence academics and the institution's
        president began to be viewed as "the chief moral front".[12] With these changes it became apparent that additional staff
        members were needed to allow the president to respond to the issues of finance and faculty recruitment.

        These first student affairs professionals were the dean of women, dean of men and personnel workers. Many of the
        early deans came from "teaching roles in the liberal arts".[13] The first Dean of Men as LeBaron Russell Briggs at
        Harvard University in 1890,[14] with the first dean of women being Adelia Johnston in 1869 at the Oberlin College as lady
        principal and later named Dean of Women in 1894.[15] Alice Freeman Palmer in 1892 at the University of Chicago was the first
        to hold the title of Dean of Women.

        The Dean of Men's position typically included discipline, but could vary depending on the institution's overall philosophy.
        The position description might have read, "that officer in the administration who undertakes to assist the men students
        [to] achieve the utmost of which they are individually capable, through personal effort on their behalf, and through
        mobilizing in their behalf all the forces within the University which can be made to serve this end".[16] The one thing
        that remained consistent was the responsibility to deal with men and help them develop to their potential.[17]

        Deans of Women were trail blazers as women in positions of authority. Not only were women at colleges and universities
        a new development, but women as staff members even more new. The institutional leadership was dominated by men, but
        still they persevered including the founding of what is now the American Association of University Women (AAUW) in 1903.
        </p> </font>
</div>
<div style="width: 100%; height: 300px; background-color: aquamarine; float: left;">--%>
<%--</div>--%>
</body>
</html>
