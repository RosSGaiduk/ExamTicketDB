<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 21.10.2016
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle.css"/>" type="text/css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

    <script type="text/javascript">
        function doAjax(){
            $.ajax({
                url: '/checkStrength',
                data: ({password: $('#password').val()}),
                success: function(data){
                    $('#strengthValue').html(data);
                }
            });
        }
    </script>

</head>
<body>


        <form:form method="post" modelAttribute="user" action="check-user" cssClass="box login">
                <span style="float:right">
                    <a href="?lang=en">en</a>
                    <a href="?lang=ru">ru</a>
                </span>
                
                
                <form:label path="firstName">
                   <%-- <spring:message code="firstName"/>--%>
                </form:label>
                <form:input path="firstName"/>


                <form:label path="password">
                 <%--   <spring:message code="password"/>--%>
                </form:label>



                <form:password path="password" onkeyup="doAjax()"/>
                <span style="float: right" id = "strengthValue">
                </span>

        </form:form>

</body>
</html>
