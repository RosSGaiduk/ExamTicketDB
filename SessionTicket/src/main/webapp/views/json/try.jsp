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
    <p id = "namee"></p>
    <input id="name1" onkeyup="doAjax()">

    <div id = "divs" style="width: 100%; height: auto; float: left;"></div>
<script>
  /*
    document.getElementById("name").innerHTML =
            obj.employees[1].name + " " + obj.employees[1].age;*/
/*  ПРАЦЮЄ
var text = '{ "employees" : [' +
          '{ "firstName":"John" , "lastName":"Doe" },' +
          '{ "firstName":"Anna" , "lastName":"Smith" },' +
          '{ "firstName":"Peter" , "lastName":"Jones" } ]}';

  var obj = JSON.parse(text);
  document.getElementById("name").innerHTML =
          obj.employees[1].firstName + " " + obj.employees[1].lastName;*/

 function doAjax(){
     $.ajax({
         dataType: "json",
         url: "/jsonTry",
         async: false,
         data: {name: $('#name1').val()},
         success: function(json) {
             var htmlStr = '';
             var count = 0;
             $.each(json, function(k, v){
                count++;
                 var myDiv = document.createElement("div");
                 var stringId = "information" + count;
                 myDiv.setAttribute("id", stringId);
                 myDiv.style = "width: 60%;height: auto;margin-left: 20%;margin-bottom: 50px;border: 2px solid blueviolet;border-radius: 0%;float: left;background-color: cornsilk;";
                 document.getElementById("divs").appendChild(myDiv);

                 $('#information'+count).html(v.name+" "+ v.age);
                 htmlStr += v.name + ' ' + v.age;
             });
             $("#namee").html(htmlStr);
         }
     });
 }
</script>

</body>
</html>
