/**
 * Created by Rostyslav on 04.11.2016.
 */
/**
 * Created by Rostyslav on 04.11.2016.
 */
var count = 0;
var was = false;
function myFunct_1(){
    /*document.write("<p>"+counter+"</p>");*/
    if (window.pageYOffset.valueOf()<550 && !was) {
        count++;
        $(window).scrollTop(3 * count);
        /*$('#offsetY').html(window.pageYOffset);*/
    } else {
        was = true;
    }
}
var id = setInterval("myFunct_1()", 1);