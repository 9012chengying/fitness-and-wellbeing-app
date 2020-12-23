package uk.ac.cf.nsa.web.phyt.exercises.forms;


//Class for data received from the Create Exercise form
public class ExerciseForm {

    int trainerID;
    String exerciseName;
    String exerciseDesc;
    String exerciseCat;

    //Constructor
    public ExerciseForm(int trainerID, String exerciseName, String exerciseDesc, String exerciseCat) {
        //TODO hardcoded trainer id for now - need to think about how to get trainer id for specific trainer
        this.trainerID = trainerID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
    }


    //Getters
    public int getTrainerID() {
        return trainerID;
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
                "trainerID=" + trainerID +
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
