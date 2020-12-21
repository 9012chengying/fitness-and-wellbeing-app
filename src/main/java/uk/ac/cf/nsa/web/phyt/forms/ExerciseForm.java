package uk.ac.cf.nsa.web.phyt.forms;


//Class for data received from the Create Exercise form
public class ExerciseForm {

    int trainerID;
    String exerciseName;
    String exerciseDesc;
    String exerciseCat;
    String completeMessage;

    //Constructor
    public ExerciseForm(String exerciseName, String exerciseDesc, String exerciseCat) {
        //TODO hardcoded trainer id for now - need to think about how to get trainer id for specific trainer
        this.trainerID = 1;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
        this.completeMessage = "";
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

    public String getCompleteMessage() {
        return completeMessage;
    }

    //Setters
    public void setCompleteMessage(String completeMessage) {
        this.completeMessage = completeMessage;
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
            this.setCompleteMessage("Please complete all of the exercise details.");
            return false;
       } else {
            this.setCompleteMessage("Exercise Successfully Added");
            return true;
        }
    }

}
