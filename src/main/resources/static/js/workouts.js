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

    let interval;
    let rest = true;
    let seconds = 3;
    let exerciseIndex = 0;
    let exerciseCount = exerciseCount;
    let repIndex = 1;
    let repTotal = reps;
    let exerciseLength = exerciseLength;
    let restLength = restLength;
    let repRest = repRest;
    let startButton = document.getElementById("startButton");
    let stopButton = document.getElementById("stopButton");
    let resetButton = document.getElementById("resetButton");
    let instruction = document.getElementById("instruction");
    let secondsSpan = document.getElementById("seconds");
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
        $("body").css("background","#fdfd96");
        instruction.innerHTML = "Get Ready";
    }

    function countdownSeconds() {
        seconds -= 1;
        secondsSpan.innerHTML = seconds;
        checkForStateChange();
    }

    function checkForStateChange() {
        if (exerciseIndex < exerciseCount) {
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
        } else if (seconds == 0 && exerciseIndex == exerciseCount && repIndex < repTotal) {
            seconds = repRest +1;
            rest = true;
            exerciseIndex = 0;
            repIndex += 1;
            setTimeout(changeToRepRest, 1000);
        } else if (exerciseIndex == exerciseCount && repIndex == repTotal) {
            clearInterval(interval);
            instruction.innerHTML = "Workout Complete" //didn't change
            secondsSpan.innerHTML = "Total Time was " + workoutLength;
            //automatically updates database to show completed
            //sends message to trainer
        }
    }

    function changeToRest() {
        $("body").css("background","#63D1F4");
        instruction.innerHTML = "Rest";
    }

    function changeToRepRest() {
        $("body").css("background","#fdfd96");
        instruction.innerHTML = "Long Rest";
    }

    function changeToExercise() {
        $("body").css("background", "pink");
        instruction.innerHTML = exerciseArrayList[exerciseIndex];
        }
}