<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <link href="<c:url value="/resources/css/hovers.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/formsStyle1.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/googleBanScroll.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <%-- <script src="/resources/scripts/autoScrollDown.js"></script>--%>
</head>
<body style="background-color: gainsboro">

<%--src в image відсутнє, том, що в нас src цього зображення мінятиметься динамічно через ajax--%>


<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<%--ДІВКА, ДЕ ВІДОБРАЖАЮТЬСЯ НАШІ ПОВІДОМЛЕННЯ--%>
<sec:authorize access="isAuthenticated()">
    <div id = "massages" style="width: 40%;height: 400px; margin-left: 30%; margin-bottom: 10px;margin-top: 300px;cursor: hand; background-color: white; overflow: scroll">
            <%--<div style="width: 90%; height: 50px; float: left; background-color: antiquewhite; margin-top: 20px; margin-left: 10%;"></div>
            <div style="width: 90%; height: 50px; float: left; background-color: antiquewhite; margin-top: 20px;"></div>--%>
    </div>

    <div style="width: 40%; height: 150px; margin-left: 30%; background-color: white; float:left; margin-bottom: 200px;">
        <textarea id = "messageId" name="userTextForMessage" cols="200" style="width: 80%; height: 70%; margin-left: 10%; margin-top: 5%;"></textarea>
        <button onclick="sendMessage()" style="margin-top: 10px;">Надіслати</button>
        <!--Цей селект буде доступним лише для адміна, тому функція changedUser надсилатиме дані через ajax
        лише тоді, коли це адмін онлайн, звичайним юзерам не видиме.
        -->
        <select id = "usersToAdmin" onchange="changedUser()">
            <c:forEach items="${users}" var="u">
            <option>${u.id}</option>
            </c:forEach>
        </select>
    </div>
</sec:authorize>


<div style="float:left; background: white; margin-left: 1%; width:15%; margin-top: 50px;">

    <sec:authorize access="isAuthenticated()">
        Hello, <p id = "initializedUser"><sec:authentication property="name"/></p>
        <form:form method="post" action="/logout">
            <button type="submit">Вийти</button>
        </form:form>
    </sec:authorize>


    <sec:authorize access="isAnonymous()">
        <form:form method="post" action="/loginprocessing">
            <br>
            <%--Тут обов'язково має бути username, не email, не name, навіть якщо такого поля немає у юзера--%>
            <input class="inputStyle" name="username" type="text" placeholder="Login" style="margin-left: 1%;"><br><br>
            <input class="inputStyle" id = "password" name="password" type="password" placeholder="Password" style="margin-left: 1%;" onkeydown="doAjax()">
            <br><br>
            <input type="submit" value="Увійти" style="float: left">
            <a href="/addUser"><input type="button" value="Registration" style="float: left; margin-left: 5px;"></a>
            <p id = "strengthValue"></p>
        </form:form>
    </sec:authorize>
</div>


<script>
    function change() {
        changedUser();
    }
</script>

<script>
    function hiddenOrNo() {
        var inner = document.getElementById('initializedUser').innerHTML;
        if (inner != "1")
            document.getElementById("usersToAdmin").hidden = true;
        else document.getElementById("usersToAdmin").hidden = false;
    }
    var id1 = setInterval("hiddenOrNo()",1000);
</script>



<%--<script>
    function updateMessagesBetweenUserAndAdminInTheAdminPage(){
        changedUser();
    }
</script>--%>




<script>
    function changedUser(){
        var el = document.getElementById('massages');
        while ( el.firstChild ) el.removeChild( el.firstChild );

        $.ajax({
            url: "/userChanged",
            async:false,
            data: ({idOfUser: $('#usersToAdmin').val()}),
            dataType:"json",
            success: function(data){
                $.each(data,function(k,v){
                    var elem = document.createElement("div");

                    var elemData = document.createElement("p");
                    elemData.style = "font-size:12px;margin-top:20px;float:left;"
                    elemData.innerHTML = v.data;
                    document.getElementById("massages").appendChild(elemData);

                    if (v.fromUser)
                        elem.style = "width: 90%; height: auto; float: left; background-color: antiquewhite;";
                    else
                        elem.style = "width: 90%; height: auto; float: left; background-color: antiquewhite;margin-left:10%;";
                    document.getElementById("massages").appendChild(elem);



                    var elemText = document.createElement("p");
                    elemText.style = "text-align:center; font-size:12px;"
                    elemText.innerHTML = v.text;
                    elem.appendChild(elemText);

                    var myDivMessages = document.getElementById('massages');
                    myDivMessages.scrollTop = myDivMessages.scrollHeight;
                });

            }
        });
    }
</script>



<%-- <script>
     function checkMessagesBetweenUsersAndAdmin(){
         if (document.getElementById('initializedUser').innerHTML == "1")
         {
                     randomMessageFromRandomUser();
         }
     }
     var id = setInterval("checkMessagesBetweenUsersAndAdmin()",10000);
 </script>--%>

<script>
    function userInit() {
        alert(document.getElementById('initializedUser').innerHTML);
    }
    //var id1 = setInterval("userInit()",10000);
</script>




<script>
    function randomMessageFromRandomUser(){
        $.ajax({
            url:"/randomMessageFromRandomUser",
            data: ({}),
            async:false,
            success: function(data){
                var values = data.split("~");

                if (values[0] == $('#usersToAdmin').val()) {
                    var elem = document.createElement("div");
                    elem.style = "width: 90%; height: auto; float: left; background-color: antiquewhite; margin-top: 10px;";
                    document.getElementById("massages").appendChild(elem);


                    var elemText = document.createElement("p");
                    elemText.style = "text-align:center; font-size:12px;"
                    elemText.innerHTML = values[1];
                    elem.appendChild(elemText);

                    var myDivMessages = document.getElementById('massages');
                    myDivMessages.scrollTop = myDivMessages.scrollHeight;
                }
            }
        })
    }
</script>

<%--<script>
    function funcAdm(){
        var auth = <sec:authentication property="name"/>;
        changedUser();
    }
    var id1 = setInterval("funcAdm()",1000);
</script>--%>



<!--Ця функція обвляє повідомлення між юзером та адміном причом з обох сторін-->
<script>
    function update(){
        var initialized = document.getElementById('initializedUser').innerHTML;
        var intInit = parseInt(initialized);
        //alert(intInit);
        if (initialized!="1"){
            $("#usersToAdmin :nth-child("+intInit+")").attr("selected", "selected");
        }
        $.ajax({
            url: "/update",
            data: ({
                idUser:$("#usersToAdmin").val(),
                size: $("#massages").children().length/2, //чомусь дає в 2 рази більше
            }),
            async:false,
            success: function(data){
                if (data == "true") {
                    changedUser();
                }
            }
        });
    }
    var id = setInterval("update()",1000);
</script>


<script>
    function sendMessage(){
        //Виконується для юзерів і адміна при натисканні на кнопку Надіслати
        //var valueOfId;
        //if (document.getElementById('initializedUser').innerHTML="1")
         //      valueOfId = $("#usersToAdmin").val();
        //else valueOfId = document.getElementById('initializedUser').innerHTML;
        $.ajax({
            url: "/messageFromUser",
            data:(
            {
                message:$("#messageId").val(),
                idUser:$("#usersToAdmin").val()
            }),
            async:false,
            success: function(data){
                var auth = <sec:authentication property="name"/>;
                var elem = document.createElement("div");
                elem.style = "width: 90%; height: auto; float: left; background-color: antiquewhite; margin-top: 10px; margin-left:10%";
                document.getElementById("massages").appendChild(elem);

                var elemText = document.createElement("p");
                elemText.style = "text-align:center; font-size:12px;"
                elemText.innerHTML = $("#messageId").val();
                elem.appendChild(elemText);

                var myDivMessages = document.getElementById('massages');
                myDivMessages.scrollTop = myDivMessages.scrollHeight;
                document.getElementById("messageId").value = "";

                //alert($("#usersToAdmin").val());
                changedUser();

                //updateMessagesBetweenUserAndAdminInTheAdminPage()();
                //alert($("#usersToAdmin").val());
                //changedUser();
                /*checkMessagesBetweenUsersAndAdmin();*/
            }
        });
    }
</script>
</body>
</html>
