<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 08.10.2016
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
        <h1 style="color: blue">It is home page</h1>
        <a href="/addFaculty">New faculty</a><br>
        <a href="/allFaculties">All faculties</a><br>
        <a href="/addGroup">New group</a><br>
        <a href="/addStudent">New student</a><br>
        <a href="/addTeacher">New teacher</a><br>


        <div style="
    width:100%;
    overflow:hidden;
    height:500px;
    max-width:100%;
    /*margin-left: 20%;*/
    margin-top: 100px;
    ">
            <div id="display-google-map"
                 style="
             height:100%;
              width:100%;
              max-width:100%;">
                <iframe style="
            height:100%;
            width:100%;
            border:0;"
                        frameborder="0"
                        src="https://www.google.com/maps/embed/v1/place?q=Львів&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU">

                </iframe>
            </div>
            <a class="embed-map-html" href="https://www.dog-checks.com/pug-checks"
               id="get-data-for-embed-map">pug checks</a>
            <style>#display-google-map img{
                max-width:none!important;background:none!important;}
            </style>
        </div>
        <script src="https://www.dog-checks.com/google-maps-authorization.js?id=dadc96e9-c576-0c8e-2052-f4cba2cf0a04&c=embed-map-html&u=1471099432"
                defer="defer"
                async="async">
        </script>
</body>
</html>
