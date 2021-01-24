package uk.ac.cf.nsa.web.phyt.trainer.forms;

import java.util.List;
import java.util.Random;

public class WorkoutExercisesForm {

    private List<Integer> exerciseID;
    private List<String> exerciseThumbnailSrc;
    private int workoutID;
    private String equipment;

    public WorkoutExercisesForm(List<Integer> exerciseID, List<String> exerciseThumbnailSrc, int workoutID, String equipment) {
        this.exerciseID = exerciseID;
        this.exerciseThumbnailSrc = exerciseThumbnailSrc;
        this.workoutID = workoutID;
        this.equipment = equipment;
    }

    public List<Integer> getExerciseID() {
        return exerciseID;
    }

    public int getWorkoutID() {
        return workoutID;
    }

    public String getWorkoutThumbnail() {
        Random random = new Random();
        return exerciseThumbnailSrc.get(random.nextInt(exerciseThumbnailSrc.size()));
    }

    public String getEquipment() {
        return equipment;
    }
}
