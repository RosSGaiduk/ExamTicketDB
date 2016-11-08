<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<sec:authorize access="isAuthenticated()">
<p>Autowired</p>
</sec:authorize>


<form:form method="post" action="/loginprocessing">
    <%--Тут обов'язково має бути username, не email, не name, навіть якщо такого поля немає у юзера--%>
    <input name="username" type="text" placeholder="Login">
    <input id = "password" name="password" type="password" placeholder="Password" onkeydown="doAjax()">
    <input type="submit" value="Sign in">
    <p id = "strengthValue"></p>
</form:form>

</body>
</html>
