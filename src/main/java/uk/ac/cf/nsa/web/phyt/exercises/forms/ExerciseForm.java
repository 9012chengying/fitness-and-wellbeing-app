package uk.ac.cf.nsa.web.phyt.exercises.forms;

//Class for data received from the Create Exercise form
public class ExerciseForm {

    int exerciseID;
    int userID;
    String exerciseName;
    String exerciseDesc;
    String exerciseCat;
    String exerciseVideo;

    //Constructors
    public ExerciseForm (){
        this.exerciseName = null;
        this.exerciseDesc = null;
        this.exerciseCat = null;
        this.exerciseVideo = null;
    }

    //Constructor for new exercise where no exercise ID exists
    public ExerciseForm( int userID, String exerciseName, String exerciseDesc, String exerciseCat, String exerciseVideo) {
        this.userID = userID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
        this.exerciseVideo = exerciseVideo;
    }

    //Constructor for existing exercise where exercise ID is known
    public ExerciseForm (int userID, int exerciseID, String exerciseName, String exerciseDesc, String exerciseCat){
        this.userID = userID;
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
    }

    public ExerciseForm(int exerciseID, int userID, String exerciseName, String exerciseDesc, String exerciseCat, String exerciseVideo) {
        this.exerciseID = exerciseID;
        this.userID = userID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
        this.exerciseVideo = exerciseVideo;
    }

//Getters & Setters

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseDesc() {
        return exerciseDesc;
    }

    public String getExerciseCat() {
        return exerciseCat;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setExerciseDesc(String exerciseDesc) {
        this.exerciseDesc = exerciseDesc;
    }

    public void setExerciseCat(String exerciseCat) {
        this.exerciseCat = exerciseCat;
    }

    public String getExerciseVideo() {
        return exerciseVideo;
    }

    public void setExerciseVideo(String exerciseVideo) {
        this.exerciseVideo = exerciseVideo;
    }

    @Override
    public String toString() {
        return "ExerciseForm{" +
                "exerciseID=" + exerciseID +
                ", userID=" + userID +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseDesc='" + exerciseDesc + '\'' +
                ", exerciseCat='" + exerciseCat + '\'' +
                ", exerciseVideo='" + exerciseVideo + '\'' +
                '}';
    }


    //validate all form information has been completed
    public boolean validate(){
        if(this.getExerciseName().isEmpty() || this.getExerciseDesc().isEmpty() || this.getExerciseCat().equalsIgnoreCase("Select")) {
            return false;
       } else {
            return true;
        }
    }

    public String idToString(){
        return Integer.toString(this.getExerciseID());
    }

}
