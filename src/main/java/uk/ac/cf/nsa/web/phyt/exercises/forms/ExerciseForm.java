package uk.ac.cf.nsa.web.phyt.exercises.forms;

import uk.ac.cf.nsa.web.phyt.exercises.DTO.UserEntity;

//Class for data received from the Create Exercise form
public class ExerciseForm {

    UserEntity user;
    int userID;
    String exerciseName;
    String exerciseDesc;
    String exerciseCat;

    //Constructor
    public ExerciseForm(UserEntity user, String exerciseName, String exerciseDesc, String exerciseCat) {
        this.user = user;
        this.userID = user.getUserID();
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
