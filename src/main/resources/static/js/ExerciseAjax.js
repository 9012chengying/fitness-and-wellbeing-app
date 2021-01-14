
//Function to send Delete method request to RestController
function deleteExercise() {

    //obtains exercise-id from the data-id in the exercise container
    let params = document.getElementById("exercise-container").getAttribute("data-id").valueOf();
    
    //Opens new request to the delete URL including the exercise id as a paramater
    let xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", '/trainer/exercises/delete/'+params, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            console.log(xhttp.responseText);

            //displays either success or fail message depending on returned responseText
            if(xhttp.responseText === "success"){
                document.getElementById("deleteExerciseModal").style.display="none";
                document.getElementById("exercise-container").style.display="none";
                document.getElementById("successMessageModal").style.display="block";
            } else {
                document.getElementById("exercise-container").style.display="none";
                document.getElementById("failedMessageModal").style.display="block"
            }
        } else {
            console.error(xhttp.statusText);
        }
    };
    xhttp.send();
    return false;
}
