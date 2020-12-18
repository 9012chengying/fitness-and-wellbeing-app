package uk.ac.cf.nsa.web.phyt.forms;

import java.util.Date;

public class ExerciseForm {

    int trainerID;
    String exerciseName;
    String exerciseDesc;
    String exerciseCat;

    public ExerciseForm(String exerciseName, String exerciseDesc, String exerciseCat) {
        //TODO hardcoded trainer id for now - need to think about how to get trainer id for specific trainer
        this.trainerID = 1;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDesc() {
        return exerciseDesc;
    }

    public void setExerciseDesc(String exerciseDesc) {
        this.exerciseDesc = exerciseDesc;
    }

    public String getExerciseCat() {
        return exerciseCat;
    }

    public void setExerciseCat(String exerciseCat) {
        this.exerciseCat = exerciseCat;
    }

    @Override
    public String toString() {
        return "ExerciseForm{" +
                "trainerID=" + trainerID +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseDesc='" + exerciseDesc + '\'' +
                ", exerciseCat='" + exerciseCat + '\'' +
                '}';
    }

    //validate all information completed
    public boolean validate(){
       if(this.getExerciseName().isEmpty() || this.getExerciseDesc().isEmpty() || this.getExerciseCat().equalsIgnoreCase("Select")){
            return false;
        } else {
            return true;
        }
    }

}
