//Exercise Description Window

function openWin(exerciseLink) {
    window.open(exerciseLink, '_self');
}

function closeWin() {
    window.history.go(-1);
    return false;
}

//Start and stop timer
let secondIncrease = setInterval(timer, 1000); //timeout is taken from workoutLength - th:data-id
let sec = 0;
function pad ( val ) {
    return val > 9 ? val : "0" + val;
}
function timer() {
    $("#seconds").html(pad(++sec%60));
    $("#minutes").html(pad(parseInt(sec/60,10)));
}
function stopTimer() {
    clearInterval(secondIncrease);
}
function workoutComplete(workoutLength) {
    setTimeout(stopTimer, workoutLength);
    //congratulations you've completed the workout message
    //automatically updates database to show completed
    //sends message to trainer
    console.log("workout complete initiated");
}