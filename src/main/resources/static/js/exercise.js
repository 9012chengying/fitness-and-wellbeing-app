/*Create exercise
Pop up Box for youtube information
 */

function youtube(){
    document.getElementById("youtube-popup-modal").style.display = "block";
}

function closeYoutube(){
    document.getElementById("youtube-popup-modal").style.display="none";
}

//VIEW EXERCISE PAGE
//Function to display modal
function openModal(){
    document.getElementById("deleteExerciseModal").style.display= "block";
}
//Function to close modals
function closeModal(){
    document.getElementById("deleteExerciseModal").style.display= "none";
    document.getElementById("successMessageModal").style.display="none";
    document.getElementById("failedMessageModal").style.display="none";

}


//CREATE EXERCISE - COLLATES INPUT DATA FOR COOKIES IF CANCELS OR DELETES COOKIES IF SUBMITS DATA
function listen(){
    document.getElementById("exercise-submit-button").addEventListener('click' , deleteCookies);
    document.getElementById("exercise-cancel").addEventListener('click', addExercise);
    let exerciseName = getCookie("Exercise Name");
    let exerciseDesc = getCookie("Exercise Description");
    let exerciseCat = getCookie("Exercise Category");
    document.getElementById("exerciseName").value = exerciseName;
    document.getElementById("exerciseDesc").value = exerciseDesc;
    document.getElementById("exerciseCat").value = exerciseCat;
}

function addExercise(){
        let exerciseName = document.getElementById("exerciseName").value;
        let exerciseDesc = document.getElementById("exerciseDesc").value;
        let exerciseCat = document.getElementById("exerciseCat").value;
        setCookie("Exercise Name", exerciseName, 1 );
        setCookie("Exercise Description", exerciseDesc, 1);
        setCookie("Exercise Category", exerciseCat, 1);
    }



//****COOKIES*****

//set up a cookie function to capture cookie data from form
function setCookie(cookieName, cookieValue, exdays){
    let day = new Date();
    day.setTime(day.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+day.toUTCString();
    document.cookie = cookieName+ "=" + cookieValue + ";" + expires + ";path=/trainer/exercises/add";
}

//read cookie data back to client
//From https://www.w3schools.com/js/js_cookies.asp
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

//Delete cookies function
function deleteCookies(){
    document.cookie = "Exercise Name=; expires=Thu, 01 Jan 1901 00:00:00 UTC; path=/trainer/exercises/add;";
    document.cookie = "Exercise Description=; expires=Thu, 01 Jan 1901 00:00:00 UTC; path=/trainer/exercises/add;";
    document.cookie = "Exercise Category=; expires=Thu, 01 Jan 1901 00:00:00 UTC; path=/trainer/exercises/add;";
}