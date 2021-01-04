package uk.ac.cf.nsa.web.phyt.exercises.forms;

//Class for data received from the Create Exercise form
public class ExerciseForm {

    //UserEntity user;
    int userID;
    String exerciseName;
    String exerciseDesc;
    String exerciseCat;

    //Constructor
    public ExerciseForm( String exerciseName, String exerciseDesc, String exerciseCat) {
        //todo - figure out how to get  user entity from log in details
        //this.user = user;
        this.userID = 1;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
    }


    //Getters
    public int getUserID(){
        return userID;
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


    @Override
    public String toString() {
        return "ExerciseForm{" +
                "trainerID=" + userID +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseDesc='" + exerciseDesc + '\'' +
                ", exerciseCat='" + exerciseCat + '\'' +
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

}
