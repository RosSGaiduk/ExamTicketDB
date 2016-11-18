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
<p id = "lnu" style="visibility: hidden">${lnu.urlImage}</p>
<div style="height: 1px">
    <p id = "lnuInformation" style="visibility: hidden;">${lnu.information}</p>
</div>
<%--src в image відсутнє, том, що в нас src цього зображення мінятиметься динамічно через ajax--%>
<img id = "writerImg" style="width: 20%; height: 400px; background-size: 100%;
        background-repeat: no-repeat; float: left; margin-top: 35px; margin-bottom: 20px; position: relative; vertical-align: middle">

<div id = "writerImg1" style="width: 20%;height: 200px;margin-top: 35px;margin-bottom: 20px;position: absolute;margin-top: 500px;background: white;background-size: cover;background-repeat: no-repeat; background-image: url(/resources/img/anotherLnu/anotherLnu1.jpg)"></div>
<div id = "another0" style="width: 10px;height: 10px;margin-bottom: 20px;position: absolute;margin-left: 6%;margin-top: 720px;background-image: url(/resources/img/radiobutton-128.png);background-size: cover;cursor: hand;" onclick="changeImg(this.id)"></div>
<div id = "another1" style="width: 10px;height: 10px;margin-bottom: 20px;position: absolute;margin-left: 8%;margin-top: 720px;background-image: url(/resources/img/radiobutton-128.png);background-size: cover;cursor: hand;" onclick="changeImg(this.id)"></div>
<div id = "another2" style="width: 10px;height: 10px;margin-bottom: 10px;position: absolute;margin-left: 10%;margin-top: 720px;background-image: url(/resources/img/radiobutton-128.png);background-size: cover;cursor: hand;" onclick="changeImg(this.id)"></div>



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
    <div id = "massages" style="width: 20%;height: 300px;margin-bottom: 10px;position: absolute;margin-top: 800px;cursor: hand; background-color: white; overflow: scroll">
            <%--<div style="width: 90%; height: 50px; float: left; background-color: antiquewhite; margin-top: 20px; margin-left: 10%;"></div>
            <div style="width: 90%; height: 50px; float: left; background-color: antiquewhite; margin-top: 20px;"></div>--%>
    </div>

    <div style="width: 20%; height: 150px;margin-top: 1100px; position: absolute; background-color: white;">
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


<div style="width: 60%; height: auto;float: left; background-color: white; margin-left: 2%;">
    <img src="/resources/img/back.png" id = "backArrow" class="imageWriter" style="float:left;margin-left: 40%; margin-top: 15px; cursor:hand;" width="50" height="50" onclick="doFuncBack()"/>
    <img src="/resources/img/next.png" id = "straightArrow" class="imageWriter" style="float:left;margin-left: 10px; margin-top: 15px; cursor:hand;" width="50" height="50" onclick="doFunc()"/>


    <img id = "lnuImage" style="float:left; cursor:hand; visibility: hidden;" width="100%" height="auto">

    <%--<p style="clear: left"></p>--%>
    <font face="Arial"><p style="text-align: justify;">
        <p id = "count" style="visibility: hidden">${writerCount}</p>
        <h3 id = "page" style="margin-left: 90%"></h3>
        <p id = "biography" style="color: black;"></p>
        </p>
    </font><br>
</div>

<p style="float: left; margin-left: 1%;">ЛНУ Франка</p>
<div id = "university" style="width: 15%; height: 220px; float: left;
        background-color: white; margin-left: 1%;
        background-size: cover;
        cursor: hand;
        " onclick="doUniversityAjaxForInfo()">
</div>

<p style="float: left; margin-left: 1%;">Письменники</p>
<div style="width: 15%; height: 300px; float: left;
        background-image: url(/resources/img/manyWriters.jpg);
        background-color: white; margin-top: 10px; margin-left: 1%; background-size: cover;
        cursor: hand;" onclick="doFunc()"></div>

<%-- <div style="float:left; background: white; margin-left: 1%; margin-top: 50px; width: 15%; height: 50px;"></div>--%>
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
                changedUser();
            }
        });
    }
</script>

<script>
    var counter = 0;
    var opacity = 1.0;
    var back = true;
    function changeImg(elem){
        var intLast = parseInt(elem[elem.length-1]);
        var myArr = new Array(2);
        var count = -1;
        for(var i = 0; i < 3; i++){
            if (i!=intLast) {
                count++;
                myArr[count] = "another" + i;
            }
        }
        $('#'+elem).css("background-image","url(/resources/img/radiobutton-128checked.png)");
        for (var i = 0; i < 2; i++)
            $('#'+myArr[i]).css("background-image","url(/resources/img/radiobutton-128.png)");
        $('#writerImg1').css("background-image","url(/resources/img/anotherLnu/anotherLnu"+(intLast+1)+".jpg)");
    }
    function changeImg1(){
        if (back){
            opacity-=0.01;
        } else opacity+=0.01;
        if (opacity<=0){
            back = false;
        }
        if (opacity>=1) back = true;
        $('#writerImg1').css("opacity",opacity);
        if (opacity<=0) {
            var intLast = counter;
            var myArr = new Array(2);
            var count = -1;
            for(var i = 0; i < 3; i++){
                if (i!=intLast) {
                    count++;
                    myArr[count] = "another" + i;
                }
            }
            $("#another"+intLast).css("background-image","url(/resources/img/radiobutton-128checked.png)");
            for (var i = 0; i < 2; i++) $('#'+myArr[i]).css("background-image","url(/resources/img/radiobutton-128.png)");
            $('#writerImg1').css("background-image","url(/resources/img/anotherLnu/anotherLnu"+(intLast+1)+".jpg)");
            back = false;
            counter++;
            counter%=3;
        }
    }
    /* var id1 = setInterval("changeImg1()",50);*/
</script>


<script>
    var universityImage = 1;
    var opacity = 1.0;
    var change = true;
    var backOpacityPlus = false;
    $('#university').css("background-image", "url(/resources/img/lnu/lnu0.jpg)");
    function  doUniversityAjax(){
        $.ajax({
            url: "/changeUniversityImage",
            asynch:false,
            data: ({id: universityImage}),
            success: function(data) {
                //Алгоритм плавної зміни картинок університету Франка
                if (backOpacityPlus) {
                    if (opacity<1) opacity+=0.01;
                    else backOpacityPlus = false;
                }
                if (opacity <= 0) {
                    universityImage++;
                    universityImage %= 5;
                    if (universityImage == 0) universityImage++;
                    change = true;
                    backOpacityPlus = true;
                }
                if (opacity>0 && !backOpacityPlus){
                    change = false;
                    opacity-=0.01;
                }
                if (change)$('#university').css("background-image", "url("+data+")");
                document.getElementById("university").style.opacity = opacity;
            }
        });
    }
    var id = setInterval("doUniversityAjax()", 30);
</script>


<script>
    function  doUniversityAjaxForInfo(){
        var newscr1 = document.getElementById("writerImg");
        newscr1.src = "/resources/img/lnu/lnu3.png";
        newscr1.style.height = 300;
        var backArrow = document.getElementById("backArrow");
        backArrow.style = "visibility:hidden";
        var straightArrow = document.getElementById("straightArrow");
        straightArrow.style = "visibility:hidden";
        $('#page').html("");
        var newscr = document.getElementById("lnuImage");
        newscr.src = "/resources/img/lnu1.jpg";
        newscr.style = "float:left; cursor:hand; margin-top: -60px; width='100%' height='auto'";
        $('#biography').html(document.getElementById("lnuInformation").innerHTML);
    }
</script>



<script>
    var val = 0;
    function doFunc(){
        var newscr = document.getElementById("lnuImage");
        newscr.src = "";
        newscr.style = "visibility: hidden";
        newscr.style.width = 0;
        newscr.style.height = 0;
        var backArrow = document.getElementById("backArrow");
        backArrow.style = "float:left;margin-left: 40%; margin-top: 15px; cursor:hand;";
        var straightArrow = document.getElementById("straightArrow");
        straightArrow.style = "float:left;margin-left: 10px; margin-top: 15px; cursor:hand;";
        val++;
        var str = $('#count').html();
        var count = parseInt(str);
        val%=(count+1);
        if (val == 0) val++;
        $.ajax({
            dataType: "json",
            url: "/changeWriter",
            asynch:false,
            data: ({id: val}),
            success: function(data){
                $.each(data,function(k,v){
                    $('#biography').html(v.biography);
                    $('#page').html("Page "+val);
                    var newscr = document.getElementById("writerImg");
                    newscr.style.height = 400;
                    newscr.src = v.urlImage;
                });
                /*window.scrollTo(0,500);*/
            }
        });
    }
    doFunc();
</script>


<script>
    function doFuncBack(){
        var str = $('#count').html();
        var count = parseInt(str);
        if (val>1) val--;
        else val = count;
        $.ajax({
            dataType: "json",
            url: "/changeWriter",
            asynch:false,
            data: ({id: val}),
            success: function(data){
                $.each(data,function(k,v){
                    $('#biography').html(v.biography);
                    $('#page').html("Page "+val);
                    var newscr = document.getElementById("writerImg");
                    newscr.src = v.urlImage;
                });
            }
        });
    }
</script>

<div style="width: 110px; height: 110px; float: left; margin-left: 80%; margin-top: 30px;'">
    <img id = "upImage" src="/resources/img/up.png" style="float: left; cursor: hand; margin-bottom: 30px;" onclick="up()">
</div>


<script>
    var myBool = false;
    var width = 100.0;
    var interval;
    function up(){
        $('html, body').animate({scrollTop: 0},500);
        return false;
    }
    function func1(){
        if (width>110){
            myBool = true;
        }
        if (width<100){
            myBool = false;
        }
        if (myBool) width-=0.2;
        else width+=0.2;
        document.getElementById('upImage').style.width = width;
    }
    var id = setInterval("func1()", 10);
</script>


<div style="
    width:100%;
    overflow:hidden;
    height:500px;
    max-width:100%;
    margin-top: 100px;
    ">
    <div id="display-google-map"
         style="
             height:100%;
              width:100%;
              max-width:100%;">
        <div class="overlay" onClick="style.pointerEvents='none'"></div>
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