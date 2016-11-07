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
    <link href="<c:url value="/resources/css/hovers.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/googleBanScroll.css"/>" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <script src="/resources/scripts/autoScrollDown.js"></script>
</head>
<body style="background-color: gainsboro">
        <%--src в image відсутнє, том, що в нас src цього зображення мінятиметься динамічно через ajax--%>
        <img id = "writerImg" style="width: 20%; height: 400px; background-size: 100%;
        background-repeat: no-repeat; float: left; margin-top: 35px; margin-bottom: 20px;">

        <div style="width: 60%; height: auto;float: left; background-color: white; margin-left: 2%;">
            <img src="/resources/img/back.png" class="imageWriter" style="float:left;margin-left: 40%; margin-top: 15px; cursor:hand;" width="50" height="50" onclick="doFuncBack()"/>
            <img src="/resources/img/next.png" class="imageWriter" style="float:left;margin-left: 10px; margin-top: 15px; cursor:hand;" width="50" height="50" onclick="doFunc()"/>
            <%--<p style="clear: left"></p>--%>
            <font face="Arial"><p style="text-align: justify;">
                <p id = "count" style="visibility: hidden">${writerCount}</p>
                <h3 id = "page" style="margin-left: 90%"></h3>
               <p id = "biography"></p>
                </p>
            </font><br>
        </div>


        <script>
            var val = 0;
            function doFunc(){
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

       <%-- <img SRC="/resources/img/lnu.jpg" onclick=imgchange(this,"/resources/img/lnu.jpg","/resources/img/student.png")>
        <script>
            var x=false
            function imgchange(obj,imgX,imgY) {
                if  (x){
                    obj.src=imgX
                } else {
                    obj.src=imgY
                }
                x=!x
            }
        </script>--%>
        <div style="width: 110px; height: 110px; float: left; margin-left: 80%; margin-top: 30px;'">
        <img id = "upImage" src="/resources/img/up.png" style="float: left; cursor: hand; margin-bottom: 30px;" onclick="up()">
        </div>

        <script>
            var myBool = false;
            var width = 100.0;
            function up(){
                window.scrollTo(0,500);
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
