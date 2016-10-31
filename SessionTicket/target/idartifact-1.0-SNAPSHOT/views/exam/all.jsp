<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 30.10.2016
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
</head>
<body id = "body">

<div style="width: 100%; height: 50px; float: left;background-color: blueviolet;">
</div>

<div style="float: left; width: 100%; height: auto">
    <h4>Here there are some inputs.You can use input or some of them to select criterion by which you want to
    get all the exams.
    </h4>
    <h3 style="float: left;">Check faculty </h3>
    <br>
    <br>
    <br>
<select style="font-size: 18px;  border-radius: 8px; width: 20%; margin-bottom: 30px;
         background: #F6F6f6; padding: 6px 0 4px 10px; float: left;" id = "facultyName" type="text" onchange="doAjax()">
    <option>*</option>
    <c:forEach items="${faculties}" var="f">
    <option>${f.name}</option>
</c:forEach>
</select>
    <h3 id = "found" style="color: navy; float: left; margin-left: 10%;"></h3>
</div>
<div id = "divs" style="width: 100%; height: auto; float: left;"></div>
<script>
    function doAjax(){
        var el = document.getElementById('divs');
        while ( el.firstChild ) el.removeChild( el.firstChild );
        $('#found').html("Found: 0 exams");
        $.ajax({
            url: '/searchExamByCriterion',
            data: ({facultyName: $('#facultyName').val()}),
            async: false,
            success: function(data){
                allData = data.split("|");
                $('#found').html("Found: "+allData.length+" exams");
                for (var i = 0; i < allData.length; i++) {
                   var myDivStyle = document.createElement("div");
                   var stringId1 = "divId" + i;
                   myDivStyle.setAttribute("id",stringId1);
                   myDivStyle.style = "width:60%;height:150px;margin-left: 20%;background-color: blueviolet;float: left;";
                   document.getElementById("divs").appendChild(myDivStyle);

                    var myDiv = document.createElement("div");
                    var stringId = "information" + i;
                    myDiv.setAttribute("id", stringId);
                    myDiv.style = "width: 60%;height: auto;margin-left: 20%;margin-bottom: 50px;border: 2px solid blueviolet;border-radius: 0%;float: left;background-color: cornsilk;";
                    document.getElementById("divs").appendChild(myDiv);
                }

                for (var i = 0; i < allData.length; i++){
                    myarr = allData[i].split("\n");
                    var lines = "<h3>"+myarr[0]+"<br>"+
                            "<br>"+myarr[1]+"<br>"+
                            "<br>"+myarr[2]+"<br>"+
                            "<br>"+myarr[3]+"<br>"+
                            "<br>"+myarr[4]+"<br>"+
                            "</h3>";
                    $('#information'+i).html(lines);
                    console.log(allData[i]);
                }
            }
        });
    }
</script>

<script>
    doAjax();
</script>

</body>
</html>
