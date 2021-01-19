//Exercise Description Window

function openWin(exerciseLink) {
    window.open(exerciseLink, '_self');
}

function closeWin() {
    window.history.go(-1);
    return false;
}

//Timer

window.onload = function() {

    //to be replaced with values from database
    let seconds = 3;
    let rest = true;
    let interval;
    let exerciseIndex = 0;
    let exerciseCount = 4;
    let repIndex = 1;
    let repTotal = 3;
    let exerciseLength = 4;
    let restLength = 3;
    let repRest = 5;
    let startButton = document.getElementById("startButton");
    let stopButton = document.getElementById("stopButton");
    let resetButton = document.getElementById("resetButton");
    let statusHeader = document.getElementById("statusHeader");
    let secondsSpan = document.getElementById("sec");
    let exerciseArrayList = ["exercise1", "exercise2", "exercise3", "exercise4"];

    startButton.onclick = function() {
        rest = true;
        start();
        interval = setInterval(countdownSeconds, 1000);
        $("#startButton").css("display","none");
        $("#stopButton").css("display","inline-block");
        $("#resetButton").css("display","inline-block");
    }

    resetButton.onclick = function() {
        clearInterval(interval);
        rest = true;
        start();
        interval = setInterval(countdownSeconds, 1000);
    }

    stopButton.onclick = function() { //need to figure out how to get button to continue where it left off
        clearInterval(interval);
    }

    function start() {
        $("body").css("background","yellow");
        statusHeader.innerText = "Get Ready";
    }

    function countdownSeconds() {
        seconds -= 1;
        secondsSpan.innerText = seconds;
        checkForStateChange();
    }

    function checkForStateChange() {
        if (exerciseIndex < exerciseCount) { /*checks this for 1 second then switches to long rest on last one*/
            if (seconds == 0 && rest == false) {
                seconds = restLength + 1;
                rest = true;
                exerciseIndex += 1;
                setTimeout(changeToRest, 1000);
            } else if (seconds == 0 && rest == true) {
                seconds = exerciseLength + 1;
                rest = false;
                setTimeout(changeToExercise, 1000);
            }
        } else if (exerciseIndex == exerciseCount && repIndex < repTotal) {
            seconds = repRest +1;
            rest = true;
            exerciseIndex = 0;
            repIndex += 1;
            setTimeout(changeToRepRest, 1000);
        } else if (exerciseIndex == exerciseCount - 1 && repIndex == repTotal) {
            clearInterval(interval);
            //congratulations you've completed the workout message
            //automatically updates database to show completed
            //sends message to trainer
        }
    }

    function changeToRest() {
        $("body").css("background","skyblue");
        statusHeader.innerText = "Rest";
    }

    function changeToRepRest() {
        $("body").css("background","yellow");
        statusHeader.innerText = "Long Rest";
    }

    function changeToExercise() {
        $("body").css("background", "pink");
        statusHeader.innerText = exerciseArrayList[exerciseIndex];
        }
}