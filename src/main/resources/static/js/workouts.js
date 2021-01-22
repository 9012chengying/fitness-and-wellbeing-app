//Exercise Description Window

function openWin(exerciseLink) {
    window.open(exerciseLink, '_self');
}

function closeWin() {
    window.history.go(-1);
    return false;
}

//Timer

function timer() {
    console.log("timer initiated");
    let interval;
    let rest = true;
    let seconds = 3;
    let exerciseIndex = 0;
    let exerciseCount = exerciseCountData;
    let repIndex = 1;
    let repTotal = repsData;
    let exerciseLength = exerciseLengthData;
    let restLength = restLengthData;
    let repRest = repRestData;
    let startButton = document.getElementById("startButton");
    let stopButton = document.getElementById("stopButton");
    let resetButton = document.getElementById("resetButton");
    let instruction = document.getElementById("instruction");
    let thumbnail = document.getElementById("timerThumbnail");
    let secondsSpan = document.getElementById("seconds");
    let exerciseArray = exerciseArrayData;
    let thumbnailArray = thumbnailArrayData;

    startButton.onclick = function() {
        console.log(exerciseCount + " is Exercise Count");
        rest = true;
        start();
        interval = setInterval(countdownSeconds, 1000);
        $("#startButton").css("display","none");
        $("#stopButton").css("display","inline-block");
        $("#resetButton").css("display","inline-block");
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
            secondsSpan.innerHTML = "Workout Complete"; //check working - change to modal maybe
            $("#timerHeader").css("visibility","hidden");
            $("#stopButton").css("display","none");
            $("#resetButton").css("display","none");
            $("#timerThumbnail").css("display","none");
            $("#instruction").css("display","none");
            $(".workoutComplete").css("display","block");
            //automatically updates database to show completed
            //sends message to trainer and shows modal
        }
    }

    function start() {
        $("body").css("background","#fdfd96");
        instruction.innerHTML = "Get Ready";
    }

    function changeToRest() {
        $("body").css("background","#63D1F4");
        instruction.innerHTML = "Rest";
        thumbnail.src = "";
    }

    function changeToExercise() {
        $("body").css("background", "pink");
        instruction.innerHTML = exerciseArray[exerciseIndex]; //why is this underlined? works fine
        thumbnail.src = thumbnailArray[exerciseIndex];
    }

    function changeToRepRest() {
        $("body").css("background","#fdfd96");
        instruction.innerHTML = "Rest<br><br>Reps Completed: " + (repIndex - 1) + "<br>Reps To Go: " + (repTotal - repIndex + 1);
        thumbnail.src = "";
    }

    resetButton.onclick = function() { //doesn't work properly - need to fix
        clearInterval(interval);
        rest = true;
        start();
        interval = setInterval(countdownSeconds, 1000);
    }

    stopButton.onclick = function() { //need to figure out how to get button to continue where it left off so it can be a pause button
        clearInterval(interval);
    }
}