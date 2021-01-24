package uk.ac.cf.nsa.web.phyt.trainer.forms;

import java.util.ArrayList;
import java.util.List;

public class WorkoutExercisesForm {

    private List<Integer> exerciseID;
    private int workoutID;

    public WorkoutExercisesForm(List<Integer> exerciseID, int workoutID) {
        this.exerciseID = exerciseID;
        this.workoutID = workoutID;
    }

    public List<Integer> getExerciseID() {
        return exerciseID;
    }

        public int getWorkoutID() {
        return workoutID;
    }
}
