package uk.ac.cf.nsa.web.phyt.trainer.forms;

public class WorkoutExercisesForm {

    private int exerciseID;
    private int workoutID;

    public WorkoutExercisesForm(int exerciseID, int workoutID) {
        this.exerciseID = exerciseID;
        this.workoutID = workoutID;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public int getWorkoutID() {
        return workoutID;
    }
}
