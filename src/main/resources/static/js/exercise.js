//create exercise button function
function createExercise(){
    //get values from input fields
    let name=document.getElementById("exerciseName").value;
    let desc=document.getElementById("exerciseDesc").value;
    let cat=document.getElementById("exerciseCat").value;
    let message = document.getElementById("message");

    //check all inputs fields have been completed before submitting
    if((name === "" || name === null) || (desc ==="" || desc === null) || cat ==="select" ){
        message.innerHTML = "Please complete all of the exercise details."
        message.style.color="red";
    }
    else {
        message.innerHTML="";
        var params = 'name='+name+'&desc='+desc+'&cat='+cat;
        //submit data to server
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST",'/trainer/exercises/add', true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.onreadystatechange = function(){
            if(xhttp.readyState === 4 && xhttp.status === 200){
                var text = xhttp.responseText;
                console.log(text);
                message.innerHTML = "Exercise successfully added";
                message.style.color="black";
                document.getElementById("exerciseForm").reset();
            } else {
                console.error(xhttp.statusText);
            }
        };
        xhttp.send(params);
        return false;

    }
}
