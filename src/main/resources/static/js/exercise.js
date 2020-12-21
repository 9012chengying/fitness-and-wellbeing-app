
//set up a cookie function to capture cookie data from form
function setCookie(cookieName, cookieValue, exdays){
    let day = new Date();
    day.setTime(day.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+day.toUTCString();
    document.cookie = cookieName+ "=" + cookieValue + ";" + expires + ";path=/trainer/exercises/add";
}

//set cookies from data input
function dataStore(){
    let exerciseName = document.getElementById("exerciseName").value;
    let exerciseDesc = document.getElementById("exerciseDesc").value;
    let exerciseCat = document.getElementById("exerciseCat").value;
    setCookie("Exercise Name", exerciseName, 1 );
    setCookie("Exercise Description", exerciseDesc, 1);
    setCookie("Exercise Category", exerciseCat, 1);
}

//read cookie data back to client - From https://www.w3schools.com/js/js_cookies.asp
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}