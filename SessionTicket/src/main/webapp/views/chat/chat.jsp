<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 17.11.2016
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">

    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css'>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans'>
    <link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/jScrollPane/2.0.14/jquery.jscrollpane.min.css'>
    <link rel="stylesheet" href="/resources/css/forChat.css" media="screen" type="text/css" />

</head>

<body>

<sec:authorize access="isAuthenticated()">
    Hello, <p id = "initializedUser"><sec:authentication property="name"/></p>
    <form:form method="post" action="/logout">
        <button type="submit">Вийти</button>
    </form:form>
</sec:authorize>

<div class="window-wrapper">
    <div class="window-title">
        <div class="dots">
            <i class="fa fa-circle"></i>
            <i class="fa fa-circle"></i>
            <i class="fa fa-circle"></i>
        </div>
        <div class="title">
            <span>Чат</span>
        </div>
        <div class="expand">
            <i class="fa fa-expand"></i>
        </div>
    </div>
    <div class="window-area">
        <div class="conversation-list">
            <ul class="">
                <li class="item"><a href="#"><i class="fa fa-list-alt"></i><span>Учасники</span></a></li>
            </ul>

            <select id = "usersToAdmin" onchange="changedUser()">
                <c:forEach items="${users}" var="u">
                    <option>${u.id}</option>
                </c:forEach>
            </select>
        </div>

        <div class="chat-area">
            <div class="title"><b>Переписка</b><i class="fa fa-search"></i></div>
            <div class="chat-list" id = "massages" style="overflow: scroll">


                <!--

                ТУТ САМА ПЕРЕПИСКА



                	<ul>
                        <li class="me">
                            <div class="name">
                                <span class="">Kristi Galeeva</span>
                            </div>
                            <div class="message">
                                <p>Hey, do you like the new interface? It's done with Font Awesome.</p>
                                <span class="msg-time">5:00 pm</span>
                            </div>
                        </li>
                        <li class="">
                            <div class="name">
                                <span class="">David Barto</span>
                            </div>
                            <div class="message">
                                <p><span class="blue-label">Kristi Galeeva</span> I see what you did there.</p>
                                <span class="msg-time">5:01 pm</span>
                            </div>
                        </li>
                        <li class="me">
                            <div class="name">
                                <span class="">Kristi Galeeva</span>
                            </div>
                            <div class="message">
                                <p>Feel free to look at the code if you want.</p>
                                <span class="msg-time">5:02 pm</span>
                            </div>
                        </li>
                -->
            </div>
        </div>

        <!--<div class="right-tabs">
                <ul class="tabs">
                    <li class="active">
                        <a href="#"><i class="fa fa-users"></i></a>
                    </li>
                    <li><a href="#"><i class="fa fa-paperclip"></i></a></li>
                    <li><a href="#"><i class="fa fa-link"></i></a></li>
                </ul>
                <ul class="tabs-container">
                    <li class="active">
                        <ul class="member-list">
                            <li><span class="status online"><i class="fa fa-circle-o"></i></span><span>Kristi Galeeva</span></li>
                            <li><span class="status online"><i class="fa fa-circle-o"></i></span><span>Segey Bondar</span></li>
                            <li><span class="status idle"><i class="fa fa-circle-o"></i></span><span>Gleb Kavrasky</span><span class="time">10:45 pm</span></li>
                            <li><span class="status offline"><i class="fa fa-circle-o"></i></span><span>David Barto</span></li>
                        </ul>
                    </li>
                    <li></li>
                    <li></li>
                </ul>
                <i class="fa fa-cog"></i>
            </div>-->
    </div>
</div>

<div style="width:60%; height:50px; float:left;margin-left:20%; margin-bottom: 100px;">
  <%--  <div class="input-area">
        <div class="input-wrapper">
            <textarea id = "messageId" name="userTextForMessage" cols="200" style="width: 80%; height: 100%; margin-left: 10%; margin-top: 5%;"></textarea>
            <i class="fa fa-smile-o"></i>
            <i class="fa fa-paperclip"></i>
        </div>
        <input type="button" value="Ввод" class="send-btn" onclick="sendMessage1()">
    </div>--%>

      <div class="input-wrapper" style="margin-top: -50px;">
          <textarea id = "messageId" name="userTextForMessage" cols="200" style="width: 80%; height: 100%; margin-left: 10%; margin-top: 5%;"></textarea>
          <i class="fa fa-smile-o"></i>
          <i class="fa fa-paperclip"></i>
      </div>
      <input type="button" value="Ввод" style="background: darkslategrey; color: white; border-radius: 10%; height: 30px; margin-left: 80%;" onclick="sendMessage1()">
</div>



<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script><script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-mousewheel/3.1.11/jquery.mousewheel.min.js'></script><script src='http://cdnjs.cloudflare.com/ajax/libs/jScrollPane/2.0.14/jquery.jscrollpane.min.js'></script>


<script>
    function hiddenOrNo() {
        var inner = document.getElementById('initializedUser').innerHTML;
        if (inner != "1")
            document.getElementById("usersToAdmin").hidden = true;
        else document.getElementById("usersToAdmin").hidden = false;
    }
    var id1 = setInterval("hiddenOrNo()",1000);
</script>


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
                    elemData.style = "font-size:12px;margin-top:20px;margin-left:10%;float:left;margin-botom:20px;"
                    elemData.innerHTML = v.data;
                    document.getElementById("massages").appendChild(elemData);



                    if (v.fromUser)
                        elem.style = "background-color: #e4eaee; width:70%; height:auto;float:left; margin-top:10px;";
                    else elem.style = "background-color: #e4eaee; width:70%; height:auto;float:left; margin-top:10px; margin-left:20%";



                    document.getElementById("massages").appendChild(elem);


                    var divNew = document.createElement("div");
                    divNew.style = "padding: 14px;border-left: 1px solid #cfdae1;float: left;color: black; width: 214px;";

                    var elemText = document.createElement("p");
                    elemText.innerHTML = v.text;
                    divNew.appendChild(elemText);

                    elem.appendChild(divNew);
                    var myDivMessages = document.getElementById('massages');
                    myDivMessages.appendChild(elem);
                    myDivMessages.scrollTop = myDivMessages.scrollHeight;
                });
            }
        });
    }
</script>


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
    function sendMessage1(){
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
                changedUser();
            }
        });
    }
</script>




<%--<script>
    function sendMessage1(){
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


                var mainDiv = document.getElementById("massages");
                var elem = document.createElement("div");
                elem.style = "background-color: #e4eaee; width:70%; height:auto;float:left; margin-top:10px;";


                var divNew = document.createElement("div");
                divNew.style = "padding: 14px;border-left: 1px solid #cfdae1;float: left;color: white; width: 214px;";

                var elemText = document.createElement("p");
                elemText.innerHTML = $("#messageId").val();
                divNew.appendChild(elemText);
                elem.appendChild(divNew);
                mainDiv.appendChild(elem);

                changedUser();
            }
        });
    }
</script>--%>



</body>

</html>
